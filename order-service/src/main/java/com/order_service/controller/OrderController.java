package com.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.order_service.dto.OrderResponseDTO;
import com.order_service.dto.ProductDTO;
import com.order_service.entity.Order;
import com.order_service.repository.OrderRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository OrderRepository;
	
	@Autowired
	private WebClient.Builder WebClientBuilder;
	
	@PostMapping("/placeOrder")
	public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order){
		return WebClientBuilder.build().get().uri("https://localhost:8081/products"+order.getProductId()).retrieve()
				.bodyToMono(ProductDTO.class).map(ProductDTO->{
					OrderResponseDTO orderResponseDTO=new OrderResponseDTO();
					orderResponseDTO.setOrderId(order.getId());
					orderResponseDTO.setProductId(order.getProductId());
					orderResponseDTO.setQuantity(order.getQuantity());
					orderResponseDTO.setProductName(ProductDTO.getName());
					orderResponseDTO.setProductPrice(ProductDTO.getPrice());
					orderResponseDTO.setTotalPrice(order.getQuantity()*ProductDTO.getPrice());
					OrderRepository.save(order);
					return ResponseEntity.ok(orderResponseDTO);
				});
	}
	
	
	@GetMapping
	public List<Order> getAllOrders(){
		return OrderRepository.findAll();
	}
}

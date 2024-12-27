package com.order_service.dto;



public class OrderResponseDTO {
	private Long orderId;
	private Long productId;
	private Long quantity;
	private double totalPrice;
	
	private String productName;
	private Double productPrice;
	
	public OrderResponseDTO() {}
	
	public OrderResponseDTO(Long orderId, Long productId, Long quantity, double totalPrice, String productName,
			Double productPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
}

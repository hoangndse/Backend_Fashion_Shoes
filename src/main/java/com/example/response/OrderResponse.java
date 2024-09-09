package com.example.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private Long id;
    private String code;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private String address;
    private String ward;
    private String district;
    private String province;
    private String note;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime receivingDate;
    private LocalDateTime updateAtUser;
    private String updateByUser;
    private String paymentMethod;
    private String status;
    private double transportFee;
    private double totalPrice;
    private String pay;
    private List<OrderLineResponse> orderLines;

    public OrderResponse() {
    }

    public OrderResponse(Long id, String code, String fullName, String email, String phoneNumber,
                         String alternatePhoneNumber, String address, String ward, String district, String province,
                         String note, LocalDateTime orderDate, LocalDateTime deliveryDate, LocalDateTime receivingDate
            , LocalDateTime updateAtUser, String updateByUser, String paymentMethod, String status, double transportFee,
                         double totalPrice, String pay, List<OrderLineResponse> orderLines) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.address = address;
        this.ward = ward;
        this.district = district;
        this.province = province;
        this.note = note;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.receivingDate = receivingDate;
        this.updateAtUser = updateAtUser;
        this.updateByUser = updateByUser;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.transportFee = transportFee;
        this.totalPrice = totalPrice;
        this.pay = pay;
        this.orderLines = orderLines;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getUpdateAtUser() {
        return updateAtUser;
    }

    public void setUpdateAtUser(LocalDateTime updateAtUser) {
        this.updateAtUser = updateAtUser;
    }

    public String getUpdateByUser() {
        return updateByUser;
    }

    public void setUpdateByUser(String updateByUser) {
        this.updateByUser = updateByUser;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDateTime receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(double transportFee) {
        this.transportFee = transportFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderLineResponse> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineResponse> orderLines) {
        this.orderLines = orderLines;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}

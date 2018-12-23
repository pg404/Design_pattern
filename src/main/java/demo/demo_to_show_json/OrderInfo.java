package demo.demo_to_show_json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName OrderInfo
 * @Author:Jerry.Liu;
 * @Description://TODO
 * @Package hsbc.groupthree.ordersystem.order.entity
 * @Date 2018/8/16 23:17
 */
public class OrderInfo {

    @JsonProperty(value = "orderid")
    private String orderId;

    @JsonProperty(value = "productname")
    private String productName;

    @JsonProperty(value = "productnumber")
    private int productNumber;

    @JsonProperty(value = "username")
    private String userName;

    @JsonProperty(value = "userphone")
    private String userPhone;

    @JsonProperty(value = "useraddress")
    private String userAddress;

    @JsonProperty(value = "productprice")
    private double productPrice;

    @JsonProperty(value = "orderstatus")
    private int orderStatus;

    @JsonProperty(value = "starttime")
    private String startTime;

    @JsonProperty(value = "totalmoney")
    private double totalMoney;

    public OrderInfo(){}

    public OrderInfo(String orderId, String productName, String userName,
                      String userPhone, String userAddress, int orderStatus,
                      String startTime,double totalMoney) {
        this.orderId = orderId;
        this.productName = productName;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.orderStatus = orderStatus;
        this.startTime = startTime;
        this.totalMoney = totalMoney;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}

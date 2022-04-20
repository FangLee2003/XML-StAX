package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order {

    private String number;

    private String orderDate;

    private String customer;

    private List<Item> items;

    private String email;

    private String phone;

    private String address;

    public Order() {
    }

    public Order(String number, String orderDate, String customer, List<Item> items, String email, String phone, String address) {
        this.number = number;
        this.orderDate = orderDate;
        this.customer = customer;
        this.items = items;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    @XmlAttribute
    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public String getCustomer() {
        return customer;
    }

    public String getEmail() {
        return email;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "item")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @XmlElement(name = "order_date")
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" + "number=" + number + ", orderDate=" + orderDate + ", customer=" + customer + ", items=" + items + ", email=" + email + ", phone=" + phone + ", address=" + address + '}';
    }

}

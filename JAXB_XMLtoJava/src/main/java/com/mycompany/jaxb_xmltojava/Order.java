package com.mycompany.jaxb_xmltojava;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order implements Serializable {

    
    private String number;

  
    private String orderDate;
    
  
    private String customer;
    
    private Item item;
    
  
    private String email;
    
  
    private String phone;
    
   
    private String address;

    public Order() {
    }

    public Order(String number, String orderDate, String customer, Item item, String email, String phone, String address) {
        this.number = number;
        this.orderDate = orderDate;
        this.customer = customer;
        this.item = item;
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

    public Item getItem() {
        return item;
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
    
    @XmlElement
    public void setItem(Item item) {
        this.item = item;
    }
    
    @XmlElement(name="order_date")
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\n\nOrder number="+getNumber()+ ", \nOrder Date=" + getOrderDate() + ", \ncustomer=" + getCustomer() + ", \nitem=" + getItem()+ ", \nEmail=" + getEmail() + ", \nPhone=" + getPhone() + ", \nAddress=" + getAddress();
    }
}

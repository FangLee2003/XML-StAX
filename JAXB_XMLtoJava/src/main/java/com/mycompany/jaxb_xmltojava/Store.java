// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package com.mycompany.jaxb_xmltojava;

// import java.util.ArrayList;
// import java.util.List;
// import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.XmlRootElement;

// /**
//  *
//  * @author Hoahanna
//  */
// @XmlRootElement(name="store")
// public class Store {
    
//     List<Order> orders;
    
//     public List<Order> getOrders() {
//         return orders;
//     }
    
//     @XmlElement(name = "order")
//     public void setOrders(List<Order> orders) {
//         this.orders = orders;
//     }

//     public void add(Order order) {
//         if (this.orders == null) {
//             this.orders = new ArrayList<Order>();
//         }
//         this.orders.add(order);

//     }

//     @Override
//     public String toString() {
//         return "Store{" + "Order=" + orders + '}';
//     }

// }

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hoahanna
 */
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "orders")

public class Orders 
{
  private List<Order> orders = new ArrayList<Order>();
  @XmlElement(name = "order")

  public List<Order > getOrders() {
    return orders;
  }
 
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}

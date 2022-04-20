package com.mycompany.jaxb_xmltojava;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "item")
public class Item implements Serializable {

    private String name;

    private String quantity;

    private String currency;

    private String price;

    public Item() {
        super();
    }

    public Item(String name, String quantity, String currency, String price) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.currency = currency;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setPrice(String price) {
        this.price = price;
    }

    @XmlElement
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @XmlAttribute
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Item [name=" + getName() + ", quantity=" + getQuantity() + ", price=" + getPrice() + ", currency="
                + getCurrency()
                + "]";
    }
}

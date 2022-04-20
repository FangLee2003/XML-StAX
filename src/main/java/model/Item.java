
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "item")
public class Item {

    private String name;

    private String quantity;

    private Price price;

    public Item() {
        super();
    }

    public Item(String name, String quantity, Price price) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
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
    public void setPrice(Price price) {
        this.price = price;
    }

    @XmlElement
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }


}

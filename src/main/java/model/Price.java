package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "price")
public class Price {

    private String currency, price;

    public Price() {
        super();
    }

    public Price(String currency, String price) {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    @XmlValue
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" + "currency=" + currency + ", price=" + price + '}';
    }

}

package com.mycompany.jaxb_xmltojava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "price")
public class Price {
    private String currency;

    public Price() {
        super();
    }

    public Price(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlAttribute
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
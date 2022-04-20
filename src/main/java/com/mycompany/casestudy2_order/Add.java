/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.FileNotFoundException;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamException;

import model.Orders;

/**
 *
 */
public class Add {
    public Orders addElement(String src, Orders orders) throws JAXBException, XMLStreamException, FileNotFoundException {
        orders.getOrders().add(Validate.newOrder());

        Write write = new Write();
        write.writeXML(src, orders);

        return orders;
    }
}

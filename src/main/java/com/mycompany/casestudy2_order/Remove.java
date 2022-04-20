/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamException;

import model.Order;
import model.Orders;

/**
 *
 */
public class Remove {
    public Orders removeElement(String src, Orders orders) throws JAXBException, XMLStreamException, FileNotFoundException {
        String del_num;

        System.out.print("Input number of order to remove: ");
        del_num = Validate.checkInputString();

        for (int i = 0; i < orders.getOrders().size(); i++) {
            if (orders.getOrders().get(i).getNumber().equals(del_num))
                orders.getOrders().remove(i);
        }

        Write write = new Write();
        write.writeXML(src, orders);

        return orders;
    }
}

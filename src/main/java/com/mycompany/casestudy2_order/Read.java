/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Order;
import model.Orders;

/**
 * @author Hoahanna
 */
public class Read {
    public Orders readOrderList(String src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
       return (Orders) jaxbUnmarshaller.unmarshal(file);
    }
}

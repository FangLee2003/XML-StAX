/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamException;
import java.awt.*;
import org.jsoup.Jsoup;

import model.*;

/**
 * @author
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, XMLStreamException, IOException {

        // TODO code application logic here
//        JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
//        Unmarshaller unmar = jaxbContext.createUnmarshaller();
//        JAXBElement<Orders> orders_elements = (JAXBElement<Orders>) unmar.unmarshal(new File("src/main/java/xml/order.xml"));
        Read read = new Read();
        Orders orders = read.readOrderList("src/main/java/xml/order.xml");
        Order new_order;

        while (true) {
            int choice = Validate.menu();

            switch (choice) {
                case 1:
                    orders = read.readOrderList("src/main/java/xml/order.xml");
                    Validate.showList(orders);
                    break;
                case 2:
                    Add add = new Add();
                    orders = add.addElement("src/main/java/xml/order.xml", orders);
                    break;
                case 3:
                    Update update = new Update();
                    orders = update.updateElement("src/main/java/xml/order.xml", orders);
                    break;
                case 4:
                    Remove remove = new Remove();
                    orders = remove.removeElement("src/main/java/xml/order.xml", orders);
                    break;
                case 5:
                    Write write = new Write();
                    write.writeHTML("src/main/java/html/TableTemplate.html", orders);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Does not exist with the entered ID!");
                    System.out.println("Try again");
                    break;
            }
        }
    }
}

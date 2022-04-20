/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.awt.*;
import java.io.*;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import model.Order;
import model.Orders;

/**
 * @author
 */
public class Write {

    public void writeXML(String src, Orders orders) throws XMLStreamException, FileNotFoundException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream(src), "UTF-8");
        XMLEventFactory eventFactory = XMLEventFactory.newFactory();

        XMLEvent event = eventFactory.createStartDocument("UTF-8", "1.0");

        writer.add(event);
        writer.add(eventFactory.createStartElement("", "", "orders"));

        for (Order order : orders.getOrders()) {
            writer.add(eventFactory.createStartElement("", "", "order"));
            writer.add(eventFactory.createAttribute("number", order.getNumber()));

            writer.add(eventFactory.createStartElement("", "", "order_date"));
            writer.add(eventFactory.createCharacters(order.getOrderDate()));
            writer.add(eventFactory.createEndElement("", "", "order_date"));

            writer.add(eventFactory.createStartElement("", "", "customer"));
            writer.add(eventFactory.createCharacters(order.getCustomer()));
            writer.add(eventFactory.createEndElement("", "", "customer"));

            writer.add(eventFactory.createStartElement("", "", "email"));
            writer.add(eventFactory.createCharacters(order.getEmail()));
            writer.add(eventFactory.createEndElement("", "", "email"));

            writer.add(eventFactory.createStartElement("", "", "phone"));
            writer.add(eventFactory.createCharacters(order.getPhone()));
            writer.add(eventFactory.createEndElement("", "", "phone"));

            writer.add(eventFactory.createStartElement("", "", "address"));
            writer.add(eventFactory.createCharacters(order.getAddress()));
            writer.add(eventFactory.createEndElement("", "", "address"));

            writer.add(eventFactory.createStartElement("", "", "item"));

            for (int i = 0; i < order.getItems().size(); i++) {
                writer.add(eventFactory.createStartElement("", "", "name"));
                writer.add(eventFactory.createCharacters(order.getItems().get(i).getName()));
                writer.add(eventFactory.createEndElement("", "", "name"));

                writer.add(eventFactory.createStartElement("", "", "quantity"));
                writer.add(eventFactory.createCharacters(order.getItems().get(i).getQuantity()));
                writer.add(eventFactory.createEndElement("", "", "quantity"));

                writer.add(eventFactory.createStartElement("", "", "price"));
                writer.add(eventFactory.createAttribute("currency", order.getItems().get(i).getPrice().getCurrency()));
                writer.add(eventFactory.createCharacters(order.getItems().get(i).getPrice().getPrice()));
                writer.add(eventFactory.createEndElement("", "", "price"));
            }
            writer.add(eventFactory.createEndElement("", "", "item"));

            writer.add(eventFactory.createEndElement("", "", "order"));
        }
        writer.add(eventFactory.createEndElement("", "", "orders"));

        writer.add(eventFactory.createEndDocument());

        writer.flush();

        writer.close();
    }

    public void writeHTML(String src, Orders orders) throws IOException {
        Document document = Jsoup.parse(new File(src), "UTF-8");
        Elements table = document.children();
        for (Order order : orders.getOrders()) {
            String html = "\n<tr>\n"
                    + "<td> " + order.getNumber() + "</td>\n"
                    + "<td> " + order.getOrderDate() + "</td>\n"
                    + "<td> " + order.getCustomer() + "</td>\n"
                    + "<td> " + order.getEmail() + "</td>\n"
                    + "<td> " + order.getPhone() + "</td>\n"
                    + "<td> " + order.getAddress() + "</td>\n";
            for (int i = 0; i < order.getItems().size(); i++) {
                html += ("<td> " + order.getItems().get(i).getName() + "</td>\n"
                        + "<td> " + order.getItems().get(i).getQuantity() + "</td>\n"
                        + "<td> " + order.getItems().get(i).getPrice().getPrice() + "</td>\n");
            }
            html += "</tr>\n";
            table.select("table").append(html);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/html/Report.html"));
        bw.write(table.toString());
        bw.close();

        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("src/main/java/html/Report.html"));
    }
}

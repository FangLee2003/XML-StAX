// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
//  */
 package com.mycompany.jaxb_xmltojava;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.sql.Array;
// import java.util.ArrayList;

// import javax.xml.bind.JAXBContext;
// import javax.xml.bind.JAXBException;
// import javax.xml.bind.Marshaller;
// import javax.xml.stream.XMLEventFactory;
// import javax.xml.stream.XMLEventWriter;
// import javax.xml.stream.XMLOutputFactory;
// import javax.xml.stream.XMLStreamException;
// import javax.xml.stream.events.EndDocument;
// import javax.xml.stream.events.EndElement;
// import javax.xml.stream.events.StartDocument;
// import javax.xml.stream.events.StartElement;
// import javax.xml.stream.events.XMLEvent;

// /**
//  *
//  * @author Hoahanna
//  */
// public class WriteXML {

//     /**
//      * @param args the command line arguments
//      */
//     public static void main(String[] args) {
//         // TODO code application logic here
//         Item item = new Item();
//         ArrayList<Item> items = new ArrayList();
//         items.add(item);
//         writeXML("123456", "08/03/2022","Nguyễn Công Minh", "minhncde140132@fpt.edu.vn","0934929528","21 Hòa Minh", items);
// }

// public static void writeXML(String number, String orderDate, String customer, String email, String phone, String address, ArrayList<Item> item) {
//     try {
//         XMLOutputFactory factory = XMLOutputFactory.newFactory();
//         XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream("src/main/java/xml/neworder.xml"), "UTF-8");
//         XMLEventFactory ef = XMLEventFactory.newFactory();
//         StartDocument sd = ef.createStartDocument("UTF-8", "1.0");
//         EndDocument ed = ef.createEndDocument();

//         StartElement sOrder = ef.createStartElement("","", "order");
//         EndElement eOrder = ef.createEndElement("","","order");

//         StartAttribute sNumber = ef.createAttribute("", "number");

//         StartElement sOrderDate = ef.createStartElement("", "", "order_date");
//         EndElement eOrderDate = ef.createEndElement("","","order_date");
        
//         StartElement sCustomer = ef.createStartElement("", "", "customer");
//         EndElement eCustomer = ef.createEndElement("","","customer");
        
//         StartElement sEmail = ef.createStartElement("", "", "email");
//         EndElement eEmail = ef.createEndElement("","","email");
        
//         StartElement sPhone = ef.createStartElement("", "", "phone");
//         EndElement ePhone = ef.createEndElement("","","phone");

//         StartElement sAddress = ef.createStartElement("", "", "address");
//         EndElement eAddress = ef.createEndElement("","","address");
        
//         writer.add(sd);
//         writer.add(sOrder);
//         writer.add(ef.createAttribute("number", number));
        
//         writer.add(sOrderDate);
//         writer.add(ef.createCharacters(orderDate));
//         writer.add(eOrderDate);
//         writer.add(sCustomer);
//         writer.add(ef.createCharacters(customer));
//         writer.add(eCustomer);
//         writer.add(sEmail);
//         writer.add(ef.createCharacters(email));
//         writer.add(eEmail);
//         writer.add(sPhone);
//         writer.add(ef.createCharacters(phone));
//         writer.add(ePhone);
//         writer.add(sAddress);
//         writer.add(ef.createCharacters(address));
//         writer.add(eAddress);
        
//         writer.add(eOrder);
//         writer.add(ed);
        
//         writer.flush();
//         writer.close();
//     } catch (FileNotFoundException | XMLStreamException e) {
//         e.printStackTrace();
//     }
// }
// }



import javax.xml.stream.*;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.XMLEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXML {
	 public static void main(String[] args) throws XMLStreamException {

	        try(FileOutputStream out = new FileOutputStream("D:\\Documents\\Visual Studio Code\\JAXB_XMLtoJava\\src\\main\\java\\xml\\neworder.xml")){
	            writeXml2(out);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void writeXml2(OutputStream out) throws XMLStreamException {

	        XMLOutputFactory output = XMLOutputFactory.newInstance();
	        XMLEventFactory eventFactory = XMLEventFactory.newInstance();

	        XMLEventWriter writer = output.createXMLEventWriter(out);

	        XMLEvent event = eventFactory.createStartDocument("UTF-8", "1.0");

	        writer.add(event);

	        writer.add(eventFactory.createStartElement("", "", "order"));
            writer.add(eventFactory.createAttribute("number", "123456"));

	        writer.add(eventFactory.createStartElement("", "", "order_date"));
            writer.add(eventFactory.createEndElement("", "", "order_date"));

	        

	        writer.add(eventFactory.createStartElement("", "", "customer"));
	        writer.add(eventFactory.createCharacters("Nguyễn Công minh"));
	        writer.add(eventFactory.createEndElement("", "", "customer"));
	        
	        writer.add(eventFactory.createStartElement("", "", "email"));
            writer.add(eventFactory.createEndElement("", "", "email"));

	        writer.add(eventFactory.createStartElement("", "", "phone"));
            writer.add(eventFactory.createCharacters("0934929528"));
            writer.add(eventFactory.createEndElement("", "", "phone"));
            
	        writer.add(eventFactory.createStartElement("", "", "address"));
	        writer.add(eventFactory.createCharacters("123123"));
	        writer.add(eventFactory.createEndElement("", "", "address"));

	        writer.add(eventFactory.createStartElement("", "", "item"));
	        writer.add(eventFactory.createStartElement("", "", "name"));
            writer.add(eventFactory.createCharacters("Xoài"));
            writer.add(eventFactory.createEndElement("", "", "name"));
	        writer.add(eventFactory.createStartElement("", "", "quantity"));
	        writer.add(eventFactory.createCharacters("15"));
	        writer.add(eventFactory.createEndElement("", "", "quantity"));
            writer.add(eventFactory.createStartElement("", "", "price"));
            writer.add(eventFactory.createAttribute("currency", "VND"));
            writer.add(eventFactory.createCharacters("20000"));
	        writer.add(eventFactory.createEndElement("", "", "price"));
	        
	        

	        writer.add(eventFactory.createEndElement("", "", "order"));
	        writer.add(eventFactory.createEndDocument());

	        writer.flush();

	        writer.close();

	    }
}

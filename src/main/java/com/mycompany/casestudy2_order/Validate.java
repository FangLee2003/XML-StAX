/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Item;
import model.Order;
import model.Orders;
import model.Price;

/**
 * @author
 */
public class Validate{
    static String number, order_date, customer, email, phone, address, itemName, itemQuantity, itemPrice, priceCurrency;
    static List<Item> itemList;
    // Menu
    public static int menu() {
        System.out.println("------------------------------------");
        System.out.println("\n1. Read XML file");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Remove");
        System.out.println("5. Get HTML Report");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice:\n");
        int choice = checkInputIntLimit(0, 5);
        return choice;
    }

    public static Scanner in = new Scanner(System.in);

    // Check input int
    public static int checkInputInt() {
        while (true) {
            try {
                int rs = Integer.parseInt(in.nextLine());
                return rs;
            } catch (NumberFormatException ex) {
                System.err.println("Input integer number!!");
                System.out.println("Enter again:");
            }
        }
    }

    // Check input int limit
    public static int checkInputIntLimit(int min, int max) {
        // loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    // Chekc input String
    public static String checkInputString() {
        while (true) {
            String rs = in.nextLine().trim();
            if (!rs.isEmpty()) {
                return rs;
            } else {
                System.out.println("Can not empty!");
                System.out.println("Please enter again:");
            }
        }
    }
    public static Order newOrder(){
        System.out.println("\nEnter new number:");
        number = checkInputString();
        System.out.println("Enter new date:");
        order_date = checkInputString();
        System.out.println("Enter new customer:");
        customer = checkInputString();
        System.out.println("Enter new email:");
        email = checkInputString();
        System.out.println("Enter new phone:");
        phone = checkInputString();
        System.out.println("Enter new address:");
        address = checkInputString();
        System.out.println("Enter new item name:");
        itemName = checkInputString();
        System.out.println("Enter new item quantity:");
        itemQuantity = checkInputString();
        System.out.println("Enter new item price:");
        itemPrice = checkInputString();
        System.out.println("Enter new item price currency:");
        priceCurrency = checkInputString();

        itemList = new ArrayList();
        itemList.add(new Item(itemName, itemQuantity, new Price(priceCurrency, itemPrice)));

        return new Order(number, order_date, customer, itemList, email, phone, address);
    }
    //     Display list
    public static void showList(Orders orders) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-60s%-20s%-20s%-20s%-20s\n", "Number", "|Date", "|Customer", "|Email", "|Phone", "|Address", "|Item Name", "|Item Quantity", "|Item Price", "|Item Price Currency",
                "|Department name", "|Depart1ment position");
        for (Order order : orders.getOrders()) {
            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-60s%-20s%-20s%-20s%-20s\n",
                        order.getNumber(),
                        "|" + order.getOrderDate(),
                        "|" + order.getCustomer(),
                        "|" + order.getEmail(),
                        "|" + order.getPhone(),
                        "|" + order.getAddress(),
                        "|" + order.getItems().get(i).getName(),
                        "|" + order.getItems().get(i).getQuantity(),
                        "|" + order.getItems().get(i).getPrice().getPrice(),
                        "|" + order.getItems().get(i).getPrice().getCurrency());
            }
        }
    }
    public String htmlTemplate() {
        return "<html>" +
                "</html>";
    }
}

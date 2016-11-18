package com.example.rest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Created by p3700661 on 11/16/2016.
 */
public class CustomerList {

    private static final CopyOnWriteArrayList<Customer> cList = new CopyOnWriteArrayList<>();

    static {
        cList.add(
                new Customer.CustomerBuilder().id()
                .firstName("Ioana")
                .lastName("Iacob")
                .email("email@exp.com")
                .city("Iasi")
                .state("Romania")
                .birthday("17.10.93")
                .build()
        );
        cList.add(
                new Customer.CustomerBuilder().id()
                        .firstName("Ioana")
                        .lastName("Sirbu")
                        .email("email1@exp.com")
                        .city("Iasi")
                        .state("Romania")
                        .birthday("20.12.92")
                        .build()
        );
        cList.add(
                new Customer.CustomerBuilder().id()
                        .firstName("ala")
                        .lastName("bala")
                        .email("email2@exp.com")
                        .city("Iasi")
                        .state("Romania")
                        .birthday("17.10.93")
                        .build()
        );
        cList.add(
                new Customer.CustomerBuilder().id()
                        .firstName("portocala")
                        .lastName("Iacob")
                        .email("email@exp.com")
                        .city("Iasi")
                        .state("Romania")
                        .birthday("17.10.93")
                        .build()
        );
    }

    private CustomerList() {}

    public static CopyOnWriteArrayList<Customer> getInstance() {
        return cList;
    }

    public static void testList() {
        CopyOnWriteArrayList<Customer> list = CustomerList.getInstance();
        list.stream().forEach(i -> System.out.println(i));

        String cString = list.stream().map(c-> c.toString())
                .collect(Collectors.joining("\n"));
        System.out.println(cString);
    }

    public static void main(String[] args) {
        CustomerList.testList();
    }
}

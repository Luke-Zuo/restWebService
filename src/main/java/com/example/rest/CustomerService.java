package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Created by p3700661 on 11/16/2016.
 */

@Path("/customers")
public class CustomerService {
    private final CopyOnWriteArrayList<Customer> cList = CustomerList.getInstance();

@GET   //This method is called with the HTTP GET method.
@Path("/all")
@Produces(MediaType.TEXT_PLAIN)
public String getAllCustomers() {
    return "----Customers List----\n"
            +cList.stream()
            .map(c->c.toString())
            .collect(Collectors.joining("\n")); //Lambda - The lambda expression at the end of the
                                                // class get the list of customers, converts those object
                                                // to strings, and then uses Collectors.joining("\n") to return a single string.
}

@GET
@Path("{id}")
@Produces(MediaType.TEXT_PLAIN)
    public String getCustomer(@PathParam("id") long id) {
    Optional<Customer> match
            = cList.stream()
            .filter(c -> c.getID() == id)
            .findFirst();
    if (match.isPresent()) {
        return "---Customer---\n" + match.get().toString();
    }
    else {
        return "Customer not found"; //balblabla
    }
}
}

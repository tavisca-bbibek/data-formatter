package com.tavisca.gce.assignment;

import java.io.Serializable;

public final class Customer implements Serializable {
    private  int id;
    private  String firstName;
    private  String lastName;
    private  String contact;
    private  String addresses;

    public Customer() {
        id = 0;
        firstName = "Undefined";
        lastName = "Undefined";
        contact = "Undefined";
        addresses = "Undefined";
    }

    public Customer(int id, String firstName, String lastName, String contact, String addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContact() {
        return contact;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + addresses + '\'' +
                '}';
    }
}

package com.tavisca.gce.assignment;

import java.io.Serializable;

public final class Customer implements Serializable {
    private  int id;
    private  String firstName;
    private  String lastName;
    private  String contact;
    private  String address;

    public Customer() {
        id = 0;
        firstName = "Undefined";
        lastName = "Undefined";
        contact = "Undefined";
        address = "Undefined";
    }

    public Customer(int id, String firstName, String lastName, String contact, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
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

    public String getAddress() {
        return address;
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

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

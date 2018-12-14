package com.wiltech.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Contact> contacts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(contacts, customer.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contacts);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

package com.otus.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressDataSet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "street")
    private String street;

    public AddressDataSet()
    {
    }

    public AddressDataSet(final String street)
    {
        this.street = street;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    @Override
    public String toString()
    {
        return "AddressDataSet{" +
            "addressId=" + addressId +
            ", street='" + street + '\'' +
            '}';
    }
}

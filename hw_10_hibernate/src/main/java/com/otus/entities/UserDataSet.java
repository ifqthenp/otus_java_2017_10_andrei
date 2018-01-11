package com.otus.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserDataSet extends DataSet
{
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressDataSet addressDataSet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private List<PhoneDataSet> phoneNumbers = new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AddressDataSet getAddressDataSet()
    {
        return addressDataSet;
    }

    public void setAddressDataSet(final AddressDataSet addressDataSet)
    {
        this.addressDataSet = addressDataSet;
    }

    public List<PhoneDataSet> getPhoneNumbers()
    {
        return phoneNumbers;
    }

    public void setPhoneNumbers(final List<PhoneDataSet> phoneNumbers)
    {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString()
    {
        return "UserDataSet{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ", addressDataSet=" + addressDataSet +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}


package com.otus.entities;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class PhoneDataSet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private long phoneId;

    @Column(name = "number")
    private String number;

    public PhoneDataSet()
    {
    }

    public PhoneDataSet(final String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(final String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "PhoneDataSet{" +
                "phoneId=" + phoneId +
                ", number='" + number + '\'' +
                '}';
    }
}

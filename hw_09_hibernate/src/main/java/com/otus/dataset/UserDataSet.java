package com.otus.dataset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DATASET")
public class UserDataSet extends DataSet
{
    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    public UserDataSet()
    {
    }

    public UserDataSet(final String name, final int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(final int age)
    {
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "UserDataSet{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", id=" + id +
            '}';
    }
}

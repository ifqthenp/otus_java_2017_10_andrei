package com.otus.dataset;

public class UserDataSet extends DataSet {

    private long id;
    private final String name;
    private final int age;

    public UserDataSet(final String name, final int age) {
        id = DataSet.id;
        this.name = name;
        this.age = age;
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

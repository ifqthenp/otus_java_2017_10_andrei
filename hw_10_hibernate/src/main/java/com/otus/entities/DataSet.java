package com.otus.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class DataSet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    long id;
}

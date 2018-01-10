package com.otus.dataset;

import javax.persistence.*;

/**
 * {@code DataSet} class.
 */
@MappedSuperclass
public abstract class DataSet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    long id;
}

package com.otus.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * {@code ResultHandler} class.
 */
@FunctionalInterface
public interface TResultHandler<T>
{
    T handle(ResultSet resultSet) throws SQLException;
}

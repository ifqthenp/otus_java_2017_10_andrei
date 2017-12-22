package com.otus.executor;

import com.otus.dataset.DataSet;
import com.otus.db_service.DBServiceUpdate;
import com.otus.objectAnalyser.ObjectAnalyser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * {@code TExecutor} class.
 */
public class TExecutor extends DBServiceUpdate
{
    public <T extends DataSet> void save(final T user) throws SQLException, IllegalAccessException
    {
        final Map<String, Object> fields = ObjectAnalyser.getFieldNames(user);
        final String className = user.getClass().getSimpleName();

        try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO " + className + " VALUES (?, ?, ?)")) {
            stmt.setLong(1, (Long) fields.get("id"));
            stmt.setString(2, (String) fields.get("name"));
            stmt.setInt(3, (Integer) fields.get("age"));
            stmt.executeUpdate();
        }
    }

    public <T extends DataSet> T load(final long id, final Class<T> cl)
        throws SQLException, IllegalAccessException, InstantiationException,
        NoSuchFieldException, NoSuchMethodException, InvocationTargetException
    {
        final String className = cl.getSimpleName();
        final String query = "SELECT * FROM " + className + " WHERE id=?";

        try (PreparedStatement prepStmt = getConnection().prepareStatement(query)) {
            prepStmt.setLong(1, id);
            ResultSet rs = prepStmt.executeQuery();

            if (rs.next()) {
                final String name = rs.getString(rs.findColumn("name"));
                final int age = rs.getInt(rs.findColumn("age"));

                T o = cl.getConstructor(String.class, int.class).newInstance(name, age);
                Field idField = cl.getDeclaredField("id");
                idField.setAccessible(true);
                idField.set(o, rs.getLong(rs.findColumn("id")));
                return o;
            }
        }
        return null;
    }
}

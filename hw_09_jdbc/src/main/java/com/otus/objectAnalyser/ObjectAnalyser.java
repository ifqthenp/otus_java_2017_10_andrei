package com.otus.objectAnalyser;

import com.otus.dataset.DataSet;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code ObjectAnalyser} class.
 */
public class ObjectAnalyser
{
    public static <T extends DataSet> Map<String, Object> getFieldNames(final T o) throws IllegalAccessException
    {
        Class<? extends DataSet> cl = o.getClass();
        Field[] fields = cl.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        Map<String, Object> map = new HashMap<>();
        for (final Field field : fields) {
            map.put(field.getName(), field.get(o));
        }
        return map;
    }
}

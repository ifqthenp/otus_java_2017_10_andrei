package com.otus.classes;

import com.otus.interfaces.ObjectProcessor;
import com.otus.testObjects.SubBag;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

/**
 * {@code JsonProcessor} class.
 */
public class ObjectProcessorImp implements ObjectProcessor
{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException
    {
        ObjectProcessor op = new ObjectProcessorImp();

        String result = op.process(new SubBag());
        System.out.println(result);

        int[] intArr = {1, 2, 3};
        System.out.println(op.process(intArr));

        String[] strArr = {"str", "br", "mr"};
        System.out.println(op.process(strArr));

        Collection<String> stringColl = new ArrayList<>();
        stringColl.add("a");
        stringColl.add("b");
        stringColl.add("c");
        System.out.println(op.process(stringColl));

        Collection<Integer> intColl = new ArrayList<>();
        intColl.add(1);
        intColl.add(2);
        intColl.add(3);
        System.out.println(op.process(intColl));
    }

    @Override
    public String process(Object o)
    {
        if (o == null) return "null";

        Class cl = o.getClass();

        if (cl == String.class) return "\"" + o + "\"";

        if (cl.isArray()) {
            String r = "[";
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(o, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += process(val);
            }
            return r + "]";
        }

        String r = "{";
        do {
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("{")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(o);
                        if (t.isPrimitive()) r += val;
                        else r += process(val);
                    }
                    catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            cl = cl.getSuperclass();
        } while (cl != null);

        return r + "}";
    }
}

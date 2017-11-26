package ru.otus.framework;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@code FrameworkDemo} class.
 */
public class FrameworkDemo
{
    public static void main(String[] args) throws IOException
    {
        String packageName = "ru.otus.tests";

        ImmutableSet<ClassPath.ClassInfo> testClasses = getClassesFromPackage(packageName);

        processTestClasses(testClasses);
    }

    /**
     * Iterates through a set of classes and passes an instance of each class
     * as an argument to {@code declaredMethodsProcessor()} method.
     *
     * @param classes set of classes names
     */
    private static void processTestClasses(final ImmutableSet<ClassPath.ClassInfo> classes)
    {
        for (final ClassPath.ClassInfo classInfo : classes) {
            try {
                declaredMethodsProcessor(Class.forName(classInfo.getName()));
            }
            catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Processes declared methods for an object and invokes methods
     * that annotated accordingly to testing framework rules.
     * <p>
     * This solution allows only single instance of {@code Before} and
     * {@code After} annotation type. The last instance of each type found
     * in the loop will be used in the framework.
     *
     * @param cl a class to process its declared methods
     */
    private static void declaredMethodsProcessor(Class<?> cl)
    {
        try {
            Method[] methods = cl.newInstance().getClass().getDeclaredMethods();
            Method before = null;
            Method after = null;

            for (final Method m : methods) {
                if (m.getDeclaredAnnotations().length > 0) {
                    if (m.isAnnotationPresent(Before.class)) {
                        String beforeMethodName = m.getName();
                        before = cl.newInstance().getClass().getMethod(beforeMethodName);
                    }

                    if (m.isAnnotationPresent(After.class)) {
                        String afterMethodName = m.getName();
                        after = cl.newInstance().getClass().getMethod(afterMethodName);
                    }
                }
            }

            for (final Method m : methods) {
                if (m.getDeclaredAnnotations().length > 0) {
                    if (m.getAnnotation(Test.class) != null) {
                        if (before != null) {
                            before.invoke(cl.newInstance());
                        }

                        String testName = m.getName();
                        Method testMethod = cl.newInstance().getClass().getMethod(testName);
                        testMethod.invoke(cl.newInstance());

                        if (after != null) {
                            after.invoke(cl.newInstance());
                        }
                    }
                }
            }
        }
        catch (IllegalAccessException | InvocationTargetException |
            NoSuchMethodException | InstantiationException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Utilises Google's Guava library to find classes in given package.
     *
     * @param packageName the package to find classes in
     * @return set of classes in the given package
     * @throws IOException if the attempt to read class path resources (jar files or directories) failed.
     */
    private static ImmutableSet<ClassPath.ClassInfo> getClassesFromPackage(String packageName) throws IOException
    {
        return ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClasses(packageName);
    }
}

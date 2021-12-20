package com.androidapps.basic.interviewQuestion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObject implements Cloneable {

    /*Java provides five ways to create an object.

Using new Keyword
Using clone() method
Using newInstance() method of the Class class
Using newInstance() method of the Constructor class
Using Deserialization

*/
    String text;

    public static void main(String[] args) {


        usingClone();
        // usingNewInstance();
        //UsingnewInstanceMethodofConstructorclass();

    }

    private static void usingClone() {

        try {
            CreateObject createObject = new CreateObject();
            System.out.println(createObject.text);

            createObject.text = "Hello";
            System.out.println(createObject.text);
            //when we clone,it will creates a copy of object not new object.
            // returned is Object type not our class type object.so we need to cast it to our class type object.(CreateObject)
            //for cloning,class should implement Cloneable interface.otherwise will throw CloneNotSupportedException.
            CreateObject clonedObject = (CreateObject) createObject.clone();
            System.out.println(clonedObject.text);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void UsingnewInstanceMethodofConstructorclass() {
        Constructor<CreateObject> constructor = null;
        try {
            constructor = CreateObject.class.getDeclaredConstructor();
            try {
                CreateObject instance = constructor.newInstance();
                instance.text = "do it!";
                System.out.println(instance.text);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private static void usingNewInstance() {
        try {
            //creating an instance of Class class
            Class cla = Class.forName("CreateObject");
            //creates an instance of the class using the newInstance() method
            CreateObject object = (CreateObject) cla.newInstance();

            object.text = "Hai";
            System.out.println(object.text);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

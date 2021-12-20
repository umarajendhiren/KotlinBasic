package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class MapInterface {

    //map is an interface .to use map we need to use any implementation of map.
    //map store key and value pair.

    //to get the value from map,we no need to know index.we just need to pass  "key".
    //if we don't want to sort element inside map,HashMap is best.it is faster than other implementation.
    //if we  want to sort element inside map,TreeMap is best

    //HashMap maps a key and a value. It does not guarantee any order of the elements stored internally in the map.
    //TreeMap also maps a key and a value. Furthermore it guarantees the order in which keys or values are iterated - which is the sort order of the keys or values
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        MapInterface obj = new MapInterface();
        obj.insertElementIntoMap();
        obj.insertAllElement();
        obj.autoBoxing();
        obj.sameKey();
        obj.nullKey();
        obj.nullValue();
        obj.getValueFromMap();
        obj.CheckingifMapContainsKey();
        obj.CheckingifMapContainsValue();
        obj.iteratingMap();
        obj.removeElement();
        obj.replacingValues();
        obj.compute();
        obj.computeIfAbsent();
        obj.computeIfPresent();
        obj.merge();


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void merge() {
        Map<String, String> map = new HashMap<>();

        map.put("Name", "Aman");
        map.put("Address", "Kolkata");
        //map.put("pin", "123");

        //if key is already presents,it just add abc to old value (123abc),if not present just put "123" for the key "pin".

        map.merge("pin", "123", (oldValue, newValue) -> newValue + "abc");
        System.out.println("mergedmap = " + map);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void computeIfPresent() {

        /*The Map computeIfPresent() method works oppositely of computeIfAbsent().
        It only calls the lambda expression passed as parameter to it, if an entry already exists in the Map for that key.*/
        Map<String, String> map = new HashMap<>();

        map.put("Name", "Aman");
        map.put("Address", "Kolkata");
        System.out.println("map = " + map);

        map.computeIfPresent("Name", (key, value) -> value == null ? null : value.toUpperCase());
        System.out.println("Updatedmap = " + map);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void computeIfAbsent() {
        /*The Map computeIfAbsent() method works similarly to the compute() method, but the lambda expression is only called if no entry exists already for the given key.*/

        Map<String, String> map = new HashMap<>();

        map.put("Name", "Aman");
        map.put("Address", "Kolkata");
        System.out.println("map = " + map);
        map.computeIfAbsent("SecondName", (key) -> "sing");
        System.out.println("updatedmap = " + map);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void compute() {

        /*The compute(Key, BiFunction) method of HashMap class allows you to update a value in HashMap. The compute() method tries to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping is found).
        This method is used to atomically update a value for given key in HashMap.*/
        Map<String, String> map = new HashMap<>();

        map.put("Name", "Aman");
        map.put("Address", "Kolkata");

        System.out.println("map = " + map);
        //map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg)
        // remap the values using compute() method
        map.compute("Name", (key, val)
                -> val.concat(" Singh"));
        map.compute("Address", (key, val)
                -> val.concat(" West-Bengal"));

        // print new mapping
        System.out.println("New Map: " + map);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void replacingValues() {

        /*It is possible to replace an element in a Java Map using the replace() method. The replace() method will only insert the new value if there is already an existing value mapped to the key. If no existing value is mapped to the given key, no value is inserted. This is different from how put() works, which always insert the value no matter what.*/
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");


        map.replace("C", "3"); //no "C" entry, no replace
        map.put("C", "3"); //now contains "C" entry
        map.replace("C", "4");//now "C" entry replaced

        map.replace("C", "4", "5");

        Iterator<String> keyIterator = map.keySet().iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            String value = map.get(key);
            System.out.println("key " + key);
            System.out.println("value = " + value);
        }


        //size()
        System.out.println("size " + map.size());

        //isEmpty()
        System.out.println("isEmpty = " + map.isEmpty());
    }

    private void removeElement() {
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.remove("A");

        //remove all the values
        map.clear();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void iteratingMap() {

        /*Iterating the Keys of a Java Map
There are several ways to iterate the keys stored in a Java Map. The most used methods for iterating the keys are:

Via the key Iterator
Via the for-each loop
Via a key Stream*/

        /*Iterating the Values of a Java Map
It is also possible to just iterate the values stored in a Java Map. You obtain a Collection of the values stored in a Map via the values() method. You can iterate the values in the Collection in following ways:

Using an value Iterator
Using the for-each Loop
Using a value Stream*/
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");

        Iterator<String> keyIterator = map.keySet().iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            String value = map.get(key);
            System.out.println("key " + key);
            System.out.println("value = " + value);
        }

        Iterator<String> valueIterator = map.values().iterator();
        while (valueIterator.hasNext()) {
            System.out.println("valueIterator.next() = " + valueIterator.next());


        }

        for (String key : map.keySet()) {

            System.out.println("valueFromKeySet = " + map.get(key));
        }

        for (String values : map.values()) {

            System.out.println("values = " + values);
        }

        Stream<String> keyStream = map.keySet().stream();
        keyStream.forEach((element) -> System.out.println("keyelement = " + element));

        Stream<String> valueStream = map.values().stream();
        valueStream.forEach((element) -> System.out.println("valueelement = " + element));
    }

    private void CheckingifMapContainsValue() {
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");

        boolean containsValue1 = map.containsValue("1");
        System.out.println("containsValue1 = " + containsValue1);

        boolean containsValue4 = map.containsValue("4");
        System.out.println("containsValue4= " + containsValue4);
    }

    private void CheckingifMapContainsKey() {
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");

        boolean containsKeyA = map.containsKey("A");
        System.out.println("containsKeyA = " + containsKeyA);

        boolean containsKeyE = map.containsKey("E");
        System.out.println("containsKeyE = " + containsKeyE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getValueFromMap() {
        /*The Java Map interface has a getOrDefault() method which can return a default value supplied by you - in case no value is stored in the Map by the given key.*/
        Map<String, String> map = new HashMap<>();

        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        String value = map.get("E");
        System.out.println("value = " + value);
        String valueDefault = map.getOrDefault("E", "default value");
        System.out.println("valueDefault = " + valueDefault);
    }

    private void insertAllElement() {
        Map<String, String> mapA = new HashMap<>();
        mapA.put("key1", "value1");
        mapA.put("key2", "value2");

        Map<String, String> mapB = new HashMap<>();
        mapB.putAll(mapA);
    }

    private void nullValue() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", null);

        //get value.if i use generic map i no need to cast.
        String value = map.get("key1");

        //get value,if i use raw map we need to cast it to corresponding object
        //String element1 = (String) map.get("key1");
    }

    private void nullKey() {
        //we can use null as key ,To obtain the value stored by the null key you call the get() method with null as parameter value.
        Map<String, String> map = new HashMap<>();
        map.put(null, "element 1");

        //get value
        String value = map.get(null);
    }

    private void sameKey() {
        //key value should be unique,if we put same key ,newly inserted value will override old (existing)value for corresponding kay.
        Map<String, String> map = new HashMap<>();
        map.put("key1", "element 1");
        map.put("key2", "element 2");
        map.put("key3", "element 3");
        map.put("key1", "element 4");
    }

    private void autoBoxing() {
        //map only accept java object as key and value.if we use primitive type , the primitive values will be auto-boxed before being passed as parameters.
        //Java auto-boxes it inside an Integer instance though, because the put() method requires an Oject instance as both key and value. Auto-boxing would also happen if you passed a primitive as key to the put() method.
        //Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on.
        //If the conversion goes the other way, this is called unboxing.

        Map map = new HashMap<>();
        map.put("key1", 123);
    }

    private void insertElementIntoMap() {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "element 1");
        map.put("key2", "element 2");
        map.put("key3", "element 3");

    }
}

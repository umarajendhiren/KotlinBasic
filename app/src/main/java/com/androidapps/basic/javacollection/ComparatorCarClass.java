package com.androidapps.basic.javacollection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorCarClass {


        public String brand;
        public String numberPlate;
        public int noOfDoors;

        public ComparatorCarClass(String brand, String numberPlate, int noOfDoors) {
            this.brand = brand;
            this.numberPlate = numberPlate;
            this.noOfDoors = noOfDoors;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        List<ComparatorCarClass> list = new ArrayList<>();

        list.add(new ComparatorCarClass("Volvo V40" , "XYZ 201845", 5));
        list.add(new ComparatorCarClass("Citroen C1", "ABC 164521", 4));
        list.add(new ComparatorCarClass("Dodge Ram" , "KLM 845990", 2));


        Comparator<ComparatorCarClass> carBrandComparator=new Comparator<ComparatorCarClass>() {
            @Override
            public int compare(ComparatorCarClass car1, ComparatorCarClass car2) {
                return car1.brand.compareTo(car2.brand);
            }
        };
        Collections.sort(list, carBrandComparator);
        list.forEach((element)-> System.out.println("sortedBrand = " + element.brand));

        //we can also use lambda function
        Comparator<ComparatorCarClass> numberPlateComparatorLambda      =
                (car1, car2) -> car1.numberPlate.compareTo(car2.numberPlate);
        Collections.sort(list, numberPlateComparatorLambda);
        list.forEach((element)-> System.out.println("sortednumberPlate = " + element.numberPlate));

    }
}

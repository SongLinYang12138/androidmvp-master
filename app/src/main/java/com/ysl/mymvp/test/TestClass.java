package com.ysl.mymvp.test;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ysl on 2018/1/30.
 */

public class TestClass {




    public static void sortMylist() {

        SortTest sort1 = new SortTest("1", 1);
        SortTest sort2 = new SortTest("1", 2);
        SortTest sort3 = new SortTest("1", 3);
        SortTest sort4 = new SortTest("2", 1);
        SortTest sort5 = new SortTest("2", 2);
        SortTest sort6 = new SortTest("3", 2);

        ArrayList<SortTest> list = new ArrayList<>();
        list.add(sort6);
        list.add(sort2);
        list.add(sort5);
        list.add(sort4);
        list.add(sort3);
        list.add(sort1);
        Collections.sort(list);

        System.out.print(list);
    }


}

class SortTest implements Comparable<SortTest>{

    String name;
    int serial;

    public SortTest(String name, int serial) {
        this.name = name;
        this.serial = serial;
    }


    @Override
    public int compareTo(@NonNull SortTest o) {

        if(o.name.equals(this.name)){

            return o.serial-this.serial;
        }

        int serialName = this.name.compareTo(o.name);
        return serialName;
    }
}
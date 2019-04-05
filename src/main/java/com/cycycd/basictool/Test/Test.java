package com.cycycd.basictool.Test;

import com.cycycd.basictool.sort.Insertion;
import com.cycycd.basictool.sort.Selection;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Integer [] a={22,21,19,27};
//        Selection.sort(a);
//        show(a);
        List<Person> a= new ArrayList<>();
        a.add(new Person("张三",22));
        a.add(new Person("李四",21));
        a.add(new Person("测试",19));
        a.add(new Person("六小龄童",27));
        Insertion.sort(a);
        show(a);
    }
    private static void show(Integer[] a)
    {
        for (int t:a) {
            System.out.print(t+" ");
        }
        System.out.println();
    }
    private static void show(List<Person> a)
    {
        for (Person t:a) {
            System.out.print(t+" ");
        }
        System.out.println();
    }
}

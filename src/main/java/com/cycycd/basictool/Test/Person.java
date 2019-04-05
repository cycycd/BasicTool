package com.cycycd.basictool.Test;

import android.support.annotation.NonNull;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NonNull Person o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "姓名："+name+" 年龄："+age;
    }
}

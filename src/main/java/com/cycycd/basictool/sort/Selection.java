package com.cycycd.basictool.sort;

import java.util.List;

public class Selection extends Sort {
    public static <S extends Comparable<S>> void sort(S[] a) {
        int N = a.length;
        int min;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if(less(a[j],a[min]))
                {
                    min=j;
                }
            }
            exch(a,i,min);
        }
    }
    public static <S extends Comparable<S>> void sort(List<S> a) {
        int N = a.size();
        int min;
        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if(less(a.get(j),a.get(min)))
                {
                    min=j;
                }
            }
            exch(a,i,min);
        }
    }
}

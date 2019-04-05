package com.cycycd.basictool.sort;

import java.util.List;

public class Insertion extends Sort {
    public static <S extends Comparable<S>> void sort(S[] a) {
        int N=a.length;
        for (int i=1;i<N;i++)
        {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
            {
                exch(a,j,j-1);
            }
        }
    }
    public static <S extends Comparable<S>> void sort(List<S> a) {
        int N=a.size();
        for (int i=1;i<N;i++)
        {
            for(int j=i;j>0&&less(a.get(j),a.get(j-1));j--)
            {
                exch(a,j,j-1);
            }
        }
    }
}

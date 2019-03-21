package com.cycycd.basictool.sort;

import java.util.Collections;
import java.util.List;

public class Sort {
    protected static <S extends Comparable<S>> boolean less(S a,S b)
    {
        return a.compareTo(b)<0;
    }
    protected static void exch(Comparable[] a,int i,int j)
    {
        Comparable m=a[i];
        a[i]=a[j];
        a[j]=m;
    }
    protected static <S extends Comparable<S>> void exch(List<S> a, int i, int j)
    {
        Collections.swap(a,i,j);
    }
}

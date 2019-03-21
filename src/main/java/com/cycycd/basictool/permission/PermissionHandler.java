package com.cycycd.basictool.permission;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionHandler {
    private List<String> perm_list;
    private Context context;
    public PermissionHandler()
    {
        perm_list=new ArrayList<>();
    }
    public PermissionHandler(Context c)
    {
        this();
        this.context=c;
    }
    public PermissionHandler(List<String> list, Context c) {
        this(c);
        Collections.copy(perm_list,list);
    }
    public void add(String... perm)
    {
        perm_list.addAll(Arrays.asList(perm));
    }
    //clear all permission
    public void clear()
    {
        perm_list.clear();
    }
    public Map<String,Boolean> check()
    {
        Map<String,Boolean> m=new HashMap<>();
        for(var t:perm_list)
        {
            if (ContextCompat.checkSelfPermission(context, t) != PackageManager.PERMISSION_GRANTED) {
                m.put(t,false);
            }
            else {
                m.put(t,true);
            }
        }
        return m;
    }
}

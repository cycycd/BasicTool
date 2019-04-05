package com.cycycd.basictool.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionHandler {
    private List<String> perm_list;
    private Activity activity;
    //构造函数层级递进
    public PermissionHandler()
    {
        perm_list=new ArrayList<>();
    }
    public PermissionHandler(Activity c)
    {
        this();
        this.activity=c;
    }
    public PermissionHandler(List<String> list, Activity c) {
        this(c);
        Collections.copy(perm_list,list);
    }
    public PermissionHandler(String [] list, Activity c) {
        this(c);
        perm_list.addAll(Arrays.asList(list));
    }
    //待完成 PermissionRequest 中调用方法检测权限是否申请成功

    //添加权限队列
    public void add(String... perm)
    {
        perm_list.addAll(Arrays.asList(perm));
    }

    //清除所有权限
    public void clearAll()
    {
        perm_list.clear();
    }
    //清除PermissionHandler队列中已获取的权限
    public void clear()
    {
        this.perm_list=getNotOwnedPermission();
    }
    //返回PermissionHandler中的权限队列的拥有情况
    public Map<String,Boolean> checkPermission()
    {
        Map<String,Boolean> m=new HashMap<>();
        for(String t:perm_list)
        {
            if (ContextCompat.checkSelfPermission(activity, t) != PackageManager.PERMISSION_GRANTED) {
                m.put(t,false);
            }
            else {
                m.put(t,true);
            }
        }
        return m;
    }


    //返回权限列表中尚未拥有的权限（底层实现）
    private List<String> checkNotOwnedPermission(List<String> permissions)
    {
        List<String> m=new ArrayList<>();
        for(String t:permissions)
        {
            if (ContextCompat.checkSelfPermission(activity, t) != PackageManager.PERMISSION_GRANTED) {
                m.add(t);
            }
        }
        return m;
    }
    //返回权限列表中已经拥有的权限
    public List<String> checkOwnedPermission(List<String> permissions)
    {
        List<String> m=new ArrayList<>();
        for(String t:permissions)
        {
            if (ContextCompat.checkSelfPermission(activity, t) == PackageManager.PERMISSION_GRANTED) {
                m.add(t);
            }
        }
        return m;
    }


    //返回PermissionHandler队列中尚未拥有的权限
    public List<String> getNotOwnedPermission()
    {
        return checkNotOwnedPermission(this.perm_list);
    }
    //返回参数中尚未拥有的权限 不影响PermissionHandler队列
    public List<String> getNotOwnedPermission(String [] permissions)
    {
        return checkNotOwnedPermission(Arrays.asList(permissions));
    }


    //申请权限
    /**
     * @param requestCode same in method onRequestPermissionsResult()
     * 申请尚未拥有的权限，通过toApply取得等待申请列表
     */
    public void apply(int requestCode)
    {
        List<String> t=getNotOwnedPermission();
        ActivityCompat.requestPermissions(activity, t.toArray(new String[0]), requestCode);
    }
    /**
     * requestCode default 1
     */
    public void apply()
    {
        this.apply(1);
    }
}

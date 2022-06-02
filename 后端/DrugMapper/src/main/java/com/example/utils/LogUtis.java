package com.example.utils;

import com.example.entity.LogName;
import com.example.entity.User;

import java.util.ArrayList;

public class LogUtis {
    private static String[] keys={
            LogName.addbill,
            LogName.adddruginfo,
            LogName.addmatter,
            LogName.addowinfo,
            LogName.addreturngoods,
            LogName.addreturnsupplier,
            LogName.addsaleinfo,
            LogName.addsupplier,

            LogName.deletebill,
            LogName.deletedrug,
            LogName.deletematter,
            LogName.deleteowinfo,
            LogName.deletereturngoods,
            LogName.deletereturnsupplier,
            LogName.deletesaleinfo,
            LogName.deletesupplier,

            LogName.updatebill,
            LogName.updatedrug,
            LogName.updatematter,
            LogName.updateowinfo,
            LogName.updateretrungoods,
            LogName.updatereturnsupplier,
            LogName.updatesaleinfo,
            LogName.updatesupplier,
    };

    public static ResultLog HandleLog(User user){
        int[] arr= {
                user.getAddbill()!=null?user.getAddbill().length:0,
                user.getAdddruginfo()!=null?user.getAdddruginfo().length:0,
                user.getAddmatter()!=null?user.getAddmatter().length:0,
                user.getAddowinfo()!=null?user.getAddowinfo().length:0,
                user.getAddreturngoods()!=null?user.getAddreturngoods().length:0,
                user.getAddreturnsupplier()!=null?user.getAddreturnsupplier().length:0,
                user.getAddsaleinfo()!=null?user.getAddsaleinfo().length:0,
                user.getAddsupplier()!=null?user.getAddsupplier().length:0,

                user.getDeletebill()!=null?user.getDeletebill().length:0,
                user.getDeletedrug()!=null?user.getDeletedrug().length:0,
                user.getDeletematter()!=null?user.getDeletematter().length:0,
                user.getDeleteowinfo()!=null?user.getDeleteowinfo().length:0,
                user.getDeletereturngoods()!=null?user.getDeletereturngoods().length:0,
                user.getDeletereturnsupplier()!=null?user.getDeletereturnsupplier().length:0,
                user.getDeletesaleinfo()!=null?user.getDeletesaleinfo().length:0,
                user.getDeletesupplier()!=null?user.getDeletesupplier().length:0,

                user.getUpdatebill()!=null?user.getUpdatebill().length:0,
                user.getUpdatedrug()!=null?user.getUpdatedrug().length:0,
                user.getUpdatematter()!=null?user.getUpdatematter().length:0,
                user.getUpdateowinfo()!=null?user.getUpdateowinfo().length:0,
                user.getUpdateretrungoods()!=null?user.getUpdateretrungoods().length:0,
                user.getUpdatereturnsupplier()!=null?user.getUpdatereturnsupplier().length:0,
                user.getUpdatesaleinfo()!=null?user.getUpdatesaleinfo().length:0,
                user.getUpdatesupplier()!=null?user.getUpdatesupplier().length:0
        };
        ArrayList<Integer> data=new ArrayList<>();
        ArrayList<String> newkeys=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                data.add(arr[i]);
                newkeys.add(keys[i]);
            }
        }
        int[] arrdata=new int[data.size()];
        String[] arrkeys=new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arrdata[i]=data.get(i);
            arrkeys[i]=newkeys.get(i);
        }
        return new ResultLog(arrdata.length>0,arrdata,arrkeys);
    }
}

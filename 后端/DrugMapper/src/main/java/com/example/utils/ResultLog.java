package com.example.utils;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResultLog {
    private boolean flag;
    private int[] data;
    private String[] keys;

    public ResultLog(boolean flag, int[] data, String[] keys) {
        this.flag = flag;
        this.data = data;
        this.keys = keys;
    }
}

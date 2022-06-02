package com.example.utils;

import lombok.Data;

@Data
public class Result {
    private boolean falg;
    private String msg;
    private Object data;

    public Result(boolean falg, String msg, Object data) {
        this.falg = falg;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Result(boolean falg, String msg) {
        this.falg = falg;
        this.msg = msg;
    }
}

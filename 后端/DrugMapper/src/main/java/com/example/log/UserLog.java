package com.example.log;

public interface UserLog<T> {
    boolean updateLog(T t,String key,String username);
}

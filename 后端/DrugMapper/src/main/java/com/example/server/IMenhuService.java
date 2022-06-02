package com.example.server;

import java.util.List;

public interface IMenhuService<T> {
    boolean Addinfo(T enty);
    List<T> QueryInfo();
}

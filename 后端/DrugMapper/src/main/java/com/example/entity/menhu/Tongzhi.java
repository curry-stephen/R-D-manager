package com.example.entity.menhu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tongzhi implements Serializable {
    String time;
    String title;
    String content;
}

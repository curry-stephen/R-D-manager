package com.example.entity.menhu.dongtaiimg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imgs implements Serializable {
    String url;
    String text;
}

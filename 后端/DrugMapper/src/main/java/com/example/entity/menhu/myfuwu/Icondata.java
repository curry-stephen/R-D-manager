package com.example.entity.menhu.myfuwu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Icondata implements Serializable {
    String url;
    String content;
}

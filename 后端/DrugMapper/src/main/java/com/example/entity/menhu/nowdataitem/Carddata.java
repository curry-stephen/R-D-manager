package com.example.entity.menhu.nowdataitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carddata implements Serializable {
    @Id
    Integer id;
    String url;
    String title;
    String content;
    String time;
}

package com.example.entity.menhu.nowdataitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Newdata implements Serializable {
    @Id
    Integer id;
    String content;
    String time;
}

package com.example.entity.menhu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drugdata implements Serializable {
    @Id
    String id;
    String url;
    String title;
    String text;
    String http;
}

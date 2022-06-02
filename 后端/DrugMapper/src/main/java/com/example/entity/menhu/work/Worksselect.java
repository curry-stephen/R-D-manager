package com.example.entity.menhu.work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worksselect implements Serializable {
    @Id
    Integer id;
    String select;
}

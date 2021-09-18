package com.basic.pojo;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
public class Hero {

    private Integer id;
    private String name;
    private String country;
    private String birthday;
    private Integer longevity;
}

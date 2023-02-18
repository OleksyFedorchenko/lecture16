package com.example.lecture16.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect
@Getter
@Setter
@ToString
public class PopularNamesAggregation {
    private String first_name_en;
    private Integer count;
}

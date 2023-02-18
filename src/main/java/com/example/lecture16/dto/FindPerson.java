package com.example.lecture16.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonAutoDetect
@Getter
@Setter
@ToString
public class FindPerson {
    private String id;
    private String first_name_en;
    private String last_name_en;
    private String full_name_en;
}

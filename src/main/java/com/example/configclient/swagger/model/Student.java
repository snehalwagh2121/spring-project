package com.example.configclient.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@ApiModel(value = "Student object", description = "Student Object description")
public class Student {
    @ApiModelProperty(value = "id of student", example = "1", position = 2)
    int id;
    @ApiModelProperty(value = "name of student", example = "snehal", position = 1)
    String name;
}

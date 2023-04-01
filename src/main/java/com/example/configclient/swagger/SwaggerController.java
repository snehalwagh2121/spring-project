package com.example.configclient.swagger;

import com.example.configclient.swagger.model.Student;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class SwaggerController {

    //swagger doc to show the endpoint description
    @GetMapping("/swaggerGet")
    @ApiOperation(value = "sample endpoint which gives output swagger page")
    public String sample1(){
        return "swagger page";
    }


    //swagger doc to show the parameter description
    @GetMapping("/withPara/{id}")
    @ApiOperation("endpoint with sample property")
    public String sampleWithPara(@ApiParam(value = "sample id in int", required = true, example = "1") @PathVariable int id){
        return "id in request: "+id;
    }

    @GetMapping("/sample/student")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "INternal server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successfully retrieved",
                        response = Student.class)
    })
    @ApiOperation("this returns a sample Student object")
    public Student getStudent(){
        return Student.builder()
                .id(1)
                .name("snehal")
                .build();
    }
}

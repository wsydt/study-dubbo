package com.wsy.validation.api;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangshuangyong 2021.4.20
 */

@Data
public class ValidationParameter implements Serializable {

    @NotNull
    @Size(min = 5, max = 20)
    private String name;

    @NotNull(groups = ValidationService.Save.class) //save方法该参数不允许为空, update方法允许为空
    @Pattern(regexp = "^\\w+(\\.?\\w+)*@[a-zA-Z0-9]+(\\.?[A-Za-z0-9]+)*$")
    private String email;

    @Max(100)
    @Min(0)
    private int age;

    @Past
    private Date loginDate;

    @Future
    private Date expiryDate;

}

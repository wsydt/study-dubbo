package com.wsy.generic.call.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangshuangyong 2021.4.22
 */

@AllArgsConstructor
@Data
public class Person implements Serializable {

    private int id;

    private String name;

}

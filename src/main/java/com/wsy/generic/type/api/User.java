package com.wsy.generic.type.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangshuangyong 2021.4.22
 */

@AllArgsConstructor
@Data
public class User implements Serializable {

    private int id;

    private String name;

}

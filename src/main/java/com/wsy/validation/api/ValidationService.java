package com.wsy.validation.api;

import javax.validation.GroupSequence;

public interface ValidationService {

    String save(ValidationParameter parameter);

    String update(ValidationParameter parameter);

    /**
     * 与方法名同名, 并且首字母大写, 用于区分验证场景
     *  例如 : @NotNull(groups = ValidationService.Save.class), 表示save方法时该参数不允许为空
     */
    @interface Save{}

    // 更新的时候关联验证Save 的规则
    @GroupSequence(Save.class)
    @interface Update{}

}

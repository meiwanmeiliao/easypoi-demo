package com.zl.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/21
 * @description: ${description}
 **/
@ExcelTarget("teacherDTO")
public class TeacherDTO {

    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent", needMerge = true)
    private String name;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}

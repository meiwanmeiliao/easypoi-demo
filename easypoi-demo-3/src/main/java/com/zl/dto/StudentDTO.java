package com.zl.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/21
 * @description: ${description}
 **/
public class StudentDTO {
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
    private String name;
    /**
     * 学生性别
     */
    @Excel(name = "学生性别", replace = {"男_1", "女_2"}, suffix = "生", isImportField = "true_st")
    private int sex;

    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getSex () {
        return sex;
    }

    public void setSex (int sex) {
        this.sex = sex;
    }

    public Date getBirthday () {
        return birthday;
    }

    public void setBirthday (Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate () {
        return registrationDate;
    }

    public void setRegistrationDate (Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString () {
        return "StudentDTO{" +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                '}';
    }
}

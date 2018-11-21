package com.zl.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/21
 * @description: ${description}
 **/
public class ExportDTO implements Serializable {


    @Excel(name = "学生名称", height = 20, width = 30, isImportField = "true_st")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, suffix = "生", isImportField = "true_st")
    private int sex;

    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private Date birthday;

    @Excel(name = "入学日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;

    @Excel(name = "学生照片", type = 2, width = 40, height = 20, imageType = 1)
    private String image;

    @Excel(name = "学生照片1", type = 2, width = 40, height = 20, imageType = 2)
    private byte[] image1;

    public byte[] getImage1 () {
        return image1;
    }

    public void setImage1 (byte[] image1) {
        this.image1 = image1;
    }

    public String getImage () {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

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
        return "ExportDTO{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", image='" + image + '\'' +
                ", image1=" + Arrays.toString(image1) +
                '}';
    }
}

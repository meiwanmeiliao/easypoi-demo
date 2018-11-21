package com.zl.dto;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/20
 * @description: ${description}
 **/

public class EasyPoiDTO {

    private Integer id;

    private String project;

    private String name;

    private String sex;

    private Integer age;

    public EasyPoiDTO () {
    }

    public EasyPoiDTO (Integer id, String project, String name, String sex, Integer age) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getProject () {
        return project;
    }

    public void setProject (String project) {
        this.project = project;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public Integer getAge () {
        return age;
    }

    public void setAge (Integer age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return "EasyPoiDTO{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

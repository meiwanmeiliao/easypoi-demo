package com.zl.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.Collection;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/21
 * @description: ${description}
 **/
@ExcelTarget("coursedto")
public class CourseDTO {

    /**
     * 课程名称
     */
    @Excel(name = "课程名称", orderNum = "1", width = 25, needMerge = true)
    private String name;
    /**
     * 老师主键
     */
    @ExcelEntity(id = "absent")
    private TeacherDTO teacherDTO;

    @ExcelCollection(name = "学生", orderNum = "4")
    private Collection<StudentDTO> students;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public TeacherDTO getTeacherDTO () {
        return teacherDTO;
    }

    public void setTeacherDTO (TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public Collection<StudentDTO> getStudents () {
        return students;
    }

    public void setStudents (Collection<StudentDTO> students) {
        this.students = students;
    }

    @Override
    public String toString () {
        return "CourseDTO{" +
                ", name='" + name + '\'' +
                ", teacherDTO=" + teacherDTO +
                ", students=" + students +
                '}';
    }
}

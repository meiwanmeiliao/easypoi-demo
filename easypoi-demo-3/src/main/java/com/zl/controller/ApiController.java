package com.zl.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zl.dto.CourseDTO;
import com.zl.dto.StudentDTO;
import com.zl.dto.TeacherDTO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/21
 * @description: ${description}
 **/
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @RequestMapping(value = "export")
    public void export (HttpServletResponse response) throws IOException {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("张三");
        studentDTO.setBirthday(new Date());
        studentDTO.setRegistrationDate(new Date());
        studentDTO.setSex(1);
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName("张老师");
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName("这不课程");
        courseDTO.setStudents(studentDTOS);
        courseDTO.setTeacherDTO(teacherDTO);
        List<CourseDTO> list = new ArrayList<>();
        list.add(courseDTO);
        list.add(courseDTO);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("课程" ,"课程"),
                CourseDTO.class, list);
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition", "attachment; filename=" + new String("报表".getBytes("gb2312"), "ISO-8859-1") + ".xls");
        workbook.write(response.getOutputStream());
    }
}

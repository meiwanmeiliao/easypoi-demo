package com.zl.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.zl.dto.ExportDTO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
public class DemoController {

    @RequestMapping(value = "/export")
    public void export (HttpServletResponse response) throws IOException {
        List<ExportDTO> list = new ArrayList<>();
        ExportDTO exportDTO = new ExportDTO();
        exportDTO.setName("张三");
        exportDTO.setBirthday(new Date());
        exportDTO.setRegistrationDate(new Date());
        exportDTO.setSex(1);
        list.add(exportDTO);
        list.add(exportDTO);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"),
                ExportDTO.class, list);
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition", "attachment; filename=" + new String("报表".getBytes("gb2312"), "ISO-8859-1") + ".xls");
        workbook.write(response.getOutputStream());
    }
}

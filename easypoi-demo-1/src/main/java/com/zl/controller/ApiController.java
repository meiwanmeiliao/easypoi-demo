package com.zl.controller;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.zl.dto.EasyPoiDTO;
import com.zl.util.ExcelUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhuolin
 * @program: easypoi-demo
 * @date 2018/11/20
 * @description: ${description}
 **/
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @RequestMapping("07")
    public void toHtmlOf07Base (HttpServletResponse response) throws IOException, InvalidFormatException {
        FileInputStream inputStream = new FileInputStream(this.getClass().getClassLoader().getResource("template/aaa.xlsx").getPath());
        ExcelToHtmlParams params = new ExcelToHtmlParams(
                new XSSFWorkbook(OPCPackage.open(inputStream)), true, "yes");
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
    }

    /**
     * 03 版本EXCEL预览
     */
    @RequestMapping("03img")
    public void toHtmlOf03Img (HttpServletResponse response) throws IOException, InvalidFormatException {
        ExcelToHtmlParams params = new ExcelToHtmlParams(
                WorkbookFactory.create(POICacheManager.getFile("template/1easypoiExample.xls")),
                true, "yes");
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
    }


    @GetMapping(value = "/export")
    public void export (HttpServletResponse response) throws Exception {
        List<EasyPoiDTO> list = new ArrayList<EasyPoiDTO>();
        int count1 = 0;
        EasyPoiDTO easyPOIModel11 = new EasyPoiDTO(count1++, "信科", "张三", "男", 20);
        EasyPoiDTO easyPOIModel12 = new EasyPoiDTO(count1++, "信科", "李四", "男", 17);

        list.add(easyPOIModel11);
        list.add(easyPOIModel12);

        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams();
        // 标题开始行
        params.setHeadingStartRow(0);
        // 标题行数
        params.setHeadingRows(2);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        params.setSheetName("班级信息");
        params.setHeadingRows(2);
        params.setHeadingStartRow(2);
        params.setTempParams("t");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("class","高三一班");
        data.put("teacher","老张");
        data.put("list", list);
        Workbook book = ExcelUtil.getWorkbook(params, data, "1easypoiExample.xls");
        //下载
        ExcelUtil.export(response, book, "easypoi-excel.xls");

    }
}

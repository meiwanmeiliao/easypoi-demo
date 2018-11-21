package com.zl.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.alibaba.fastjson.JSON;
import com.zl.dto.UserDTO;
import com.zl.dto.UserExcelHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping("excelImport")
    public String excelImport (@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        ExcelDataHandlerDefaultImpl<UserDTO> handler = new UserExcelHandler();
        // 注意这里对应的是excel的列名。也就是对象上指定的列名。
        handler.setNeedHandlerFields(new String[]{"姓名"});
        importParams.setDataHanlder(handler);
        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<UserDTO> result = ExcelImportUtil.importExcelMore(file.getInputStream(), UserDTO.class,
                    importParams);
            List<UserDTO> successList = result.getList();
            return JSON.toJSONString(successList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

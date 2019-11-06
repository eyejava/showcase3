package com.jade.showcase.utils;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.net.URLDecoder;

public class ExcelUtils {

    public static void main(String[] args) throws IOException {
        String templatePath = URLDecoder
                .decode(Thread.currentThread().getContextClassLoader()
                        .getResource("").getPath(), "utf-8")
                + "download/order.xls";
        File templateFile = new File(templatePath);
        InputStream in = new FileInputStream(templateFile);
        byte[] buf = IOUtils.toByteArray(in);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        HSSFWorkbook workbook = new HSSFWorkbook(byteArrayInputStream);
        workbook.getName("test");
        System.out.println(workbook);
    }
}

package com.tianlei.core;

import com.tianlei.dao.tos;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@RestController
public class c1 {



    @GetMapping("/T")
    public String test(){
     System.out.println("进入程序");
    return "HI,T";

}

    @Resource
    private tos tos1;
    @GetMapping("/H")
    public void Import(Date VStData,Date VEndData ) throws Exception {
//        1.通过流读取Excel文件
        System.out.println("输出"+c1.class.getClassLoader().getResource("").getPath());
        FileInputStream inputStream = new FileInputStream("D:/JAVA_Projiect/demo1/target/classes/TS.xlsx");
//        2.通过poi解析流 HSSFWorkbook 处理流得到的对象中 就封装了Excel文件所有的数据
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//        3.从文件中获取表对象  getSheetAt通过下标获取
        XSSFSheet sheet = workbook.getSheetAt(0);
//        4.从表中获取到行数据  从第二行开始 到 最后一行  getLastRowNum() 获取最后一行的下标
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);
        Map<List<String>,String> map= new HashMap();
        List list=new ArrayList();
        for (int i = 1; i <= lastRowNum; i++) {
            tos tos1=new tos();
//            通过下标获取行
            XSSFRow row = sheet.getRow(i);
//            从行中获取数据

            /**
             * getNumericCellValue() 获取数字
             * getStringCellValue 获取String
             */
            String YY = row.getCell(7).getStringCellValue();
            String YJSJ = row.getCell(8).getStringCellValue();
            String YJSJMS = row.getCell(9).getStringCellValue();
            String FZR=row.getCell(14).getStringCellValue();
            String StData=row.getCell(15).getStringCellValue();
            String EndData=row.getCell(16).getStringCellValue();
            String WCData=row.getCell(17).getStringCellValue();
            String GS=row.getCell(21).getStringCellValue();
            String[] WCdata=WCData.split(" ");




            tos1.setYY(YY);
            tos1.setYJSJ(YJSJ);
            tos1.setYJSJMS(YJSJMS);
            tos1.setFZR(FZR);
            tos1.setStData(StData);
            tos1.setEndData(EndData);
            tos1.setWCData(WCData);
            tos1.setGS(GS);
            list.add(tos1);
//            封装到对象中

//            将对象添加数据库

        }
        c1 c=new c1();
        String a=c.createExcel(list);

    }
    public String createExcel(List<tos> list ) throws IOException {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
//建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("绩效表");
//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个

        Iterator<tos> it = list.iterator();
        int count=1;
        while (it.hasNext()) {
            tos str = (tos) it.next();
            HSSFRow row1=sheet.createRow(count);
            HSSFCell cell=row1.createCell(0);
            HSSFCell cel2=row1.createCell(1);
            HSSFCell cel3=row1.createCell(2);
            HSSFCell cel4=row1.createCell(3);
            HSSFCell cel5=row1.createCell(4);
            HSSFCell cel6=row1.createCell(5);
            HSSFCell cel7=row1.createCell(6);
            HSSFCell cel8=row1.createCell(7);
            cell.setCellValue(str.getYY());
            cel2.setCellValue(str.getYJSJ());
            cel3.setCellValue(str.getYJSJMS());
            cel4.setCellValue(str.getFZR());
            cel5.setCellValue(str.getStData());
            cel6.setCellValue(str.getEndData());
            cel7.setCellValue(str.getWCData());
            cel8.setCellValue(str.getGS());
            count=count+1;


        }
        OutputStream out = new FileOutputStream("E://a.xls");
       wb.write(out);
       wb.close();
       return "0";

    }

}

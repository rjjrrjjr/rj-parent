package easyexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;

/**
 * @Description:
 * @author: ruanjins
 * @Date: 2018-12-13 19:48
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Long startTime = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream("E:\\产品需求\\alog\\仓内薪酬\\测试数据-1212\\11月上架1-30号明细.xlsx");
        ExcelListener excelListener = new ExcelListener();
        //EasyExcelFactory.readBySax(inputStream, new Sheet(2, 1, ReadModel.class), excelListener);
        ExcelReader excelReader = new ExcelReader(inputStream, null, excelListener);
        //excelReader.read(new Sheet(1, 1, LoanInfo.class));
        excelReader.read();
        inputStream.close();
        System.out.println("===================" + (System.currentTimeMillis() - startTime));
        System.out.println(excelListener.getFirst());
        System.out.println(((List<String>)excelListener.getFirst()).size());
    }
}

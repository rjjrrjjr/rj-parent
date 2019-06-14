package easyexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.alibaba.excel.ExcelReader;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2018-12-13 16:44
 */
public class ReadExcel {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("E:\\产品需求\\alog\\仓内薪酬\\测试数据-1212\\11月上架1-30号明细.xlsx");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, null, listener);
            excelReader.read();
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

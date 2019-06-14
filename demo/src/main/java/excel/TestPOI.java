package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-01-07 16:40
 */
public class TestPOI {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\10064028\\Desktop\\青岛猫超12月份移位数据.xlsx"));
        System.out.println("========================");
        workbook.close();
    }
}

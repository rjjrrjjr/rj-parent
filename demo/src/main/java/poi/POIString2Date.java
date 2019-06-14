package poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2018-12-13 22:39
 */
public class POIString2Date {

    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook(new FileInputStream("E:\\产品需求\\date.xlsx"));

        Sheet sheetAt = workbook.getSheetAt(0);

        Row row = sheetAt.getRow(0);

        Cell cell = row.getCell(0);

        cell.setCellType(CellType.FORMULA);

        String cellFormula = cell.getCellFormula();

        System.out.println(cellFormula);
    }

}

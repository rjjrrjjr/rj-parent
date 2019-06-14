package easyexcel;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Data;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2018-12-13 16:42
 */
@Data
public class LoanInfo extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String attr0;

    @ExcelProperty(index = 1)
    private String attr1;

    @ExcelProperty(index = 8)
    private Integer attr8;

    @ExcelProperty(index = 9,format = "yyyy/MM/dd HH:mm")
    private Date attr9;

    @ExcelProperty(index = 12)
    private String attr12;

    @ExcelProperty(value = {"目标库位"})
    private String attr20;

    @Override
    public String toString() {
        return "LoanInfo{" +
                "attr0='" + attr0 + '\'' +
                ", attr1='" + attr1 + '\'' +
                ", attr8=" + attr8 +
                ", attr9=" + attr9 +
                ", attr12='" + attr12 + '\'' +
                ", attr20='" + attr20 + '\'' +
                '}';
    }
}

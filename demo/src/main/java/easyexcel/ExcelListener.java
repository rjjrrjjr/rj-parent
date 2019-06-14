package easyexcel;

import java.util.ArrayList;
import java.util.List;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import lombok.Data;

/**解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 * @Description:
 * @author: ruanjin
 * @Date: 2018-12-13 16:45
 */
@Data
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> data = new ArrayList<>();

    private Object first = null;

    public void invoke(Object object, AnalysisContext context) {
        System.out.println(context.getCurrentRowNum());
        if (context.getCurrentRowNum() == 0){
            first = object;
        }
        if(data.size()<=100){
            data.add(object);
        }else {
            doSomething();
            data = new ArrayList<>();
        }
    }
    private void doSomething() {
        //1、入库调用接口
        for (Object o:data) {
            List<String> o1 = (List<String>) o;
            System.out.println(o1);
            System.out.println("=============================size" + o1.size());
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源

        System.out.println("==================end");
    }
}
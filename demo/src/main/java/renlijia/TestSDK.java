package renlijia;

import java.util.Arrays;
import java.util.Objects;

import com.renlijia.api.common.DefaultRenlijiaOpenClient;
import com.renlijia.api.common.RenlijiaOpenClient;
import com.renlijia.api.common.enums.MatchTypeEnum;
import com.renlijia.api.exception.ApiException;
import com.renlijia.api.salary.data.FloatDataImportRequest;
import com.renlijia.api.salary.data.FloatDataImportResponse;

/**
 * @Description:
 * @author: ruanjin
 * @Date: 2019-03-12 15:20
 */
public class TestSDK {
    private static final int SUCCESS_CODE = 200;

    public static void main(String[] args) {
        String appKey = "";
        String appSecret = "";

        RenlijiaOpenClient client = new DefaultRenlijiaOpenClient(appKey, appSecret);
        FloatDataImportRequest request = new FloatDataImportRequest();
        request.setCurrentStage("RELEASE");
        request.setSalaryGroupName("研发部");
        request.setCalBizId("201902M");
        request.setMatchItem("姓名");
        request.setMatchType(MatchTypeEnum.NAME.getKey());
        request.setHeader(Arrays.asList("姓名", "浮动工资", "迟到天数", "社保扣除"));
        request.setData(Arrays.asList(
                Arrays.asList("张三", "8000", "3", "1000"),
                Arrays.asList("李四", "8000", "3", "1000"),
                Arrays.asList("王五", "8000", "3", "1000")
        ));
        try {
            FloatDataImportResponse response = client.execute(request);
            if (Objects.equals(response.getCode(), SUCCESS_CODE) && response.getSuccess()) {
                System.out.println("success");
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}

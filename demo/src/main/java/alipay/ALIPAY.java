package alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayOfflineMaterialImageUploadRequest;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.response.AlipayOfflineMaterialImageUploadResponse;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;

/**
 * 支付宝支付SDK
 * 确定接口对应的类
 * 例如接口名：alipay.offline.material.image.upload
 * 在SDK中对应的类为：每个单词首字母大写，并去掉分隔符（“.”），末尾加上Request（或Response）
 * 如上接口名对应的类为：
 * AlipayOfflineMaterialImageUploadRequest（请求类）
 * AlipayOfflineMaterialImageUploadResponse（响应类）
 *
 * @Description:
 * @author: ruanjin
 * @Date: 2018-12-28 9:18
 */
public class ALIPAY {

    public void generalPay() throws AlipayApiException {
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "APP_ID", "APP_PRIVATE_KEY", AlipayConstants.FORMAT_JSON, "CHARSET", "ALIPAY_PUBLIC_KEY", "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify
        AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数
        //此次只是参数展示，未进行字符串转义，实际情况下请转义
        request.setBizContent("  {" +
                "    \"primary_industry_name\":\"IT科技/IT软件与服务\"," +
                "    \"primary_industry_code\":\"10001/20102\"," +
                "    \"secondary_industry_code\":\"10001/20102\"," +
                "    \"secondary_industry_name\":\"IT科技/IT软件与服务\"" +
                " }");
        AlipayOpenPublicTemplateMessageIndustryModifyResponse response = alipayClient.execute(request);
        //调用成功，则处理业务逻辑
        if (response.isSuccess()) {
            //.....
        }
    }

    public void imageUpload() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "APP_ID", "APP_PRIVATE_KEY", AlipayConstants.FORMAT_JSON, "CHARSET", "ALIPAY_PUBLIC_KEY", "RSA2");
        // 实例化具体API对应的request类,类名称和接口名称对应，当前调用接口名称：alipay.offline.material.image.upload
        AlipayOfflineMaterialImageUploadRequest request = new AlipayOfflineMaterialImageUploadRequest();
        request.setImageName("test");
        //Windows请填写绝对路径，不支持相对路径；Linux支持相对路径
        FileItem item = new FileItem("C:/Downloads/ooopic_963991_7eea1f5426105f9e6069/16365_1271139700.jpg");
        request.setImageType("JPG");
        request.setImageContent(item);
        //执行API请求
        AlipayOfflineMaterialImageUploadResponse response = alipayClient.execute(request);
        //调用成功，则处理业务逻辑
        if (response.isSuccess()) {
            //获取图片访问地址
            String imageUrl = response.getImageUrl();
            //.....
        }
    }
}

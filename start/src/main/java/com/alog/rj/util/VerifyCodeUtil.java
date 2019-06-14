package com.alog.rj.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by 10064028 on 2018/1/12.
 */
public class VerifyCodeUtil {

    /**
     * 验证码类型为仅数字,即0~9
     */
    public static final int TYPE_NUM_ONLY = 0;

    /**
     * 验证码类型为仅字母,即大小写字母混合
     */
    public static final int TYPE_LETTER_ONLY = 1;

    /**
     * 验证码类型为数字和大小写字母混合
     */
    public static final int TYPE_ALL_MIXED = 2;

    /**
     * 验证码类型为数字和大写字母混合
     */
    public static final int TYPE_NUM_UPPER = 3;

    /**
     * 验证码类型为数字和小写字母混合
     */
    public static final int TYPE_NUM_LOWER = 4;

    /**
     * 验证码类型为仅大写字母
     */
    public static final int TYPE_UPPER_ONLY = 5;

    /**
     * 验证码类型为仅小写字母
     */
    public static final int TYPE_LOWER_ONLY = 6;

    public VerifyCodeUtil() {
    }

    private static Color generateRandomColor(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static BufferedImage generateImageCode(int type, int length, String excludeString, int width, int height, int interLine, boolean randomLocation, Color backColor, Color forceColor, Color lineColor){
        String textCode = generateTextCode(type, length, excludeString);
        return generateImageCode(textCode, width, height, interLine, randomLocation, backColor, forceColor, lineColor);

    }

    public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine, boolean randomLocation, Color backColor, Color foreColor, Color lineColor){
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(backColor == null ? generateRandomColor() : backColor);
        graphics.fillRect(0, 0, width, height);
        Random random = new Random();
        if (interLine > 0){
            int x = 0, y = 0,x1 = width, y1 = height;
            for (int i = 0; i < interLine; i++){
                graphics.setColor(lineColor == null ? generateRandomColor() : lineColor);
                y = random.nextInt(height);
                y1 = random.nextInt(height);
                graphics.drawLine(x, y, x1, y1);
            }
        }
        int fsize = (int) (height * 0.8);
        int fx = height - fsize;
        int fy = fsize;
        graphics.setFont(new Font("Default", Font.PLAIN, fsize));
        for (int i = 0; i < textCode.length(); i++){
            fy = randomLocation ? (int) ((Math.random() * 0.3 + 0.6) * height) : fy;
            graphics.setColor(foreColor == null ? generateRandomColor() : foreColor);
            graphics.drawString(textCode.charAt(i) + "", fx, fy);
            fx += fsize * 0.9;
        }
        graphics.dispose();
        return bufferedImage;
    }

    public static String generateTextCode(int type, int length, String excludeString){
        if (length <= 0){
            return "";
        }
        StringBuffer verifyCode = new StringBuffer();
        int i = 0;
        Random random = new Random();
        switch (type){
            case TYPE_NUM_ONLY:
                while (i < length){
                    int t = random.nextInt(10);
                    if (excludeString == null || excludeString.indexOf(t + "") < 0){
                        verifyCode.append(t);
                        i ++;
                    }
                }
                break;
            case TYPE_LETTER_ONLY:
                while(i < length){
                    int t = random.nextInt(123);
                    if((t>=97 || (t>=65&&t<=90)) && (null==excludeString||excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_ALL_MIXED:
                while(i < length){
                    int t = random.nextInt(123);
                    if((t>=97 || (t>=65&&t<=90) || (t>=48&&t<=57)) && (null==excludeString||excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_UPPER:
                while(i < length){
                    int t = random.nextInt(91);
                    if((t>=65 || (t>=48&&t<=57)) && (null==excludeString || excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_LOWER:
                while(i < length){
                    int t = random.nextInt(123);
                    if((t>=97 || (t>=48&&t<=57)) && (null==excludeString || excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_UPPER_ONLY:
                while(i < length){
                    int t = random.nextInt(91);
                    if((t >= 65) && (null==excludeString||excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_LOWER_ONLY:
                while(i < length){
                    int t = random.nextInt(123);
                    if((t>=97) && (null==excludeString||excludeString.indexOf((char)t)<0)){
                        verifyCode.append((char)t);
                        i++;
                    }
                }
                break;
        }
        return verifyCode.toString();
    }
}

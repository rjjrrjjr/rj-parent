package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 10064028 on 2018/3/1.
 */
public class TestTryWithResources {
    public static void main(String[] args) throws IOException {

        try(java.util.zip.ZipFile zf = new java.util.zip.ZipFile("");
            FileInputStream fileInputStream = new FileInputStream("")){
            zf.close();
            fileInputStream.close();

        }
    }

}

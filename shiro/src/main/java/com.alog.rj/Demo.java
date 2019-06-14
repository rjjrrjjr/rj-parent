package com.alog.rj;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.Part;

/**
 * Created by 10064028 on 2018/1/9.
 */
public class Demo implements Serializable {

    private static final long serialVersionUID = -796908910086659983L;

    public static void main(String[] args) {
        Part part = new Part() {
            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public void write(String s) throws IOException {

            }

            @Override
            public void delete() throws IOException {

            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaderNames() {
                return null;
            }
        };
    }
}

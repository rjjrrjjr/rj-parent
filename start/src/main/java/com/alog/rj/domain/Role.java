package com.alog.rj.domain;

import java.io.Serializable;
import java.util.List;



/**
 * Created by 10064028 on 2018/1/12.
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -6792267937419101302L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

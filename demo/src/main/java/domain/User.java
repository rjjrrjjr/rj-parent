package domain;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by 10064028 on 2018/1/31.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2412382549946884291L;
    private String name;
    private Integer age;
}

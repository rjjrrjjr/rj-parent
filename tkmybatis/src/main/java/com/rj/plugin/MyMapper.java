package com.rj.plugin;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by 10064028 on 2018/2/24.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

}

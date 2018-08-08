package com.ant.support;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author lilj
 * @date 18/08/08
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
    /*
     * Mapper接口：基本的增、删、改、查方法
     * MySqlMapper：针对MySQL的额外补充接口，支持批量插入
     */
    /*
     * Spring-boot启动类，@MapperScan仅扫描业务接口包，不能扫描本地通用Mapper接口包，否则报java.lang.ClassCastException异常
     */
}

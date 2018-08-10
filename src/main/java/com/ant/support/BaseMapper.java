package com.ant.support;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Mapper接口：基本的增、删、改、查方法
 * MySqlMapper：针对MySQL的额外补充接口，支持批量插入
 * @author lilj
 * @date 18/08/08
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
    /*
     *
     * 1、报错：java.lang.ClassCastException
     *        Spring-boot启动类，@MapperScan仅扫描业务接口包，不能扫描本地通用Mapper接口包
     *
     * 2、报错：org.springframework.beans.factory.UnsatisfiedDependencyException:
     *        通用mapper和本地写的mapper.xml方法冲突（重复）
     *
     * 3、报错：java.lang.NoSuchMethodException: tk.mybatis.mapper.provider.base.BaseSelectProvider.<init>
     *        之前版本的通用mappers在配置mapper扫描配置@MapperScan时导入的MapperScan;，以org.mybatis开头的jar包，
     *        在换为新版的通用mapper时，需要将jar包换为以tk.mybatis开头的，才可以避免该错误。
     *
     * 4、报错：com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'class_id' in 'field list'
     *        通用mapper会把驼峰命名的classId转为表字段class_id，可用@Column(name = "classId")注明表字段
     *
     * 5、使用selectByPrimaryKey(Object o)，需要在主键上加注释 @Id
     */

}

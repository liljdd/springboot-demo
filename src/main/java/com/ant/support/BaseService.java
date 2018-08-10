package com.ant.support;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author lilj
 * @date 18/08/10
 */
public class BaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;

    private Class<T> clazz;

    public BaseService() {
        // 获取父类的type
        Type type = this.getClass().getGenericSuperclass();

        // 强转为ParameterizedType，可以使用获取泛型类型的方法
        ParameterizedType pType = (ParameterizedType) type;

        // 获取泛型的class
        this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
    }

    public T queryById(Long id) {
        T t = this.mapper.selectByPrimaryKey(id);
        return t;
    }

    public List<T> queryAll() {
        List<T> list = this.mapper.selectAll();
        return list;
    }

    public Integer queryCountByWhere(T t) {
        int count = this.mapper.selectCount(t);
        return count;
    }

    public List<T> queryListByWhere(T t) {
        List<T> list = this.mapper.select(t);
        return list;
    }

    public PageInfo<T> queryListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = this.mapper.selectAll();
        PageInfo page = new PageInfo(list);
        return page;
    }

    public T queryOne(T t) {
        T result = this.mapper.selectOne(t);
        return result;
    }

    public void save(T t) {
        this.mapper.insert(t);
    }

    public void saveSelective(T t) {
        this.mapper.insertSelective(t);
    }

    public void updateById(T t) {
        this.mapper.updateByPrimaryKey(t);
    }

    public void updateByIdSelective(T t) {
        this.mapper.updateByPrimaryKeySelective(t);
    }

    public void deleteById(Long id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(List<Object> ids) {
        Example example = new Example(this.clazz);
        example.createCriteria().andIn("id", ids);
        this.mapper.deleteByExample(example);
    }


}

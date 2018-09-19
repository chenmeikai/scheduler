
package com.kenhome.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.kenhome.mapper.BaseMapper;
import com.kenhome.service.BaseService;


public class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    private BaseMapper<T> baseMapper;


    public void setMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    /**
     * 查询单条记录
     *
     * @param entity
     * @return
     */
    public T selectOne(Object obj) {
        return baseMapper.selectOne(obj);
    }

    /**
     * 查询记录集合
     *
     * @param entity
     * @return
     */
    public List<T> selectList(Object obj) {
        return baseMapper.selectList(obj);
    }


    /**
     * 通用的保存方法
     *
     * @param <T>
     * @param entity
     */
    public int save(Object obj) {
        return baseMapper.save(obj);
    }

    /**
     * 批量保存
     *
     * @param list
     */
    public int batchSave(List<T> list) {
        return baseMapper.batchSave(list);
    }

    /**
     * 通用的修改方法
     *
     * @param <T>
     * @param entity
     */
    public int update(Object obj) {
        return baseMapper.update(obj);
    }

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    public int batchUpdate(List<T> list) {
        return baseMapper.batchUpdate(list);
    }

    /**
     * 删除方法
     *
     * @param id
     */
    public int delById(Serializable id) {
        return baseMapper.delById(id);
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    public int delList(List<T> list) {
        return baseMapper.delList(list);
    }

    /**
     * 批量删除方法
     *
     * @param ids
     */
    public int delArray(int[] ids) {
        return baseMapper.delArray(ids);
    }

    /**
     * 统计查询
     *
     * @param <T>
     * @param params 查询参数
     * @return 总记录条数
     */
    public int count(Object obj) {
        return baseMapper.count(obj);
    }


}

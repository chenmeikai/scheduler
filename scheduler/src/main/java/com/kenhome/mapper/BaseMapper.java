
package com.kenhome.mapper;

import java.io.Serializable;
import java.util.List;


/**
 * @param <T>
 * @ClassName: BaseMapper
 * @Description:mapper基类
 */

public interface BaseMapper<T> {

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /**
     * 查询单条记录
     *
     * @param entity
     * @return
     */
    T selectOne(Object obj);

    /**
     * 查询记录集合
     *
     * @param entity
     * @return
     */
    List<T> selectList(Object obj);


    /**
     * 通用的保存方法
     *
     * @param <T>
     * @param entity
     */
    int save(Object obj);

    /**
     * 批量保存
     *
     * @param list
     */
    int batchSave(List<T> list);

    /**
     * 通用的修改方法
     *
     * @param <T>
     * @param entity
     */
    int update(Object obj);

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdate(List<T> list);

    /**
     * 删除方法
     *
     * @param id
     */
    int delById(Serializable id);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int delList(List<T> list);

    /**
     * 批量删除方法
     *
     * @param ids
     */
    int delArray(int[] ids);

    /**
     * 统计查询
     *
     * @param <T>
     * @param params 查询参数
     * @return 总记录条数
     */
    int count(Object obj);

}
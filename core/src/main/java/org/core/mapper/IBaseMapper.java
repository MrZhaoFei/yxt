package org.core.mapper;

import java.util.List;
import java.util.Map;

import org.core.entity.BaseEntity;

/**
 * @ClassName IBaseMapper
 * @author <font color="red"><b>MrLiu</b></font>
 * @date 2016年3月2日 上午9:41:05
 * @version 1.0
 * @param <T>
 * @description
 */
public abstract interface IBaseMapper<T extends BaseEntity> {

	abstract int insert(T entity);

	abstract int delete(T entity);

	abstract int update(T entity);

	abstract Map<String, Object> queryOne(T entity);

	abstract Map<String, Object> checkExists(T entity);

	abstract List<Map<String, Object>> queryAll(T entity);

}
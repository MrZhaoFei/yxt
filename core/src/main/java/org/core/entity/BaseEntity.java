package org.core.entity;

/**
 * @ClassName BaseEntity
 * @author <font color="red"><b>LiuGangQiang</b></font>
 * @date 2016年2月17日 下午4:08:15
 * @version 1.0
 * @description 实体类父类
 */
public class BaseEntity {
	Integer page;
	Integer rows;
	Integer total;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}

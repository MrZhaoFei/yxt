package org.system.entity.user;

import javax.validation.constraints.NotNull;

import org.core.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

public class User extends BaseEntity {

	public interface insertUser {
	};

	public interface updateUser {
	};

	public interface queryUser {
	};

	public interface deleteUser {
	};

	private Integer id;
	@NotBlank(message = "{user.phone.notblank.valid.message}", groups = { queryUser.class, insertUser.class ,updateUser.class})
	private String phone;

	@NotBlank(message = "{user.password.notblank.valid.message}", groups = { queryUser.class })
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@NotNull(message = "{page.empty}", groups = { queryUser.class })
	public Integer getPage() {
		return super.getPage();
	}

	@Override
	@NotNull(message = "{rows.empty}", groups = { queryUser.class })
	public Integer getRows() {
		return super.getRows();
	}
}
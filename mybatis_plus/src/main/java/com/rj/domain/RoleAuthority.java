package com.rj.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rj
 * @since 2018-01-30
 */
@TableName("t_role_authority")
public class RoleAuthority extends Model<RoleAuthority> {

    private static final long serialVersionUID = 1L;

	private Long id;
	@TableField("role_id")
	private Long roleId;
	@TableField("authority_id")
	private Long authorityId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RoleAuthority{" +
			"id=" + id +
			", roleId=" + roleId +
			", authorityId=" + authorityId +
			"}";
	}
}

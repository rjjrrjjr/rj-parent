package com.rj.domain;

import java.io.Serializable;

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
@TableName("t_authority")
public class Authority extends Model<Authority> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String code;
    /**
     * 是否删除；0：否，1：是
     */
	private Integer del;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Authority{" +
			"id=" + id +
			", name=" + name +
			", code=" + code +
			", del=" + del +
			"}";
	}
}

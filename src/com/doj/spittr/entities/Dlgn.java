/**
 * 
 */
package com.doj.spittr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dinesh.Rajput
 *
 */

@Entity
@Table(name = "DLGN")
public class Dlgn implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long lgnid;
	private String lgnun;
	private String lgnpwd;
	private Long roleid;
	private Long lgnusrid;
	private Date createdate;
	private Date modidate;
	private String exfield1;
	private Long exfield2;
	public Long getLgnid() {
		return lgnid;
	}
	public void setLgnid(Long lgnid) {
		this.lgnid = lgnid;
	}
	public String getLgnun() {
		return lgnun;
	}
	public void setLgnun(String lgnun) {
		this.lgnun = lgnun;
	}
	public String getLgnpwd() {
		return lgnpwd;
	}
	public void setLgnpwd(String lgnpwd) {
		this.lgnpwd = lgnpwd;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Long getLgnusrid() {
		return lgnusrid;
	}
	public void setLgnusrid(Long lgnusrid) {
		this.lgnusrid = lgnusrid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public String getExfield1() {
		return exfield1;
	}
	public void setExfield1(String exfield1) {
		this.exfield1 = exfield1;
	}
	public Long getExfield2() {
		return exfield2;
	}
	public void setExfield2(Long exfield2) {
		this.exfield2 = exfield2;
	}
	public Dlgn(Long lgnid, String lgnun, String lgnpwd, Long roleid,
			Long lgnusrid, Date createdate, Date modidate, String exfield1,
			Long exfield2) {
		super();
		this.lgnid = lgnid;
		this.lgnun = lgnun;
		this.lgnpwd = lgnpwd;
		this.roleid = roleid;
		this.lgnusrid = lgnusrid;
		this.createdate = createdate;
		this.modidate = modidate;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
	}
	public Dlgn() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result
				+ ((exfield1 == null) ? 0 : exfield1.hashCode());
		result = prime * result
				+ ((exfield2 == null) ? 0 : exfield2.hashCode());
		result = prime * result + ((lgnid == null) ? 0 : lgnid.hashCode());
		result = prime * result + ((lgnpwd == null) ? 0 : lgnpwd.hashCode());
		result = prime * result + ((lgnun == null) ? 0 : lgnun.hashCode());
		result = prime * result
				+ ((lgnusrid == null) ? 0 : lgnusrid.hashCode());
		result = prime * result
				+ ((modidate == null) ? 0 : modidate.hashCode());
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dlgn other = (Dlgn) obj;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (exfield1 == null) {
			if (other.exfield1 != null)
				return false;
		} else if (!exfield1.equals(other.exfield1))
			return false;
		if (exfield2 == null) {
			if (other.exfield2 != null)
				return false;
		} else if (!exfield2.equals(other.exfield2))
			return false;
		if (lgnid == null) {
			if (other.lgnid != null)
				return false;
		} else if (!lgnid.equals(other.lgnid))
			return false;
		if (lgnpwd == null) {
			if (other.lgnpwd != null)
				return false;
		} else if (!lgnpwd.equals(other.lgnpwd))
			return false;
		if (lgnun == null) {
			if (other.lgnun != null)
				return false;
		} else if (!lgnun.equals(other.lgnun))
			return false;
		if (lgnusrid == null) {
			if (other.lgnusrid != null)
				return false;
		} else if (!lgnusrid.equals(other.lgnusrid))
			return false;
		if (modidate == null) {
			if (other.modidate != null)
				return false;
		} else if (!modidate.equals(other.modidate))
			return false;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dlgn [lgnid=" + lgnid + ", lgnun=" + lgnun + ", lgnpwd="
				+ lgnpwd + ", roleid=" + roleid + ", lgnusrid=" + lgnusrid
				+ ", createdate=" + createdate + ", modidate=" + modidate
				+ ", exfield1=" + exfield1 + ", exfield2=" + exfield2 + "]";
	}
	
}

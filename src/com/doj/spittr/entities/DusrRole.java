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
@Table(name = "DUSRROLE")
public class DusrRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long usrroleid;
	private String usrroletype;
	private String usrroleclass;
	private Date createdate;
	private Date modidate;
	private String exfield1;
	private Long exfield2;
	private String isdeleted;
	private String active;
	public Long getUsrroleid() {
		return usrroleid;
	}
	public void setUsrroleid(Long usrroleid) {
		this.usrroleid = usrroleid;
	}
	public String getUsrroletype() {
		return usrroletype;
	}
	public void setUsrroletype(String usrroletype) {
		this.usrroletype = usrroletype;
	}
	public String getUsrroleclass() {
		return usrroleclass;
	}
	public void setUsrroleclass(String usrroleclass) {
		this.usrroleclass = usrroleclass;
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
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public DusrRole(Long usrroleid, String usrroletype, String usrroleclass,
			Date createdate, Date modidate, String exfield1, Long exfield2,
			String isdeleted, String active) {
		super();
		this.usrroleid = usrroleid;
		this.usrroletype = usrroletype;
		this.usrroleclass = usrroleclass;
		this.createdate = createdate;
		this.modidate = modidate;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
		this.isdeleted = isdeleted;
		this.active = active;
	}
	public DusrRole() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result
				+ ((exfield1 == null) ? 0 : exfield1.hashCode());
		result = prime * result
				+ ((exfield2 == null) ? 0 : exfield2.hashCode());
		result = prime * result
				+ ((isdeleted == null) ? 0 : isdeleted.hashCode());
		result = prime * result
				+ ((modidate == null) ? 0 : modidate.hashCode());
		result = prime * result
				+ ((usrroleclass == null) ? 0 : usrroleclass.hashCode());
		result = prime * result
				+ ((usrroleid == null) ? 0 : usrroleid.hashCode());
		result = prime * result
				+ ((usrroletype == null) ? 0 : usrroletype.hashCode());
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
		DusrRole other = (DusrRole) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
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
		if (isdeleted == null) {
			if (other.isdeleted != null)
				return false;
		} else if (!isdeleted.equals(other.isdeleted))
			return false;
		if (modidate == null) {
			if (other.modidate != null)
				return false;
		} else if (!modidate.equals(other.modidate))
			return false;
		if (usrroleclass == null) {
			if (other.usrroleclass != null)
				return false;
		} else if (!usrroleclass.equals(other.usrroleclass))
			return false;
		if (usrroleid == null) {
			if (other.usrroleid != null)
				return false;
		} else if (!usrroleid.equals(other.usrroleid))
			return false;
		if (usrroletype == null) {
			if (other.usrroletype != null)
				return false;
		} else if (!usrroletype.equals(other.usrroletype))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DusrRole [usrroleid=" + usrroleid + ", usrroletype="
				+ usrroletype + ", usrroleclass=" + usrroleclass
				+ ", createdate=" + createdate + ", modidate=" + modidate
				+ ", exfield1=" + exfield1 + ", exfield2=" + exfield2
				+ ", isdeleted=" + isdeleted + ", active=" + active + "]";
	}
	
}

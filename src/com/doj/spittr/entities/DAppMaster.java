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
@Table(name = "DAPPMASTER")
public class DAppMaster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long appmasid;
	private String appmasgrp;
	private String appmasdesc;
	private Long appmasmasid;
	private Date createdate;
	private Date modidate;
	private String exfield1;
	private Long exfield2;
	private String isdeleted;
	private String active;
	private Double sequence;
	public Long getAppmasid() {
		return appmasid;
	}
	public void setAppmasid(Long appmasid) {
		this.appmasid = appmasid;
	}
	public String getAppmasgrp() {
		return appmasgrp;
	}
	public void setAppmasgrp(String appmasgrp) {
		this.appmasgrp = appmasgrp;
	}
	public String getAppmasdesc() {
		return appmasdesc;
	}
	public void setAppmasdesc(String appmasdesc) {
		this.appmasdesc = appmasdesc;
	}
	public Long getAppmasmasid() {
		return appmasmasid;
	}
	public void setAppmasmasid(Long appmasmasid) {
		this.appmasmasid = appmasmasid;
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
	public Double getSequence() {
		return sequence;
	}
	public void setSequence(Double sequence) {
		this.sequence = sequence;
	}
	public DAppMaster(Long appmasid, String appmasgrp, String appmasdesc,
			Long appmasmasid, Date createdate, Date modidate, String exfield1,
			Long exfield2, String isdeleted, String active, Double sequence) {
		super();
		this.appmasid = appmasid;
		this.appmasgrp = appmasgrp;
		this.appmasdesc = appmasdesc;
		this.appmasmasid = appmasmasid;
		this.createdate = createdate;
		this.modidate = modidate;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
		this.isdeleted = isdeleted;
		this.active = active;
		this.sequence = sequence;
	}
	public DAppMaster() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((appmasdesc == null) ? 0 : appmasdesc.hashCode());
		result = prime * result
				+ ((appmasgrp == null) ? 0 : appmasgrp.hashCode());
		result = prime * result
				+ ((appmasid == null) ? 0 : appmasid.hashCode());
		result = prime * result
				+ ((appmasmasid == null) ? 0 : appmasmasid.hashCode());
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
				+ ((sequence == null) ? 0 : sequence.hashCode());
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
		DAppMaster other = (DAppMaster) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (appmasdesc == null) {
			if (other.appmasdesc != null)
				return false;
		} else if (!appmasdesc.equals(other.appmasdesc))
			return false;
		if (appmasgrp == null) {
			if (other.appmasgrp != null)
				return false;
		} else if (!appmasgrp.equals(other.appmasgrp))
			return false;
		if (appmasid == null) {
			if (other.appmasid != null)
				return false;
		} else if (!appmasid.equals(other.appmasid))
			return false;
		if (appmasmasid == null) {
			if (other.appmasmasid != null)
				return false;
		} else if (!appmasmasid.equals(other.appmasmasid))
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
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DAppMaster [appmasid=" + appmasid + ", appmasgrp=" + appmasgrp
				+ ", appmasdesc=" + appmasdesc + ", appmasmasid=" + appmasmasid
				+ ", createdate=" + createdate + ", modidate=" + modidate
				+ ", exfield1=" + exfield1 + ", exfield2=" + exfield2
				+ ", isdeleted=" + isdeleted + ", active=" + active
				+ ", sequence=" + sequence + "]";
	}
	
}

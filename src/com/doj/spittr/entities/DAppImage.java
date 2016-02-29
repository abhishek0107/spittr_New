/**
 * 
 */
package com.doj.spittr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
/**
 * @author Dinesh.Rajput
 *
 */
@Entity
@Table(name = "DAPPIMAGE")
public class DAppImage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appimgid;
	private  Blob appimgdata;
	private String appimgtype;
	private Long appimgusrid;
	private Date modidate;
	private Date createdate;
	private Long appimgmod;
	
	public Long getAppimgid() {
		return appimgid;
	}
	public void setAppimgid(Long appimgid) {
		this.appimgid = appimgid;
	}
	public Blob getAppimgdata() {
		return (Blob) appimgdata;
	}
	public void setAppimgdata(Blob appimgdata) {
		this.appimgdata = appimgdata;
	}
	public String getAppimgtype() {
		return appimgtype;
	}
	public void setAppimgtype(String appimgtype) {
		this.appimgtype = appimgtype;
	}
	public Long getAppimgusrid() {
		return appimgusrid;
	}
	public void setAppimgusrid(Long appimgusrid) {
		this.appimgusrid = appimgusrid;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Long getAppimgmod() {
		return appimgmod;
	}
	public void setAppimgmod(Long appimgmod) {
		this.appimgmod = appimgmod;
	}
	
	public DAppImage(Long appimgid, Blob appimgdata, String appimgtype,
			Long appimgusrid, Date modidate, Date createdate, Long appimgmod) {
		super();
		this.appimgid = appimgid;
		this.appimgdata = appimgdata;
		this.appimgtype = appimgtype;
		this.appimgusrid = appimgusrid;
		this.modidate = modidate;
		this.createdate = createdate;
		this.appimgmod = appimgmod;
	}
	
	public DAppImage() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appimgdata == null) ? 0 : appimgdata.hashCode());
		result = prime * result
				+ ((appimgid == null) ? 0 : appimgid.hashCode());
		result = prime * result
				+ ((appimgmod == null) ? 0 : appimgmod.hashCode());
		result = prime * result
				+ ((appimgtype == null) ? 0 : appimgtype.hashCode());
		result = prime * result
				+ ((appimgusrid == null) ? 0 : appimgusrid.hashCode());
		result = prime * result
				+ ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result
				+ ((modidate == null) ? 0 : modidate.hashCode());
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
		DAppImage other = (DAppImage) obj;
		if (appimgdata == null) {
			if (other.appimgdata != null)
				return false;
		} else if (!appimgdata.equals(other.appimgdata))
			return false;
		if (appimgid == null) {
			if (other.appimgid != null)
				return false;
		} else if (!appimgid.equals(other.appimgid))
			return false;
		if (appimgmod == null) {
			if (other.appimgmod != null)
				return false;
		} else if (!appimgmod.equals(other.appimgmod))
			return false;
		if (appimgtype == null) {
			if (other.appimgtype != null)
				return false;
		} else if (!appimgtype.equals(other.appimgtype))
			return false;
		if (appimgusrid == null) {
			if (other.appimgusrid != null)
				return false;
		} else if (!appimgusrid.equals(other.appimgusrid))
			return false;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (modidate == null) {
			if (other.modidate != null)
				return false;
		} else if (!modidate.equals(other.modidate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DAppImage [appimgid=" + appimgid + ", appimgdata=" + appimgdata
				+ ", appimgtype=" + appimgtype + ", appimgusrid=" + appimgusrid
				+ ", modidate=" + modidate + ", createdate=" + createdate
				+ ", appimgmod=" + appimgmod + "]";
	}
	
}

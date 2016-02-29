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

/**
 * @author Dinesh.Rajput
 *
 */
@Entity
@Table(name = "DFLWR")
public class Dflwr implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long flwrid;
	private Long flwrusrid;
	private Long followerId;
	private Date createdate;
	private Date modidate;
	private String exfield1;
	private Long exfield2;
	
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public Long getFlwrid() {
		return flwrid;
	}
	public void setFlwrid(Long flwrid) {
		this.flwrid = flwrid;
	}
	public Long getFlwrusrid() {
		return flwrusrid;
	}
	public void setFlwrusrid(Long flwrusrid) {
		this.flwrusrid = flwrusrid;
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
	
	public Dflwr() {
		super();
	}
	
	public Dflwr(Long flwrid, Long flwrusrid, Long followerId,
			Date createdate, Date modidate, String exfield1, Long exfield2) {
		super();
		this.flwrid = flwrid;
		this.flwrusrid = flwrusrid;
		this.followerId = followerId;
		this.createdate = createdate;
		this.modidate = modidate;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
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
		result = prime * result
				+ ((followerId == null) ? 0 : followerId.hashCode());
		result = prime * result + ((flwrid == null) ? 0 : flwrid.hashCode());
		result = prime * result
				+ ((flwrusrid == null) ? 0 : flwrusrid.hashCode());
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
		Dflwr other = (Dflwr) obj;
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
		if (followerId == null) {
			if (other.followerId != null)
				return false;
		} else if (!followerId.equals(other.followerId))
			return false;
		if (flwrid == null) {
			if (other.flwrid != null)
				return false;
		} else if (!flwrid.equals(other.flwrid))
			return false;
		if (flwrusrid == null) {
			if (other.flwrusrid != null)
				return false;
		} else if (!flwrusrid.equals(other.flwrusrid))
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
		return "Dflwr [flwrid=" + flwrid + ", flwrusrid=" + flwrusrid
				+ ", flwrfollow=" + followerId + ", createdate=" + createdate
				+ ", modidate=" + modidate + ", exfield1=" + exfield1
				+ ", exfield2=" + exfield2 + "]";
	}

}

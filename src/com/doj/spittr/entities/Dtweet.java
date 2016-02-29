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
@Table(name = "DTWEET")
public class Dtweet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tweetid;
	private String tweetmsg;
	private Long tweetusrid;
	private Date createdate;
	private Date modidate;
	private String exfield1;
	private Long exfield2;
	private String isdeleted;
	private String active;
	private Long tweetmod;
	
	public Long getTweetid() {
		return tweetid;
	}
	public void setTweetid(Long tweetid) {
		this.tweetid = tweetid;
	}
	public String getTweetmsg() {
		return tweetmsg;
	}
	public void setTweetmsg(String tweetmsg) {
		this.tweetmsg = tweetmsg;
	}
	public Long getTweetusrid() {
		return tweetusrid;
	}
	public void setTweetusrid(Long tweetusrid) {
		this.tweetusrid = tweetusrid;
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
	public Long getTweetmod() {
		return tweetmod;
	}
	public void setTweetmod(Long tweetmod) {
		this.tweetmod = tweetmod;
	}
	
	public Dtweet() {
		super();
	}
	
	public Dtweet(Long tweetid, String tweetmsg, Long tweetusrid,
			Date createdate, Date modidate, String exfield1, Long exfield2,
			String isdeleted, String active, Long tweetmod) {
		super();
		this.tweetid = tweetid;
		this.tweetmsg = tweetmsg;
		this.tweetusrid = tweetusrid;
		this.createdate = createdate;
		this.modidate = modidate;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
		this.isdeleted = isdeleted;
		this.active = active;
		this.tweetmod = tweetmod;
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
		result = prime * result + ((tweetid == null) ? 0 : tweetid.hashCode());
		result = prime * result
				+ ((tweetmod == null) ? 0 : tweetmod.hashCode());
		result = prime * result
				+ ((tweetmsg == null) ? 0 : tweetmsg.hashCode());
		result = prime * result
				+ ((tweetusrid == null) ? 0 : tweetusrid.hashCode());
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
		Dtweet other = (Dtweet) obj;
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
		if (tweetid == null) {
			if (other.tweetid != null)
				return false;
		} else if (!tweetid.equals(other.tweetid))
			return false;
		if (tweetmod == null) {
			if (other.tweetmod != null)
				return false;
		} else if (!tweetmod.equals(other.tweetmod))
			return false;
		if (tweetmsg == null) {
			if (other.tweetmsg != null)
				return false;
		} else if (!tweetmsg.equals(other.tweetmsg))
			return false;
		if (tweetusrid == null) {
			if (other.tweetusrid != null)
				return false;
		} else if (!tweetusrid.equals(other.tweetusrid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Dtweet [tweetid=" + tweetid + ", tweetmsg=" + tweetmsg
				+ ", tweetusrid=" + tweetusrid + ", createdate=" + createdate
				+ ", modidate=" + modidate + ", exfield1=" + exfield1
				+ ", exfield2=" + exfield2 + ", isdeleted=" + isdeleted
				+ ", active=" + active + ", tweetmod=" + tweetmod + "]";
	}
	
}

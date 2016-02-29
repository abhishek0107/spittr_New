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
@Table(name = "DUSR")
public class Dusr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371904985264645153L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long usrid;
	private String usrfn;
	private String usrln;
	private String usreml;
	private String usrpwd;
	private Date usrdob;
	private String usrphn;
	private String usrAddr1;
	private Long usrCity;
	private Long usrState;
	private Long usrCountry;
	private String url;
	private String hobbies;
	private String usrProfession;
	private String aboutme;
	private Date createdate;
	private Date modidate;
	private Long photoid;
	private String exfield1;
	private Long exfield2;
	private String isdeleted;
	private String active;
	private transient String usrImg;
	
	public String getUsrImg() {
		return usrImg;
	}

	public void setUsrImg(String usrImg) {
		this.usrImg = usrImg;
	}

	public Long getUsrCountry() {
		return usrCountry;
	}

	public void setUsrCountry(Long usrCountry) {
		this.usrCountry = usrCountry;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getUsrCity() {
		return usrCity;
	}

	public void setUsrCity(Long usrCity) {
		this.usrCity = usrCity;
	}

	public Long getUsrState() {
		return usrState;
	}

	public void setUsrState(Long usrState) {
		this.usrState = usrState;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getUsrProfession() {
		return usrProfession;
	}

	public void setUsrProfession(String usrProfession) {
		this.usrProfession = usrProfession;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}



	public Long getUsrid() {
		return usrid;
	}

	public void setUsrid(Long usrid) {
		this.usrid = usrid;
	}

	public String getUsrfn() {
		return usrfn;
	}

	public void setUsrfn(String usrfn) {
		this.usrfn = usrfn;
	}

	public String getUsrln() {
		return usrln;
	}

	public void setUsrln(String usrln) {
		this.usrln = usrln;
	}

	public String getUsreml() {
		return usreml;
	}

	public void setUsreml(String usreml) {
		this.usreml = usreml;
	}

	public Date getUsrdob() {
		return usrdob;
	}

	public void setUsrdob(Date usrdob) {
		this.usrdob = usrdob;
	}

	public String getUsrphn() {
		return usrphn;
	}

	public void setUsrphn(String usrphn) {
		this.usrphn = usrphn;
	}

	public String getUsraddr1() {
		return usrAddr1;
	}

	public void setUsraddr1(String usraddr1) {
		this.usrAddr1 = usraddr1;
	}

	public String getUsraddr2() {
		return usrAddr2;
	}

	public void setUsraddr2(String usraddr2) {
		this.usrAddr2 = usraddr2;
	}

	public Long getUsrcity() {
		return usrCity;
	}

	public void setUsrcity(Long usrcity) {
		this.usrCity = usrcity;
	}

	public Long getUsrstate() {
		return usrState;
	}

	public void setUsrstate(Long usrstate) {
		this.usrState = usrstate;
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

	public Long getPhotoid() {
		return photoid;
	}

	public void setPhotoid(Long photoid) {
		this.photoid = photoid;
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
	public String getUsrpwd() {
		return usrpwd;
	}

	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
	public String getUsrAddr1() {
		return usrAddr1;
	}

	public void setUsrAddr1(String usrAddr1) {
		this.usrAddr1 = usrAddr1;
	}

	private String usrAddr2;
	public String getUsrAddr2() {
		return usrAddr2;
	}

	public void setUsrAddr2(String usrAddr2) {
		this.usrAddr2 = usrAddr2;
	}

	public Dusr() {
		super();
	}

	public Dusr(Long usrid, String usrfn, String usrln, String usreml, Date usrdob, String usrphn, String usraddr1,
			String usraddr2, Long usrcity, Long usrstate, Date createdate, Date modidate, Long photoid, String exfield1,
			Long exfield2, String isdeleted, String active) {
		super();
		this.usrid = usrid;
		this.usrfn = usrfn;
		this.usrln = usrln;
		this.usreml = usreml;
		this.usrdob = usrdob;
		this.usrphn = usrphn;
		this.usrAddr1 = usraddr1;
		this.usrAddr2 = usraddr2;
		this.usrCity = usrcity;
		this.usrState = usrstate;
		this.createdate = createdate;
		this.modidate = modidate;
		this.photoid = photoid;
		this.exfield1 = exfield1;
		this.exfield2 = exfield2;
		this.isdeleted = isdeleted;
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutme == null) ? 0 : aboutme.hashCode());
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((exfield1 == null) ? 0 : exfield1.hashCode());
		result = prime * result + ((exfield2 == null) ? 0 : exfield2.hashCode());
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + ((isdeleted == null) ? 0 : isdeleted.hashCode());
		result = prime * result + ((modidate == null) ? 0 : modidate.hashCode());
		result = prime * result + ((photoid == null) ? 0 : photoid.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((usrAddr1 == null) ? 0 : usrAddr1.hashCode());
		result = prime * result + ((usrAddr2 == null) ? 0 : usrAddr2.hashCode());
		result = prime * result + ((usrCity == null) ? 0 : usrCity.hashCode());
		result = prime * result + ((usrCountry == null) ? 0 : usrCountry.hashCode());
		result = prime * result + ((usrProfession == null) ? 0 : usrProfession.hashCode());
		result = prime * result + ((usrState == null) ? 0 : usrState.hashCode());
		result = prime * result + ((usrdob == null) ? 0 : usrdob.hashCode());
		result = prime * result + ((usreml == null) ? 0 : usreml.hashCode());
		result = prime * result + ((usrfn == null) ? 0 : usrfn.hashCode());
		result = prime * result + ((usrid == null) ? 0 : usrid.hashCode());
		result = prime * result + ((usrln == null) ? 0 : usrln.hashCode());
		result = prime * result + ((usrphn == null) ? 0 : usrphn.hashCode());
		result = prime * result + ((usrpwd == null) ? 0 : usrpwd.hashCode());
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
		Dusr other = (Dusr) obj;
		if (aboutme == null) {
			if (other.aboutme != null)
				return false;
		} else if (!aboutme.equals(other.aboutme))
			return false;
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
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
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
		if (photoid == null) {
			if (other.photoid != null)
				return false;
		} else if (!photoid.equals(other.photoid))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (usrAddr1 == null) {
			if (other.usrAddr1 != null)
				return false;
		} else if (!usrAddr1.equals(other.usrAddr1))
			return false;
		if (usrAddr2 == null) {
			if (other.usrAddr2 != null)
				return false;
		} else if (!usrAddr2.equals(other.usrAddr2))
			return false;
		if (usrCity == null) {
			if (other.usrCity != null)
				return false;
		} else if (!usrCity.equals(other.usrCity))
			return false;
		if (usrCountry == null) {
			if (other.usrCountry != null)
				return false;
		} else if (!usrCountry.equals(other.usrCountry))
			return false;
		if (usrProfession == null) {
			if (other.usrProfession != null)
				return false;
		} else if (!usrProfession.equals(other.usrProfession))
			return false;
		if (usrState == null) {
			if (other.usrState != null)
				return false;
		} else if (!usrState.equals(other.usrState))
			return false;
		if (usrdob == null) {
			if (other.usrdob != null)
				return false;
		} else if (!usrdob.equals(other.usrdob))
			return false;
		if (usreml == null) {
			if (other.usreml != null)
				return false;
		} else if (!usreml.equals(other.usreml))
			return false;
		if (usrfn == null) {
			if (other.usrfn != null)
				return false;
		} else if (!usrfn.equals(other.usrfn))
			return false;
		if (usrid == null) {
			if (other.usrid != null)
				return false;
		} else if (!usrid.equals(other.usrid))
			return false;
		if (usrln == null) {
			if (other.usrln != null)
				return false;
		} else if (!usrln.equals(other.usrln))
			return false;
		if (usrphn == null) {
			if (other.usrphn != null)
				return false;
		} else if (!usrphn.equals(other.usrphn))
			return false;
		if (usrpwd == null) {
			if (other.usrpwd != null)
				return false;
		} else if (!usrpwd.equals(other.usrpwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dusr [usrid=" + usrid + ", usrfn=" + usrfn + ", usrln=" + usrln + ", usreml=" + usreml + ", usrpwd="
				+ usrpwd + ", usrdob=" + usrdob + ", usrphn=" + usrphn + ", usrAddr1=" + usrAddr1 + ", usrAddr2="
				+ usrAddr2 + ", usrCity=" + usrCity + ", usrState=" + usrState + ", usrCountry=" + usrCountry + ", url="
				+ url + ", hobbies=" + hobbies + ", usrProfession=" + usrProfession + ", aboutme=" + aboutme
				+ ", createdate=" + createdate + ", modidate=" + modidate + ", photoid=" + photoid + ", exfield1="
				+ exfield1 + ", exfield2=" + exfield2 + ", isdeleted=" + isdeleted + ", active=" + active + "]";
	}

}

/**
 * 
 */
package com.doj.spittr.entities;

/**
 * @author Abhishek
 *
 * 
 */
public class PasswordManagement {
	private long userId;
	private String currentPassword;
	private String newPassword;
	public PasswordManagement(){
		super();
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() { 	
		return "PasswordManagement [userId=" + userId + ", currentPassword=" + currentPassword + ", newPassword="
				+ newPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentPassword == null) ? 0 : currentPassword.hashCode());
		result = prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		PasswordManagement other = (PasswordManagement) obj;
		if (currentPassword == null) {
			if (other.currentPassword != null)
				return false;
		} else if (!currentPassword.equals(other.currentPassword))
			return false;
		if (newPassword == null) {
			if (other.newPassword != null)
				return false;
		} else if (!newPassword.equals(other.newPassword))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	} 
}

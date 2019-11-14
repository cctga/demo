package com.wirk.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sys_t_user")
public class UserRepoModel implements Serializable {

  @Id private String userId;
  private String userName;
  private String password;
  private String email;
  private String roleId;
  private String userStatus;
  private String lastUpdatePwdTime;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public String getLastUpdatePwdTime() {
    return lastUpdatePwdTime;
  }

  public void setLastUpdatePwdTime(String lastUpdatePwdTime) {
    this.lastUpdatePwdTime = lastUpdatePwdTime;
  }

  @Override
  public String toString() {
    return "UserRepoModel{" +
               "userId='" + userId + '\'' +
               ", userName='" + userName + '\'' +
               ", password='" + password + '\'' +
               ", email='" + email + '\'' +
               ", roleId='" + roleId + '\'' +
               ", userStatus='" + userStatus + '\'' +
               ", lastUpdatePwdTime='" + lastUpdatePwdTime + '\'' +
               '}';
  }
}

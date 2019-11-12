package com.wirk.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserRepoModel implements Serializable {

  @Id private String userId;
  private String username;
  private String pwd;
  private String email;
  private String intro;
  private String photo;
  private String createTime;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "UserRepoModel{"
        + "userId='"
        + userId
        + '\''
        + ", username='"
        + username
        + '\''
        + ", pwd='"
        + pwd
        + '\''
        + ", email='"
        + email
        + '\''
        + ", intro='"
        + intro
        + '\''
        + ", photo='"
        + photo
        + '\''
        + ", createTime='"
        + createTime
        + '\''
        + '}';
  }
}

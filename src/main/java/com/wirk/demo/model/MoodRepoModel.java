package com.wirk.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "mood")
public class MoodRepoModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private String id;
  private String content;
  private String userId;
  private String praiseNum;
  private Date publishTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPraiseNum() {
    return praiseNum;
  }

  public void setPraiseNum(String praiseNum) {
    this.praiseNum = praiseNum;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  @Override
  public String toString() {
    return "MoodRepoModel{" +
               "id='" + id + '\'' +
               ", content='" + content + '\'' +
               ", userId='" + userId + '\'' +
               ", praiseNum='" + praiseNum + '\'' +
               ", publishTime='" + publishTime + '\'' +
               '}';
  }
}

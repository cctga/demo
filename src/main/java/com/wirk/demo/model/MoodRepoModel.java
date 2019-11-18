package com.wirk.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mood")
public class MoodRepoModel {

  @Id private String id;
  private String content;
  private String userId;
  private String praiseNum;
  private String publishTime;

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

  public String getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(String publishTime) {
    this.publishTime = publishTime;
  }
}

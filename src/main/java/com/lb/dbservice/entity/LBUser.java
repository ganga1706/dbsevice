package com.lb.dbservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class LBUser implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8568655454405301374L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  @JsonIgnore
  private int userId;

  @Column(name = "USER_NAME")
  private String userName;

  @Column(name = "PH_NUMBER")
  private String phNumber;

  @Column(name = "USER_PASSWORD")
  private String password;

  @Column(name = "EMAIL")
  private String email;

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the phNumber
   */
  public String getPhNumber() {
    return phNumber;
  }

  /**
   * @param phNumber the phNumber to set
   */
  public void setPhNumber(String phNumber) {
    this.phNumber = phNumber;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

}

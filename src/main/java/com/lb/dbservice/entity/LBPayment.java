package com.lb.dbservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LB_PAYMENT")
public class LBPayment implements Serializable {

  private static final long serialVersionUID = -944006380567234140L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  @JsonIgnore
  private int Id;

  @Column(name = "TRANSACTION_ID")
  private String TransactionId;

  @Column(name = "CUST_NAME")
  private String custName;

  @Column(name = "PRINCIPLE_AMOUNT")
  private int principleAmount;

  @Column(name = "START_DATE")
  private Timestamp startDate;

  @Column(name = "INTEREST_RATE")
  private float interestRate;

  @Column(name = "INTEREST_TOTAL_AMOUNT")
  private int InterestTotalAmount;

  @Column(name = "FINAL_AMOUNT")
  private String finalAmount;

  /**
   * @return the id
   */
  public int getId() {
    return Id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    Id = id;
  }

  /**
   * @return the transactionId
   */
  public String getTransactionId() {
    return TransactionId;
  }

  /**
   * @param transactionId the transactionId to set
   */
  public void setTransactionId(String transactionId) {
    TransactionId = transactionId;
  }

  /**
   * @return the custName
   */
  public String getCustName() {
    return custName;
  }

  /**
   * @param custName the custName to set
   */
  public void setCustName(String custName) {
    this.custName = custName;
  }

  /**
   * @return the principleAmount
   */
  public int getPrincipleAmount() {
    return principleAmount;
  }

  /**
   * @param principleAmount the principleAmount to set
   */
  public void setPrincipleAmount(int principleAmount) {
    this.principleAmount = principleAmount;
  }

  /**
   * @return the startDate
   */
  public Timestamp getStartDate() {
    return startDate;
  }

  /**
   * @param startDate the startDate to set
   */
  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  /**
   * @return the interestRate
   */
  public float getInterestRate() {
    return interestRate;
  }

  /**
   * @param interestRate the interestRate to set
   */
  public void setInterestRate(float interestRate) {
    this.interestRate = interestRate;
  }

  /**
   * @return the interestTotalAmount
   */
  public int getInterestTotalAmount() {
    return InterestTotalAmount;
  }

  /**
   * @param interestTotalAmount the interestTotalAmount to set
   */
  public void setInterestTotalAmount(int interestTotalAmount) {
    InterestTotalAmount = interestTotalAmount;
  }

  /**
   * @return the finalAmount
   */
  public String getFinalAmount() {
    return finalAmount;
  }

  /**
   * @param finalAmount the finalAmount to set
   */
  public void setFinalAmount(String finalAmount) {
    this.finalAmount = finalAmount;
  }

}

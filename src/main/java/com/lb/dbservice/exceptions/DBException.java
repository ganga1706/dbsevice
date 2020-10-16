package com.lb.dbservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DBException extends Exception {

  private static final long serialVersionUID = 1612259051092439043L;

  private String status;

  private String statusMessage;

  public DBException(String status) {
    super();
    this.status = status;
  }

  public DBException(String status, String statusMessage) {
    super();
    this.status = status;
    this.statusMessage = statusMessage;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }
}

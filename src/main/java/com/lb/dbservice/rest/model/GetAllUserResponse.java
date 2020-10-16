package com.lb.dbservice.rest.model;

import com.lb.dbservice.entity.LBUser;
import java.util.List;

public class GetAllUserResponse {

  List<LBUser> lbUsers;
  UserResponse userResponse;

  /**
   * @return the lbUsers
   */
  public List<LBUser> getLbUsers() {
    return lbUsers;
  }

  /**
   * @param lbUsers the lbUsers to set
   */
  public void setLbUsers(List<LBUser> lbUsers) {
    this.lbUsers = lbUsers;
  }

  /**
   * @return the userResponse
   */
  public UserResponse getUserResponse() {
    return userResponse;
  }

  /**
   * @param userResponse the userResponse to set
   */
  public void setUserResponse(UserResponse userResponse) {
    this.userResponse = userResponse;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GetAllUserResponse [lbUsers=");
    builder.append(lbUsers);
    builder.append(", userResponse=");
    builder.append(userResponse);
    builder.append("]");
    return builder.toString();
  }

}

package com.lb.dbservice.rest;

import com.lb.dbservice.entity.LBUser;
import com.lb.dbservice.repository.UserDAO;
import com.lb.dbservice.rest.model.GetAllUserResponse;
import com.lb.dbservice.rest.model.GetUsersByNameResponse;
import com.lb.dbservice.rest.model.UserRequest;
import com.lb.dbservice.rest.model.UserResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DbController {

  @Autowired
  UserDAO userDAO;

  /**
   * this method is used to create new user
   * 
   * @param userRequest
   * @return {@link UserResponse}
   */
  @PostMapping(value = "saveUser")
  public UserResponse createUser(@RequestBody UserRequest userRequest) {
    UserResponse userResponse = new UserResponse();
    try {
      LBUser lbUser = new LBUser();
      lbUser.setEmail(userRequest.getEmail());
      lbUser.setPassword(userRequest.getPassword());
      lbUser.setPhNumber(userRequest.getPhNumber());
      lbUser.setUserName(userRequest.getUserName());
      lbUser.setUsersId(UUID.randomUUID().toString());

      userDAO.save(lbUser);
    } catch (Exception e) {
      userResponse.setErrorCode("0001");
      userResponse.setErrorMessage("Save faild");
      return userResponse;
    }
    userResponse.setErrorCode("0000");
    userResponse.setErrorMessage("success");
    return userResponse;
  }

  /**
   * this Method is used is Find 
   * @return
   */
  @GetMapping(value = "getAllUser")
  public GetAllUserResponse getAllUser() {
    GetAllUserResponse getAllUserResponse = new GetAllUserResponse();
    UserResponse userResponse = new UserResponse();
    try {
      List<LBUser> lbusers = userDAO.findAll();
      getAllUserResponse.setLbUsers(lbusers);
    } catch (Exception e) {
      userResponse.setErrorCode("0003");
      userResponse.setErrorMessage("invalid data");
      getAllUserResponse.setUserResponse(userResponse);
      return getAllUserResponse;
    }
    userResponse.setErrorCode("0000");
    userResponse.setErrorMessage("success");
    getAllUserResponse.setUserResponse(userResponse);
    return getAllUserResponse;

  }

  @GetMapping("/users/{name}")
  public GetUsersByNameResponse getUsersByName(@PathVariable(value = "name") String name) {
    GetUsersByNameResponse response = new GetUsersByNameResponse();
    UserResponse userResponse = new UserResponse();
    List<LBUser> userList = userDAO.findByUserName(name);
    response.setLbUsers(userList);
    userResponse.setErrorCode("0000");
    userResponse.setErrorMessage("success");
    response.setUserResponse(userResponse);
    return response;
  }

}

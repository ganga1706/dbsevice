package com.lb.dbservice.rest;

import com.lb.dbservice.entity.LBUser;
import com.lb.dbservice.exceptions.DBException;
import com.lb.dbservice.repository.UserDAO;
import com.lb.dbservice.rest.model.GetAllUserResponse;
import com.lb.dbservice.rest.model.UserRequest;
import com.lb.dbservice.rest.model.UserResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  @PostMapping(value = "saveUser")
  public UserResponse createUser(@RequestBody UserRequest userRequest) {
    UserResponse userResponse = new UserResponse();
    try {
      LBUser lbUser = new LBUser();
      lbUser.setEmail(userRequest.getEmail());
      lbUser.setPassword(userRequest.getPassword());
      lbUser.setPhNumber(userRequest.getPhNumber());
      lbUser.setUserName(userRequest.getUserName());

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

  @GetMapping(value = "getAllUser")
  public GetAllUserResponse getAllUser() {
    GetAllUserResponse getAllUserResponse = new GetAllUserResponse();
    UserResponse userResponse = new UserResponse();
    try {
      List<LBUser> lbusers = userDAO.findAll();
      getAllUserResponse.setLbUsers(lbusers);
    } catch (Exception e) {
      userResponse.setErrorCode("0002");
      userResponse.setErrorMessage("Save faild");
      getAllUserResponse.setUserResponse(userResponse);
      return getAllUserResponse;
    }
    userResponse.setErrorCode("0000");
    userResponse.setErrorMessage("success");
    getAllUserResponse.setUserResponse(userResponse);
    return getAllUserResponse;

  }

  @GetMapping("/user/{id}")
  public ResponseEntity<LBUser> getUserById(@PathVariable(value = "id") Integer userId)
    throws DBException {
    LBUser lbUser = userDAO.findById(userId).orElseThrow(() -> new DBException("User not found for this id :: " + userId));
    return ResponseEntity.ok().body(lbUser);
  }

  @PostMapping("/employees/{id}")
  public ResponseEntity<LBUser> updateuser(@PathVariable(value = "id") Integer userId, @RequestBody LBUser lbUser) throws DBException {
    LBUser user = userDAO.findById(userId).orElseThrow(() -> new DBException("User not found for this id :: " + userId));

    // user.setEmailId(lbUser.getEmailId());
    // user.setLastName(lbUser.getLastName());
    final LBUser updatedUser = userDAO.save(user);
    return ResponseEntity.ok(updatedUser);
  }

}

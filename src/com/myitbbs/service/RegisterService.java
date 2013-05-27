package com.myitbbs.service;

import com.myitbbs.model.User;

public interface RegisterService {
public void save(User user);
public boolean checkName(String userName);
}

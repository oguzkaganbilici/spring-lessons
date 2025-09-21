package com.oguzkaganbilici.service;

import com.oguzkaganbilici.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserService {
    private List<User> userList;
}

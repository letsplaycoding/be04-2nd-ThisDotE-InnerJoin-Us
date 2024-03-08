package org.thisdote.innerjoinus.user.query.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thisdote.innerjoinus.user.dto.UserDTO;
import org.thisdote.innerjoinus.user.query.repository.UserMapper;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserMapper userMapper;

    @Autowired
    public UserQueryServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserDTO selectUserByUserCode(int userCode) {
        return userMapper.selectUserByUserCode(userCode);
    }
}

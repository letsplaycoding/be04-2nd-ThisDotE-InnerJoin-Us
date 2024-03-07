package org.thisdote.innerjoinus.user.query.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thisdote.innerjoinus.user.dto.UserDTO;
import org.thisdote.innerjoinus.user.query.repository.UserMapper;

import java.util.List;

@Service
public class UserService {
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public UserService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<UserDTO> selectAllUser() {
        return sqlSession.getMapper(UserMapper.class).selectAllUser();
    }

    public List<UserDTO> selectUsersByResignStatus(int resignStatus) {
        return sqlSession.getMapper(UserMapper.class).selectUsersByResignStatus(resignStatus);
    }

    public List<UserDTO> selectUserId(String userId) {
        return sqlSession.getMapper(UserMapper.class).selectUserId(userId);
    }

    public UserDTO selectUserCode(int userCode) {
        return sqlSession.getMapper(UserMapper.class).selectUserCode(userCode);
    }

    public List<UserDTO> selectUserByUserCode(int userCode) {
        return sqlSession.getMapper(UserMapper.class).selectUserByUserCode(userCode);
    }
}

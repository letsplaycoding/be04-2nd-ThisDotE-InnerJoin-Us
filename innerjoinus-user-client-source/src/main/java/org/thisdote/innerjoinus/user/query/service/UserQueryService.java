package org.thisdote.innerjoinus.user.query.service;

import org.thisdote.innerjoinus.user.dto.UserDTO;

import java.util.List;

public interface UserQueryService {
    List<UserDTO> selectAllUser();
    UserDTO selectUserByUserCode(int userCode);
}

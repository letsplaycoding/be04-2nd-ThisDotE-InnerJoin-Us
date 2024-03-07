package org.thisdote.user.query;

import org.apache.ibatis.annotations.Mapper;
import org.thisdote.communityfordevelopers.user.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDTO> selectAllUser();

    List<UserDTO> selectUserByUserCode(int userCode);

    List<UserDTO> selectUserId(String userId);

    UserDTO selectUserCode(int userCode);

    List<UserDTO> updateUserEmail(String userEmail);

    List<UserDTO> selectUsersByResignStatus(int resignStatus);
}

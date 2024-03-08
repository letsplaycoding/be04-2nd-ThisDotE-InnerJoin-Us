package org.thisdote.innerjoinus.user.command.service;

import org.thisdote.innerjoinus.user.dto.UserDTO;

public interface UserCommandService {
    UserDTO registUser(UserDTO newUser);
    void modifyUser(UserDTO modifyUser);
    void deleteUser(int userCode);
}

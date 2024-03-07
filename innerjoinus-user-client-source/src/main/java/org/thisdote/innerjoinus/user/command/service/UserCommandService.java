package org.thisdote.innerjoinus.user.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.user.command.entity.UserEntity;
import org.thisdote.innerjoinus.user.command.repository.UserRepository;
import org.thisdote.innerjoinus.user.dto.UserDTO;

import java.util.Date;

@Service
public class UserCommandService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public UserCommandService(ModelMapper modelMapper, UserRepository userRepository) {
        this.mapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public void registUser(UserDTO newUser) {
        userRepository.save(mapper.map(newUser, UserEntity.class));
    }

    @Transactional
    public void modifyUser(UserDTO modifyUser) {
        UserEntity foundUser = userRepository.findById(modifyUser.getUserCode()).orElseThrow(IllegalAccessError::new);

//        UserDTO user = mapper.map(foundUser, UserDTO.class);

        foundUser.setUserId(modifyUser.getUserId());
        foundUser.setUserPassword(modifyUser.getUserPassword());
        foundUser.setUserBirthday(modifyUser.getUserBirthday());
        foundUser.setUserPhone(modifyUser.getUserPhone());
        foundUser.setUserEmail(modifyUser.getUserEmail());
        foundUser.setUserStudyGroupStatus(modifyUser.getUserStudyGroupStatus());
        foundUser.setUserInfoUpdateDate(new Date());
        foundUser.setUserGrade(modifyUser.getUserGrade());
    }

    @Transactional
    public void deleteUser(int userCode) {
        UserEntity foundUser = userRepository.findById(userCode).orElseThrow(IllegalArgumentException::new);

        foundUser.setUserResignStatus(0);
    }
}

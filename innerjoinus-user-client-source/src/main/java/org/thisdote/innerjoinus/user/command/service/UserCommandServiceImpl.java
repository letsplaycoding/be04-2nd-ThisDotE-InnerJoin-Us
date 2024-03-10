package org.thisdote.innerjoinus.user.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.user.client.ReplyClient;
import org.thisdote.innerjoinus.user.command.entity.UserEntity;
import org.thisdote.innerjoinus.user.command.repository.UserRepository;
import org.thisdote.innerjoinus.user.dto.UserDTO;
import org.thisdote.innerjoinus.user.vo.ResponseReply;

import java.util.Date;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final ReplyClient replyClient;

    @Autowired
    public UserCommandServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ReplyClient replyClient) {
        this.mapper = modelMapper;
        this.userRepository = userRepository;
        this.replyClient = replyClient;
    }

    @Transactional
    @Override
    public UserDTO registUser(UserDTO newUser) {
        Date createdDate = new Date();
        newUser.setUserRegistDate(createdDate);
        newUser.setUserInfoUpdateDate(createdDate);

        UserEntity returnedUser = userRepository.save(mapper.map(newUser, UserEntity.class));

        return mapper.map(returnedUser, UserDTO.class);
    }

    @Transactional
    @Override
    public void modifyUser(UserDTO modifyUser) {
        UserEntity foundUser = userRepository.findById(modifyUser.getUserCode()).orElseThrow(IllegalAccessError::new);
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
    @Override
    public void deleteUser(int userCode) {
        UserEntity foundUser = userRepository.findById(userCode).orElseThrow(IllegalArgumentException::new);

        foundUser.setUserResignStatus(1);
    }

    @Override
    public UserDTO selectUserReply(int userCode) {
        UserEntity user = userRepository.findById(userCode).get();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = mapper.map(user,UserDTO.class);

        ResponseReply replyList = replyClient.getAllReply(userDTO.getReplyId());
        userDTO.setReplyList(replyList);
        return userDTO;
    }
}

package org.thisdote.innerjoinus.user.query.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.innerjoinus.user.dto.UserDTO;
import org.thisdote.innerjoinus.user.query.service.UserQueryService;
import org.thisdote.innerjoinus.user.vo.ResponseUser;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    private final ModelMapper mapper;
    private final UserQueryService userQueryService;

    @Autowired
    public UserQueryController(ModelMapper mapper, UserQueryService userQueryService) {
        this.mapper = mapper;
        this.userQueryService = userQueryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUser>> getAllUser() {
        List<UserDTO> userList = userQueryService.selectAllUser();
        List<ResponseUser> responseUserList = new ArrayList<>();

        if (userList != null) {
            responseUserList = userList.stream().map(userDTO -> mapper.map(userDTO, ResponseUser.class)).toList();
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseUserList);
    }

    @GetMapping("/{userCode}")
    public ResponseEntity<ResponseUser> getUserByUserCode(@PathVariable("userCode") Integer userCode) {
        UserDTO selectedUser = userQueryService.selectUserByUserCode(userCode);
        ResponseUser responseUser = new ResponseUser();

        if (selectedUser != null) {
            responseUser = mapper.map(selectedUser, ResponseUser.class);
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }
}

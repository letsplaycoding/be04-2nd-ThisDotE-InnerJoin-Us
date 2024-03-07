package org.thisdote.innerjoinus.user.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.user.command.service.UserCommandService;
import org.thisdote.innerjoinus.user.dto.UserDTO;
import org.thisdote.innerjoinus.user.query.service.UserQueryService;
import org.thisdote.innerjoinus.user.vo.RequestUser;
import org.thisdote.innerjoinus.user.vo.ResponseUser;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserCommandController {

    private final ModelMapper mapper;
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    @Autowired
    public UserCommandController(
            ModelMapper mapper,
            UserQueryService userQueryService,
            UserCommandService userCommandService
    ) {
        this.mapper = mapper;
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @PostMapping("/regist")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RequestUser user) {
        UserDTO userDTO = mapper.map(user, UserDTO.class);

        userCommandService.registUser(userDTO);

        ResponseUser responseUser = mapper.map(userDTO, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @PostMapping("/modify")
    public ResponseEntity<Map<String, Object>> modifyUser(@RequestBody RequestUser user) {
        UserDTO userDTO = mapper.map(user, UserDTO.class);

        userCommandService.modifyUser(userDTO);

//        ResponseUser responseUser = mapper.map(userDTO, ResponseUser.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("resultCode", 200);
        responseMap.put("message", "수정 성공!");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @PostMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody RequestUser user) {
        UserDTO userDTO = mapper.map(user, UserDTO.class);

        userCommandService.deleteUser(userDTO.getUserCode());

//        ResponseUser responseUser = mapper.map(userDTO, ResponseUser.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("resultCode", 200);
        responseMap.put("message", "삭제 성공!");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}

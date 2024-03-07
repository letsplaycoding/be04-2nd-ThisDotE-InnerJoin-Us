package org.thisdote.innerjoinus.articlereply.reply.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.innerjoinus.articlereply.reply.command.service.ReplyCommandService;
import org.thisdote.innerjoinus.articlereply.reply.command.vo.ReplyCommandVo;

@RestController
@RequestMapping("/")
public class ReplyCommandController {

    private Environment env;
//    private ReplyCommandVo replyCommandVo;
    private ModelMapper modelMapper;
    private ReplyCommandService replyCommandService;

    @Autowired
    public ReplyCommandController(Environment env,
                                  ModelMapper modelMapper,
                                  ReplyCommandService replyCommandService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.replyCommandService = replyCommandService;
    }

    /* 설명. health_check */
    @GetMapping("/health_check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port")
                + ", swcamp.message: " + env.getProperty("swcamp.message");
    }
}

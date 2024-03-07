package org.thisdote.innerjoinus.articlereply.reply.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ReplyController {

    private Environment env;
    private ModelMapper modelMapper;

    @Autowired

    public ReplyController(Environment env, ModelMapper modelMapper) {
        this.env = env;
        this.modelMapper = modelMapper;
    }
}

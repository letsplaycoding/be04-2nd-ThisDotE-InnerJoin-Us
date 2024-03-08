package org.thisdote.innerjoinus.config;

import org.apache.ibatis.annotations.Mapper;
import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@MapperScan(basePackages = "org.thisdote.innerjoinus.studygroup", annotationClass = Mapper.class)
public class MybatisConfiguration {

}
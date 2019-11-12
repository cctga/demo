package com.wirk.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
  @ComponentScan("com.wirk.demo.server.**.*"),
  @ComponentScan("com.wirk.demo" + ".controller.*")
})
public class MainConfiguration {}

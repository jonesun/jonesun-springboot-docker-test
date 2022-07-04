package io.github.jonesun.dockertest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.info.JavaInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author jone.sun
 * @date 2022-07-04 13:33
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/projectInfo")
    public StringBuilder projectInfo() {
        StringBuilder projectInfo = new StringBuilder();
        JavaInfo javaInfo = new JavaInfo();
        projectInfo.append("\n=================project=================\n");
        projectInfo.append(String.format("\nspringboot version:%s\n", SpringBootVersion.getVersion()));
        projectInfo.append(String.format("\njavaInfo version:%s\n", javaInfo.getVersion()));
        projectInfo.append(String.format("\njavaInfo jvm:%s_%s\n", javaInfo.getJvm().getName(), javaInfo.getJvm().getVersion()));
        projectInfo.append(String.format("\njavaInfo runtime:%s_%s\n", javaInfo.getRuntime().getName(), javaInfo.getRuntime().getVersion()));
        projectInfo.append(String.format("\njavaInfo vendor:%s_%s\n", javaInfo.getVendor().getName(), javaInfo.getVendor().getVersion()));
        projectInfo.append("\n=================project=================\n");
        logger.info(projectInfo.toString());
        return projectInfo;
    }

}

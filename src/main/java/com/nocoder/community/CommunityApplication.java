package com.nocoder.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.nocoder.community.dao")    // 不加这个会报找不到dao的错
public class CommunityApplication {

//    @PostConstruct
//    public void init() {
//        // 解决elasticsearch和redis启动冲突问题（是底层的netty启动有冲突）
//        // 详情见 Netty4Utils.setAvailableProcessors()
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}

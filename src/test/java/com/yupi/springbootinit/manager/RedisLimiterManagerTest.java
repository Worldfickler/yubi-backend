package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fickler
 * @date 2023/11/23 20:07
 */

@SpringBootTest
class RedisLimiterManagerTest {

    @Resource
    private RedisLimiterManager redisLimiterManager;

    @Test
    void doRateLimit() throws InterruptedException {
        // ģ��һ�²���
        String userId = "1";
        // ˲��ִ��2��,ÿ�ɹ�һ��,�ʹ�ӡ'�ɹ�'
        for (int i = 0; i < 2; i++) {
            redisLimiterManager.doRateLimit(userId);
            System.out.println("�ɹ�");
        }
        // ˯1��
        Thread.sleep(1000);
        // ˲��ִ��5��,ÿ�ɹ�һ��,�ʹ�ӡ'�ɹ�'
        for (int i = 0; i < 5; i++) {
            redisLimiterManager.doRateLimit(userId);
            System.out.println("�ɹ�");
        }
    }
}
package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fickler
 * @date 2023/11/22 11:13
 */

@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {
        String answer = aiManager.doChat(1727155929805660162L, "��������\n" +
                "������վ�û����������\n" +
                "ԭʼ���ݣ�\n" +
                "����,�û���\n" +
                "1��,10\n" +
                "2��,20\n" +
                "3��,30");
        System.out.println(answer);
    }
}
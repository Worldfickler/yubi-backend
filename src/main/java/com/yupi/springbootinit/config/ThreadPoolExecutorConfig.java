package com.yupi.springbootinit.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池配置类
 * @author Fickler
 * @date 2023/11/24 20:55
 */

@Configuration
public class ThreadPoolExecutorConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        // 创建一个线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            // 初始化线程数为 1
            private int count = 1;

            /**
             * 没当线程池需要创建新线程时，就会调用 newThread 方法
             * @NotNull Runnable r 表示方法参数 r 应该永远不为 null
             * 如果这个方法被调用的时候传递了一个 null 参数，就会报错
             * @param r a runnable to be executed by new thread instance
             * @return
             */
            @Override
            public Thread newThread(@NotNull Runnable r) {
                // 创建一个新的线程
                Thread thread = new Thread(r);
                // 给新线程设置一个名称，名称中包含线程数的当前值
                thread.setName("线程" + count);
                // 线程数递增
                count ++ ;
                // 返回新创建的线程
                return thread;
            }
        };
        // 创建一个新的线程池，线程池核心大小为 2，最大线程数为 4
        // 非核心线程空闲时间为 100 秒，任务队列为阻塞队列，长度为 4，使用自定义的线程工厂创建线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), threadFactory);
        // 返回创建的线程池
        return threadPoolExecutor;
    }

}

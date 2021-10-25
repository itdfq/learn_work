package com.itdfq.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: QianMo
 * @Date: 2021/10/25 14:26
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "zk")
@Data
public class ZkProperties {
    private String url;
    private String projectName;
    private Integer baseSleepTimeMs;
    /**
     * 失败重试次数
     */
    private Integer maxRetries;
}

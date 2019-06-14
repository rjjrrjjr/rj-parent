package com.example.demo.redis;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Created by 10064028 on 2018/11/20.
 */
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private Integer database;
    private String password;
    private Integer timeout;
    private RedisProperties.Sentinel sentinel;

    public static class Sentinel {
        private String master;
        private List<String> nodes;

        public Sentinel() {
        }

        public String getMaster() {
            return this.master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public List<String> getNodes() {
            return this.nodes;
        }

        public void setNodes(List<String> nodes) {
            this.nodes = nodes;
        }
    }
}

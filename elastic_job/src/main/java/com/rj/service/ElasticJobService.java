package com.rj.service;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by 10064028 on 2018/1/31.
 */
public class ElasticJobService implements SimpleJob{

    @Override
    public void execute(ShardingContext shardingContext) {

        System.out.println(String.format("-------------------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId() + "--" + Thread.currentThread().getName(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem()));
    }
}

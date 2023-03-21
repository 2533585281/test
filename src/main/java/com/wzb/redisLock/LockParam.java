package com.wzb.redisLock;

import lombok.Data;

/**
 * @Author Administrator
 * @Date 2022/10/14 0014 9:51
 * 加锁设置的参数
 */

@Data
public class LockParam {
    //锁的key
    private String lockKey;
    //尝试获得锁的时间（单位：毫秒），默认值：3000毫秒
    private Long tryLockTime;
    //尝试获得锁后，持有锁的时间（单位：毫秒），默认值：5000毫秒
    private Long holdLockTime;

    public LockParam(String lockKey){
        this(lockKey,1000*3L,1000*5L);
    };
    public LockParam(String lockKey,Long tryLockTime){
        this(lockKey,tryLockTime,1000*5L);
    };
    public LockParam(String lockKey,Long tryLockTime,Long holdLockTime){
        this.lockKey = lockKey;
        this.tryLockTime = tryLockTime;
        this.holdLockTime = holdLockTime;
    };
}
package com.liwenchao.redisson.service;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author liwenchao
 * @since 2020/8/1
 */
public interface DistributedLocker {

    /**
     * 加锁
     *
     * @param lockKey 锁key
     * @return 可重入锁
     */
    RLock lock(String lockKey);

    /**
     * 加锁
     *
     * @param lockKey 锁key
     * @param timeout 超时时间（单位：秒）
     * @return 可重入锁
     */
    RLock lock(String lockKey, int timeout);

    /**
     * 加锁
     *
     * @param lockKey 锁key
     * @param unit    时间单位
     * @param timeout 超时时间
     * @return 可重入锁
     */
    RLock lock(String lockKey, TimeUnit unit, int timeout);

    /**
     * 尝试获取锁
     *
     * @param lockKey   锁key
     * @param unit      时间单位
     * @param waitTime  最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return 获取锁是否成功，true为成功
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    /**
     * 释放锁
     *
     * @param lockKey 锁key
     */
    void unlock(String lockKey);

    /**
     * 释放锁
     *
     * @param lock 可重入锁
     */
    void unlock(RLock lock);
}

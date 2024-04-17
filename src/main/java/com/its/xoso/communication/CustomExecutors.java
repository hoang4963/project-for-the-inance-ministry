package com.its.xoso.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutors {
    public CustomExecutors() {
    }

    public static ExecutorService newCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    public static ExecutorService newCachedThreadPool(int maxPoolSize) {
        return new ThreadPoolExecutor(0, maxPoolSize, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newCachedThreadPool(int maxPoolSize, long keepAliveTimeSecond) {
        return new ThreadPoolExecutor(0, maxPoolSize, keepAliveTimeSecond, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newCachedThreadPool(int maxPoolSize, long keepAliveTime, TimeUnit timeUnit) {
        return new ThreadPoolExecutor(0, maxPoolSize, keepAliveTime, timeUnit, new LinkedBlockingQueue());
    }

    public static ExecutorService newCachedThreadPool(int maxPoolSize, RejectedExecutionHandler rejectExeHandler) {
        if (rejectExeHandler == null) {
            rejectExeHandler = new ThreadPoolExecutor.AbortPolicy();
        }

        return new ThreadPoolExecutor(0, maxPoolSize, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), (RejectedExecutionHandler)rejectExeHandler);
    }
}
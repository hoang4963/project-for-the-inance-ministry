package com.its.xoso.security;

public class FastThreadLocal<T> {
    //
    private final ThreadLocal<T> local = new ThreadLocal<>();

    public void remove() {
        local.remove();
    }

    /**
     *
     */
    public T get() {
        return this.local.get();
    }

    /**
     *
     */
    public void set(T value) {
        this.local.set(value);
    }
}


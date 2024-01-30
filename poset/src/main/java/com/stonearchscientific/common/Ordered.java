package com.stonearchscientific.common;

public interface Ordered<T> {
    public Ordered<T> join(T that);
    public Ordered<T> meet(T that);
    public boolean relation(T that);
}
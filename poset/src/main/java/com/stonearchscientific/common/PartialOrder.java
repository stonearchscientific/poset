package com.stonearchscientific.common;

public abstract class PartialOrder<T extends PartialOrder> implements Ordered<T> {

    public Ordered<T> join(T that) {
        return that.meet(this);
    }

    public boolean relation(T that) {
        return this.meet(that).equals(this);
    }
}
package com.stonearchscientific.common;

import com.google.common.collect.Range;

public class Interval<C extends Comparable> extends PartialOrder<Interval<C>> {

    private Range<C> range;
    public final static Interval MAGIC = new Interval<>(Range.all());

    private Interval() {
        range = null;
    }

    public Interval(final Range<C> range) {
        this();
        this.range = range;
    }

    public boolean isNull() {
        return range == null;
    }

    public Interval<C> meet(final Interval<C> that) {
        if (!this.isNull() && !that.isNull()) {
            if(this.range.isConnected(that.range)) {
                return new Interval(this.range.intersection(that.range));
            }
        }
        return new Interval(null);
    }

    @Override
    public boolean equals(final Object that) {
        if (!(that instanceof Interval)) {
            return false;
        }
        if (this == that) {
            return true;
        }
        Interval interval = (Interval) that;
        if (this.isNull() && interval.isNull()) {
            return true;
        } else if (this.isNull() || interval.isNull()) {
            return false;
        }
        return interval.range.equals(this.range);
    }
}

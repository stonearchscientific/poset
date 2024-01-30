package com.stonearchscientific.common;

import com.google.common.collect.Range;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public final class IntervalTest {
    Interval<Integer> a, b, c, x, y, z;

    @Before
    public void testSetup() {
        a = new Interval(Range.closed(2, 4));
        b = new Interval(Range.closed(8, 10));
        c = new Interval(Range.closed(2, 10));
        x = new Interval(Range.closed(5, 7));
        y = new Interval(Range.open(4, 8));
        z = new Interval(null);
    }

    @Test
    public void testMeet() {
        assertEquals(a.meet(c), a);
        assertEquals(c.meet(a), a);
        assertEquals(a.meet(a), a);
        assertEquals(Interval.MAGIC.meet(a), a);
        assertEquals(Interval.MAGIC.meet(Interval.MAGIC), Interval.MAGIC);
        assertEquals(Interval.MAGIC.meet(z), z);
        assertEquals(a.meet(Interval.MAGIC), a);
        assertEquals(a.meet(z), z);
        assertEquals(z.meet(a), z);
        assertEquals(z.meet(Interval.MAGIC), z);
        assertEquals(z.meet(z), z);
    }
}
package com.its.xoso.utils;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class XSDateUtils {

    private static final long DAY_IN_MILLIS = 86400000L;

    public static interface DateTimeProvider {
        long now();
    }

    public static final DateTimeProvider getProvider() {
        return PROVIDER.get();
    }

    public static final void setProvider(DateTimeProvider provider) {
        PROVIDER.set(provider);
    }

    private static final AtomicReference<DateTimeProvider> PROVIDER = new AtomicReference<DateTimeProvider>();

    static {
        PROVIDER.set(new DateTimeProvider() {
            @Override
            public long now() {
                return System.currentTimeMillis();
            }
        });
    }

    public static long now() {
        return getProvider().now();
    }

    public static Date currentDate() {
        return date(now());
    }

    public static Date currentTime() {
        return new Date(now());
    }

    public static long currentTimeMillis() {
        return getProvider().now();
    }

    public static int getTimeZoneOffset(long millis) {
        return TimeZone.getDefault().getOffset(millis);
    }


    public static final Date date(final long millis) {
        final int offset = getTimeZoneOffset(millis);
        long t = millis - ((t = (millis + offset) % DAY_IN_MILLIS) < 0 ? DAY_IN_MILLIS + t : t);
        t = t + (offset - getTimeZoneOffset(t));
        return new Date(t);
    }

    public static final Time time(final long millis) {
        final int offset1 = getTimeZoneOffset(0L), offset2 = getTimeZoneOffset(-offset1);
        long t = (t = (millis + getTimeZoneOffset(millis)) % DAY_IN_MILLIS) < 0 ? DAY_IN_MILLIS + t : t;
        t = t - (t < (offset2 - offset1) ? offset1 : offset2);
        return new Time(t);
    }


}
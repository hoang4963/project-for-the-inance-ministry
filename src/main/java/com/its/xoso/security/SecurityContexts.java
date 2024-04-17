package com.its.xoso.security;

public class SecurityContexts {

    private static final FastThreadLocal<Context> CONTEXT;

    public static final Context get() {
        return CONTEXT.get();
    }

    public static final void set(Context c) {
        CONTEXT.set(c);
    }

    static {
        CONTEXT = new FastThreadLocal<>();
    }

    public static final class Context {
        //
        private int companyId;

        private int userId;
        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

    public static int getCompanyId() {
        return SecurityContexts.get().getCompanyId();
    }

    public static int getUserId() {
        try {
            return SecurityContexts.get().getUserId();
        } catch (Exception e) {
            return -1;
        }
    }
}


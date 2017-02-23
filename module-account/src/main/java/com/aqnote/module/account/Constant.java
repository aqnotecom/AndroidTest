package com.aqnote.module.account;

public class Constant {

    /**
     * Account type id
     */
    public static final String ACCOUNT_TYPE = "com.aqnote.module.account";

    /**
     * Account name
     */
    public static final String ACCOUNT_NAME = "aqnote.com";

    /**
     * Auth token types
     */
    public static final String AUTHTOKEN_TYPE_READ_ONLY = "Read only";
    public static final String AUTHTOKEN_TYPE_READ_ONLY_LABEL = "Read only access to an AQNote account";

    public static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to an AQNote account";

    public static final IAuthenticate AUTHENTICATE = new DefaultAuthenticate();

}

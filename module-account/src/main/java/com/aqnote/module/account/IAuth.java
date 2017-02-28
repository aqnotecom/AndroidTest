package com.aqnote.module.account;

/**
 * User: udinic
 * Date: 3/27/13
 * Time: 2:35 AM
 */
public interface IAuth {
    public String signUp(final String name, final String email, final String pass, String authType) throws Exception;
    public String signIn(final String user, final String pass, String authType) throws Exception;
}

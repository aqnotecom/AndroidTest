package com.aqnote.module.container;

/**
 * Created by aqnote on 5/26/17.
 */

public interface Callbackable<T> {

    public void run(T data);
}

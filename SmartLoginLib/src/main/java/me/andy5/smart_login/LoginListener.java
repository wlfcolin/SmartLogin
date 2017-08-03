package me.andy5.smart_login;

/**
 * listener for login result
 *
 * @author andy(Andy)
 * @datetime 2017-08-01 16:47 GMT+8
 * @email 411086563@qq.com
 */
public interface LoginListener {

    /**
     * login success
     */
    void onSuccess();

    /**
     * not login success
     */
    void onCancel();
}

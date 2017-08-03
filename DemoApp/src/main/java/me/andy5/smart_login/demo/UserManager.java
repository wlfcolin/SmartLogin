package me.andy5.smart_login.demo;

/**
 * @author andy(Andy)
 * @datetime 2017-06-27 15:10 GMT+8
 * @email 411086563@qq.com
 */
public class UserManager {

    private static UserManager sInstance;
    private boolean mIsLogin = false;

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (sInstance == null) {
            synchronized (UserManager.class) {
                if (sInstance == null) {
                    sInstance = new UserManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isLogin() {
        return mIsLogin;
    }

    public void setLogin(boolean login) {
        mIsLogin = login;
    }
}

package me.andy5.smart_login;

import android.app.Activity;
import android.content.Context;

/**
 * @author andy(Andy)
 * @datetime 2017-08-01 16:38 GMT+8
 * @email 411086563@qq.com
 */
public class SmartLogin {

    /**
     * request to goto a login activity for login
     *
     * @param context
     * @param loginActivity the user login activity class
     * @param loginListener login listener
     */
    public static void requestLogin(Context context, Class<? extends Activity> loginActivity, LoginListener
            loginListener) {
        SmartLoginManager.getInstance(context).request(loginActivity, loginListener);
    }
}

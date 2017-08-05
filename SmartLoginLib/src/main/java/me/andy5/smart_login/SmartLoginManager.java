package me.andy5.smart_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.HashSet;
import java.util.Set;

/**
 * login manager
 *
 * @author andy(Andy)
 * @datetime 2017-08-01 16:40 GMT+8
 * @email 411086563@qq.com
 */
public class SmartLoginManager {

    private static final int REQUEST_CODE_LOGIN = 100;
    private static SmartLoginManager sInstance;

    // all registered listeners
    private Set<LoginListener> mLoginListeners = new HashSet<>();
    // a flag that the SmartLoginActivity started or not
    private boolean mStartedActivity = false;
    // the login activity
    private Class<? extends Activity> mLoginActivity;

    private Object mLock = new Object();

    // private constructor
    private SmartLoginManager() {
    }

    /**
     * single instance
     *
     * @return
     */
    static SmartLoginManager getInstance() {
        if (sInstance == null) {
            synchronized (SmartLoginManager.class) {
                if (sInstance == null) {
                    sInstance = new SmartLoginManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * request SmartLoginActivity
     *
     * @param context
     * @param loginActivity
     * @param loginListener
     */
    void request(Context context, Class<? extends Activity> loginActivity, LoginListener loginListener) {
        mLoginListeners.add(loginListener);
        synchronized (mLock) {
            // has been started, just add loginListener
            if (mStartedActivity) {
                return;
            }
            mLoginActivity = loginActivity;
            // started
            mStartedActivity = true;
        }
        Intent intent = new Intent(context, SmartLoginActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * request user LoginActivity
     *
     * @param activity
     */
    void login(Activity activity) {
        if (mLoginActivity == null) {
            return;
        }
        Intent intent = new Intent(activity, mLoginActivity);
        activity.startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }

    /**
     * onActivityResult
     *
     * @param activity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                if (!mLoginListeners.isEmpty()) {
                    for (LoginListener listener : mLoginListeners) {
                        if (listener == null) {
                            continue;
                        }
                        listener.onSuccess();
                    }
                    mLoginListeners.clear();
                }
            } else {
                if (!mLoginListeners.isEmpty()) {
                    for (LoginListener listener : mLoginListeners) {
                        if (listener == null) {
                            continue;
                        }
                        listener.onCancel();
                    }
                    mLoginListeners.clear();
                }
            }
            if (activity != null) {
                activity.finish();
            }
            synchronized (mLock) {
                // reset the flag
                mStartedActivity = false;
            }
        }
    }

}

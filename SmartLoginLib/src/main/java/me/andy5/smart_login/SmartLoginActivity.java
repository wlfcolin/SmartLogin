package me.andy5.smart_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * inner login activity
 *
 * @author andy(Andy)
 * @datetime 2017-08-01 16:35 GMT+8
 * @email 411086563@qq.com
 */
public class SmartLoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmartLoginManager.getInstance(this).login(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SmartLoginManager.getInstance(this).onActivityResult(this, requestCode, resultCode, data);
    }
}

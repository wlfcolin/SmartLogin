package me.andy5.smart_login.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author andy(Andy)
 * @datetime 2017-08-01 16:38 GMT+8
 * @email 411086563@qq.com
 */
public class LoginActivity extends Activity {

    private Button mEmailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        Toast.makeText(getApplicationContext(), "attempt login", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean success = false;
                try {
                    Thread.sleep(3000);
                    success = true;
                } catch (Exception e) {
                    // failure
                } finally {
                    final boolean finalSuccess = success;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (finalSuccess) {
                                UserManager.getInstance().setLogin(true);
                                // if set RESULT_OK, that means login success, the LoginListener.onSuccess will be
                                // called.
                                setResult(RESULT_OK);
                                // Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // Toast.makeText(getApplicationContext(), "login failure", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        }).start();
    }
}


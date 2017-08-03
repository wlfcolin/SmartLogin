package me.andy5.smart_login.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import me.andy5.smart_login.LoginListener;
import me.andy5.smart_login.SmartLogin;

/**
 * @author andy(Andy)
 * @datetime 2017-08-01 16:38 GMT+8
 * @email 411086563@qq.com
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnAConditionLogin;
    private Button mBtnManyThreadsLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAConditionLogin = (Button) findViewById(R.id.btn_a_condition_login);
        mBtnManyThreadsLogin = (Button) findViewById(R.id.btn_many_threads_login);

        mBtnAConditionLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                aConditionLogin();
            }
        });
        mBtnManyThreadsLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                manyThreadsLogin();
            }
        });
    }

    private void aConditionLogin() {
        // user never login, now it is to goto visit user orders, need login first
        SmartLogin.requestLogin(this, LoginActivity.class, new LoginListener() {
            @Override
            public void onSuccess() {
                if (UserManager.getInstance().isLogin()) {
                    // yes, it is true
                }
                Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "login failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // although there many threads request login, only one LoginActivity will start, if the login action success, all
    // the LoginListeners callback will be called
    private void manyThreadsLogin() {
        // thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                // in threads, such as the api response the login token has expired
                SmartLogin.requestLogin(MainActivity.this, LoginActivity.class, new LoginListener() {
                    @Override
                    public void onSuccess() {
                        if (UserManager.getInstance().isLogin()) {
                            // yes, it is true
                        }
                        Toast.makeText(getApplicationContext(), "login success1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "login failure1", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
        // thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                // in threads, such as the api response the login token has expired
                SmartLogin.requestLogin(MainActivity.this, LoginActivity.class, new LoginListener() {
                    @Override
                    public void onSuccess() {
                        if (UserManager.getInstance().isLogin()) {
                            // yes, it is true
                        }
                        Toast.makeText(getApplicationContext(), "login success2", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "login failure2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
        // thread 3
        new Thread(new Runnable() {
            @Override
            public void run() {
                // in threads, such as the api response the login token has expired
                SmartLogin.requestLogin(MainActivity.this, LoginActivity.class, new LoginListener() {
                    @Override
                    public void onSuccess() {
                        if (UserManager.getInstance().isLogin()) {
                            // yes, it is true
                        }
                        Toast.makeText(getApplicationContext(), "login success3", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "login failure3", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
        // thread 4
        new Thread(new Runnable() {
            @Override
            public void run() {
                // in threads, such as the api response the login token has expired
                SmartLogin.requestLogin(MainActivity.this, LoginActivity.class, new LoginListener() {
                    @Override
                    public void onSuccess() {
                        if (UserManager.getInstance().isLogin()) {
                            // yes, it is true
                        }
                        Toast.makeText(getApplicationContext(), "login success4", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "login failure4", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}

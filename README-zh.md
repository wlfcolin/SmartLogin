# SmartLogin

一个用于android的简单实用登录库，很简单的api跳入登录界面并获得登录结果。即使在不同的线程中多次调用，它也可以保证不会弹出多个登录界面。


----------------------------------------------------------------------
**截图**
* ![image](https://github.com/wlfcolin/SmartLogin/blob/master/capture/capture.gif)


----------------------------------------------------------------------
**快速开始**
* 1、在项目app模块的build.gradle配置gradle
``` java
compile 'me.andy5:SmartLogin:0.2.0'
```

* 2、创建一个登录界面，写好你的登录逻辑
``` java
public class LoginActivity extends Activity {
}
```

* 3、如果登录成功，在结束登录界面前调用一下setResult(RESULT_OK)即可
``` java
if(loginSuccess){
    UserManager.getInstance().setLogin(true);
    setResult(RESULT_OK);
}else{
    UserManager.getInstance().setLogin(false);
}
finish();
```


* 4、在需要登录的地方调用SmartLogin.requestLogin(Context context, Class<? extends Activity> loginActivity, LoginListener
                             loginListener)
``` java
SmartLogin.requestLogin(this, LoginActivity.class, new LoginListener() {...});
```


* 5、在LoginListener做登录成功或者失败逻辑
``` java
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
```

----------------------------------------------------------------------
**[下载demo.apk](https://github.com/wlfcolin/SmartLogin/blob/master/apk/demo.apk?raw=true)**


----------------------------------------------------------------------
**LICENSE**
```
Copyright 2017 wlfcolin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
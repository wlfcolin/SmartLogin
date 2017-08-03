# SmartLogin

a easy login lib for android to goto a login activity and get the login results. it is guarantee that never goto the login activity twice, even though they called in different threads.


[中文说明文档](https://github.com/wlfcolin/SmartLogin/blob/master/README-zh.md)


----------------------------------------------------------------------
**Captures**
* ![image](https://github.com/wlfcolin/SmartLogin/blob/master/capture/capture.gif)


----------------------------------------------------------------------
**it is easy to use the lib**


* 1.create a activity for your login logic
``` java
public class LoginActivity extends Activity {
}
```

* 2.if your logic is success, call the setResult(RESULT_OK) before finish your activity
``` java
if(loginSuccess){
    UserManager.getInstance().setLogin(true);
    setResult(RESULT_OK);
}else{
    UserManager.getInstance().setLogin(false);
}
finish();
```


* 3.call SmartLogin.requestLogin(Context context, Class<? extends Activity> loginActivity, LoginListener
                             loginListener) in your logic that need login first
``` java
SmartLogin.requestLogin(this, LoginActivity.class, new LoginListener() {...});
```


* 4.do your login success or failure logic in the LoginListener
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
**jcenter and maven center are under uploading**


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


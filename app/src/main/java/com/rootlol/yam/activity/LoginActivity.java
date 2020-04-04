package com.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.api.OauthYandexApi;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.pojo.TokenPojo;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//
public class LoginActivity extends AppCompatActivity {
    private Button buttonSingIn;
    private EditText login;
    private EditText password;
    private LinearLayout lo_login;
    private ProgressBar progress;

    private String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_input);
        password = findViewById(R.id.password_input);

        lo_login = findViewById(R.id.lo_login);
        progress = findViewById(R.id.progress);

        buttonSingIn = findViewById(R.id.buttonSingIn);
        buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lo_login.setVisibility(View.INVISIBLE);
                progress.setVisibility(View.VISIBLE);

                Map<String, String> LoginPostBody = new HashMap<>();
                LoginPostBody.put("grant_type", "password");
                LoginPostBody.put("client_id", "23cabbbdc6cd418abb4b39c32c41195d");
                LoginPostBody.put("client_secret", "53bc75238f0c4d08a118e51fe9203300");
                LoginPostBody.put("username", login.getText().toString());
                LoginPostBody.put("password", password.getText().toString());
                OauthYandexApi.getInstance().login(LoginPostBody).enqueue(new Callback<TokenPojo>() {
                    @Override
                    public void onResponse(Call<TokenPojo> call, Response<TokenPojo> response) {
                        if (response.body().getAccess_token() != null) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            UsersDB.UserDao userDao = App.getInstance().getDatabase().userDao();
                            userDao.insert(new UsersDB.UserEntity(login.getText().toString(),
                                    response.body().getAccess_token(),
                                    response.body().getUid()));
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.error_in_login_and_pass, Toast.LENGTH_LONG).show();
                            lo_login.setVisibility(View.VISIBLE);
                            progress.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<TokenPojo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), R.string.not_net, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void buttonSingUp(View view){
        String url = "https://passport.yandex.ru/registration";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(Intent.createChooser(intent, "Browse with"));
    }
}

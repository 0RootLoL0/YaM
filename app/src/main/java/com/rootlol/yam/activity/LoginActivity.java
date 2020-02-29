package com.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.db.ApplicationDB;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.pojo.TokenPojo;
import com.rootlol.yam.pojo.accountstatus.AccountStatusPojo;
import com.rootlol.yam.pojo.feed.FeedPojo;
import com.rootlol.yam.pojo.feed.GeneratedPlaylist;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private Button buttonSingIn;
    private EditText login;
    private EditText password;
    private LinearLayout lo_login;
    private ProgressBar progress;

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
                OauthApi oauthApi = new OauthApi();
                oauthApi.execute(login.getText().toString(), password.getText().toString());
            }
        });
    }

    public void buttonSingUp(View view){
        String url = "https://passport.yandex.ru/registration";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(Intent.createChooser(intent, "Browse with"));
    }

    class helperC{
        public TokenPojo TPh;
        public AccountStatusPojo ASPh;

        public helperC(TokenPojo TPh, AccountStatusPojo ASPh) {
            this.TPh = TPh;
            this.ASPh = ASPh;
        }
    }

    public class OauthApi extends AsyncTask<String, Void, helperC> {

        private TokenPojo getToken(String login, String password){
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("grant_type", "password")
                    .add("client_id", "23cabbbdc6cd418abb4b39c32c41195d")
                    .add("client_secret", "53bc75238f0c4d08a118e51fe9203300")
                    .add("username", login)
                    .add("password", password)
                    .build();
            Request request = new Request.Builder().url("https://oauth.yandex.ru/token").post(formBody).build();

            try {
                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                String serverAnswer = response.body().string();
                TokenPojo TP = gson.fromJson(serverAnswer, TokenPojo.class);
                if (TP.getToken_type() != null){
                    return TP;
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        private AccountStatusPojo getAccountStatus(String token){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.music.yandex.net/account/status")
                    .header("Authorization", "OAuth "+token)
                    .build();

            try {
                okhttp3.Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                AccountStatusPojo ASP = gson.fromJson(response.body().string(), AccountStatusPojo.class);

                if (ASP != null){
                    return ASP;
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected helperC doInBackground(String... lp) {
            TokenPojo TP = getToken(lp[0], lp[1]);
            AccountStatusPojo ASP = getAccountStatus(TP.getAccess_token());
            return new helperC(TP, ASP);
        }

        @Override
        protected void onPostExecute(helperC s) {
            super.onPostExecute(s);
            if (s.TPh != null & s.ASPh != null) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);


                UsersDB.UserDao userDao = App.getInstance().getDatabase().userDao();
                userDao.insert(new UsersDB.UserEntity(s.ASPh.getResult().getAccount().getLogin(), s.TPh.getAccess_token(), s.TPh.getUid()));
                ApplicationDB.ApplicationDao applicationDao = App.getInstance().getDatabase().applicationDao();
                applicationDao.insert(new ApplicationDB.ApplicationEntity(0,0, 0, 10));

                startActivity(intent);
                finish();
            } else if (s.TPh.getAccess_token() == null){
                Toast.makeText(getApplicationContext(), "Login and password error", Toast.LENGTH_LONG).show();
                lo_login.setVisibility(View.VISIBLE);
                progress.setVisibility(View.INVISIBLE);
            } else {
                Toast.makeText(getApplicationContext(), "network error", Toast.LENGTH_LONG).show();
                lo_login.setVisibility(View.VISIBLE);
                progress.setVisibility(View.INVISIBLE);
            }
        }
    }
}

package com.Android.ICreated;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

/**
 * Created by Филипп on 07.10.2014.
 */

public class StartPageActivity extends Activity{

    EditText userName;
    EditText password;
    EditText passwordConfirm;
    TextView DEBUG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        showStartPage();

    }

    private void showStartPage()
    {
        Button btnToMap = (Button) findViewById(R.id.btnToMap);
        View.OnClickListener oclBtnToMapButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("test", ServerAPI.user.getToken());

                ToMap();
            }
        };
        btnToMap.setOnClickListener(oclBtnToMapButton);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        View.OnClickListener oclBtnRegister = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        };
        btnRegister.setOnClickListener(oclBtnRegister);

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        View.OnClickListener oclBtnSignIn =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        };
        btnSignIn.setOnClickListener(oclBtnSignIn);
    }

    private void ToMap()
    {

        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        finish();
    }

    private void Register()
    {
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);

        ServerAPI.setUser(userName.getText().toString(), password.getText().toString(), passwordConfirm.getText().toString());
        ServerAPI.Response response = ServerAPI.RegistrationNewUser();

    }
    private void signIn()
    {
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        ServerAPI.setUser(userName.getText().toString(), password.getText().toString());
        Log.d("signInS", Boolean.toString(ServerAPI.signIn()));
    }
}

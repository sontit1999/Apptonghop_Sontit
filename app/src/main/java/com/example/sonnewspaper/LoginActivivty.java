package com.example.sonnewspaper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivivty extends AppCompatActivity {
    ProgressBar progressBar;
    EditText edtusername,edtpassword;
    Button btnlogin;
    TextView txtregister;
    String urllogin = "https://sontithaui.000webhostapp.com/login.php";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activivty);
        anhxa();
        progressBar.setVisibility(View.INVISIBLE);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtusername.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();
                if(username.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LoginActivivty.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                }else{
                    login(username,password);
                }
            }
        });
    }

    private void login(final String user, final String pass) {
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest  =  new StringRequest(Request.Method.POST, urllogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    if(response.toString().equals("success"))
                    {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",user);
                        editor.putString("password",pass);
                        editor.commit();
                        startActivity(new Intent(LoginActivivty.this,MainActivity.class));
                        progressBar.setVisibility(View.INVISIBLE);
                    }else{
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivivty.this, "Tài khoản học mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivivty.this, "Lỗi request", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("username",user);
                param.put("password",pass);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void anhxa() {
        sharedPreferences = getSharedPreferences("datalogin",MODE_PRIVATE);
        progressBar = (ProgressBar) findViewById(R.id.progresbar);
        edtpassword = (EditText) findViewById(R.id.edittextmk);
        edtusername = (EditText) findViewById(R.id.edittexttk);
        edtusername.setText(sharedPreferences.getString("username",""));
        edtpassword.setText(sharedPreferences.getString("password",""));
        btnlogin = (Button) findViewById(R.id.butttonlogin);
        txtregister = (TextView) findViewById(R.id.textviewnotaccount);
    }
}

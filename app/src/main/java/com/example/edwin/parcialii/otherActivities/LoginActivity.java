package com.example.edwin.parcialii.otherActivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.edwin.parcialii.API.GameNewsAPI;
import com.example.edwin.parcialii.API.TokenDeserializer;
import com.example.edwin.parcialii.R;
import com.example.edwin.parcialii.main.MainActivity;
import com.example.edwin.parcialii.modelos.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText contra, usuario;
    private ImageButton boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.editTUser_login);
        contra = findViewById(R.id.editTContra_loguin);
        boton = findViewById(R.id.btn_login);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    private void login(){
        Gson gson = new GsonBuilder().registerTypeAdapter(String.class,new TokenDeserializer()).create();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(GameNewsAPI.BASEURL).addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.build();
        GameNewsAPI gameNewsAPI = retrofit.create(GameNewsAPI.class);
        final Usuario users = new Usuario(usuario.getText().toString(),contra.getText().toString());
        Call<String> call = gameNewsAPI.login(users.getUser(),users.getPassword());
        call.enqueue(new Callback<String>() {
            //Hacemos el request y esperamos una respuesta del server...
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && !response.body().equals("") && !usuario.getText().equals("") && !contra.getText().equals("")) {
                    guardarToken(response.body());
                    Toast.makeText(LoginActivity.this,response.body(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "No hubo respuesta del server", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    Toast.makeText(LoginActivity.this, "Error 404 viejita", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void guardarToken(String respuesta){
        SharedPreferences sharedPreferences = this.getSharedPreferences("Login_Token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token",respuesta);
        editor.apply();
    }
}

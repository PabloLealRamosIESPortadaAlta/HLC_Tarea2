package com.example.hlc_tarea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hlc_tarea2.Ejerciciio1.MainActivity1;
import com.example.hlc_tarea2.Ejercicio2.MainActivity2;
import com.example.hlc_tarea2.Ejercicio3.MainActivity3;


public class MainActivity extends AppCompatActivity
{
    private Button button1;
    private Button button2;
    private Button button3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar myToolbar = (Toolbar) findViewById(R.id.Ejercicio1);
        setSupportActionBar(myToolbar);

        button1 =(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });

        button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        button3 =(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });


    }
}
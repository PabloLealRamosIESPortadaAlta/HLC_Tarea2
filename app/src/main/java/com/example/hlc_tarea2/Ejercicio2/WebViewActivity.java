package com.example.hlc_tarea2.Ejercicio2;

// WebViewActivity.java
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hlc_tarea2.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.webView);



        // Obtener la URL de la actividad principal
        String url = getIntent().getStringExtra("url");

        // Cargar la URL en WebView
        webView.loadUrl(url);

        // Configurar WebViewClient para que la navegación se realice dentro de WebView
        webView.setWebViewClient(new WebViewClient());
    }
}

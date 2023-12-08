package com.example.hlc_tarea2.Ejercicio2;

// MainActivity.java
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hlc_tarea2.R;

/**
* Crear una aplicación que utilice intents para comunicar dos actividades.
La aplicación permitirá introducir una dirección web en un cuadro de texto. Se añadirán dos botones
*  para acceder a dicha web.

Cuando se pulse un botón, se lanzará el navegador para acceder a la dirección introducida.
Cuando se pulse el otro botón, aparecerá una nueva ventana (una nueva actividad) en la que se
*  mostrará la web pedida. Se deberá usar la clase WebView para mostrar en la ventana de la nueva
*  actividad el contenido de la web.
Es necesario dar a la aplicación el permiso de acceder a Internet (en el fichero AndroidManifest.xml):
<uses-permission android:name="android.permission.INTERNET"/>

* */
/**
 * No olvidar añadir en manifest la expresion
 * <uses-permission android:name="android.permission.INTERNET" />
 * OJO, esto va junto antes de que comience "<Application" Es decir, es hijo
 *
 */
public class MainActivity2 extends AppCompatActivity {

    private EditText editTextUrl;
    private Button btnOpenInBrowser;
    private Button btnOpenInWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar myToolbar = (Toolbar) findViewById(R.id.Ejercicio2);
        setSupportActionBar(myToolbar);


        editTextUrl = findViewById(R.id.editTextUrl);
        btnOpenInBrowser = findViewById(R.id.btnOpenInBrowser);
        btnOpenInWebView = findViewById(R.id.btnOpenInWebView);

        btnOpenInBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInBrowser();
            }
        });

        btnOpenInWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInWebView();
            }
        });
    }

    private void openInBrowser() {

        /**
         * He forzado que se ecriba el http:// ya que cuando abria en el navegador me saltaba el error: net:err_cleartext_not_permitted
         * Pero en el webView no salia
         */
        String url = "https://" + editTextUrl.getText().toString() ;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        //startActivity(browserIntent);
    }

    private void openInWebView() {
        String url = "https://"+editTextUrl.getText().toString();
        Intent webViewIntent = new Intent(this, WebViewActivity.class);
        webViewIntent.putExtra("url", url);
        startActivity(webViewIntent);
    }
}
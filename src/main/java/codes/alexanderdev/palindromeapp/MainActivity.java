package codes.alexanderdev.palindromeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import codes.alexanderdev.palindromeapp.lista.Lista;
import codes.alexanderdev.palindromeapp.lista.Palabra;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private Button btnCheck;
    private ArrayList<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etText.getText().toString();

                etText.setText("");

                if(Lista.esPalindromo(text)) {
                    guardarPalabra(text);
                    showRespuesta1Activity();
                } else {
                    showRespuesta2Activity();
                }
            }
        });

        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(intent);
    }

    public void nextPage(View view){
        Intent siguiente = new Intent(this, listView.class);
        siguiente.putStringArrayListExtra("listPalabras", mList);
        startActivity(siguiente);
    }

    public void guardarPalabra(String texto) {
                texto = texto.trim();
                mList.add(texto);
    }

    private void showRespuesta1Activity() {
        Intent i = new Intent(this, respuesta1.class);
        startActivity(i);
    }

    private void showRespuesta2Activity() {
        Intent i = new Intent(this, respuesta2.class);
        startActivity(i);
    }
}
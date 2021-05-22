package codes.alexanderdev.palindromeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import codes.alexanderdev.palindromeapp.lista.Lista;
import codes.alexanderdev.palindromeapp.lista.Palabra;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        btnCheck = findViewById(R.id.btnCheck);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPalindrome();
            }
        };

        btnCheck.setOnClickListener(clickListener);

        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(intent);
    }

    public void isPalindrome() {
        Intent intent = new Intent(this, respuesta1.class);
        Lista lista = new Lista(),
              listaInversa = new Lista();
        String text = etText.getText().toString();


        for (int i = 0; i < text.length(); i++) {
            if(Character.isLetter(text.charAt(i))) {
                Palabra palabra = new Palabra(text.charAt(i));
                lista.agregarAlFinal(palabra);
                listaInversa.agregarAlInicio(palabra);
            }
        }

        if(lista.listar().equals(listaInversa.listar())) {
            startActivity(intent);
        } else {
            intent = new Intent(this, respuesta2.class);
            startActivity(intent);
        }


    }
}
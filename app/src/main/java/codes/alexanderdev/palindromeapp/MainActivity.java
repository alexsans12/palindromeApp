package codes.alexanderdev.palindromeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

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
                isPalindrome();
            }
        });

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
            guardarPalabra(text);
            startActivity(intent);
        } else {
            intent = new Intent(this, respuesta2.class);
            startActivity(intent);
        }

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
}
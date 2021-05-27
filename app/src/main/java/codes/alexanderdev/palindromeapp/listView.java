package codes.alexanderdev.palindromeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import codes.alexanderdev.palindromeapp.lista.Lista;

public class listView extends AppCompatActivity {

    private ArrayAdapter<String> mAdapter;
    private ListView lvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvDatos = findViewById(R.id.listView1);

        mAdapter = new ArrayAdapter<String>(this, R.layout.list_item_listview,
                getIntent().getExtras().getStringArrayList("listPalabras"));
        lvDatos.setAdapter(mAdapter);

        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();

                if(Lista.esPalindromo(text)) {
                    showRespuesta1Activity();
                } else {
                    showRespuesta2Activity();
                }
            }
        });
    }

    public void paginaAnterior(View view){
        finish();
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
package codes.alexanderdev.palindromeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

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
    }

    public void paginaAnterior(View view){
        finish();
    }
}
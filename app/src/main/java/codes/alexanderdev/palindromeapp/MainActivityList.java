package codes.alexanderdev.palindromeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityList extends AppCompatActivity {
        //Esta parte del proyecto aun esta en proceso
    private ListView lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        lv2 = (ListView)findViewById(R.id.listView2);
        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("frases");

    }
    //Metodos personalizados

    //btnVOLVER:
    public void lastPage(View view){
        Intent lastpage = new Intent(this, MainActivity.class);
        startActivity(lastpage);
    }
}
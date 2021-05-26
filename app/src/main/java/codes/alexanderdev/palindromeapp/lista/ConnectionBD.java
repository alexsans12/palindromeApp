package codes.alexanderdev.palindromeapp.lista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionBD extends SQLiteOpenHelper {

    //variables de la clase

    //strings que contiene las cadenas de lo que se guardara en la BD
    public static final String TABLE_ID = "_idDato";
    public static final String DATOS = "dato";

    //nombre de la base de datos, de la tabla d la base de datos a utilizar
    private static final String DATABASE= "Dato";
    private static final String TABLE = "datos";

    //
    public ConnectionBD(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }


    //Metodo OnCreate
    //Metodo encargado de inicializar la bae de datos, se ejecuta una vez se crea la clase
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE +"("+
                TABLE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DATOS+"TEXT)");
    }

    //Este metodo se utilizara en caso de que haga falta actualizar la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    //Metodo Close
    public void close(){
        this.close();
    }

    //Metodo de incercion
    public void addDato(String dato){
        ContentValues val = new ContentValues();
        val.put(DATOS, dato);
        this.getWritableDatabase().insert(TABLE,null,val);
    }

    //Metodo de vista
    public Cursor getDato(){
        String columnas[] = {TABLE_ID, DATOS};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas,null,null,null, null, null);
        return c;
    }
}


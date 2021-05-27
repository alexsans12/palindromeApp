package codes.alexanderdev.palindromeapp.lista;

public class Palabra {

    public char letra;

    // Constructor
    public Palabra() {
    }

    public Palabra( char nombre) {
        this.letra = nombre;
    }

    @Override
    public String toString() {
        return "" + letra;
    }

    public char getNombre() {
        return letra;
    }

    public void setNombre(char nombre) {
        this.letra = nombre;
    }
}

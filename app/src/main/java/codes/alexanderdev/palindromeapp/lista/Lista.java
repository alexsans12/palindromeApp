package codes.alexanderdev.palindromeapp.lista;

import android.content.Intent;

import java.text.Normalizer;
import java.util.regex.Pattern;

import codes.alexanderdev.palindromeapp.respuesta1;
import codes.alexanderdev.palindromeapp.respuesta2;

public class Lista {

    private Nodo inicio;
    public int tamanio;

    public Lista(){
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }

    public void agregarAlFinal(Palabra valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();

        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
        } else{
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }

    //Agrega un nuevo nodo al inicio de la lista.
    public void agregarAlInicio(Palabra valor){
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            this.inicio = nuevo;
        } else{
            // Une el nuevo nodo con la lista existente.
            nuevo.setSiguiente(this.inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            this.inicio = nuevo;
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }

    public String listar(){
        String i = "";
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            Nodo aux = this.inicio;
            // Posicion de los elementos de la lista.

            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del nodo.
                i+=""+aux.getValor().toString();

                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
            }
            return i;
        }

        return i;
    }

    static public boolean esPalindromo(String texto) {
        String textoVerif = unAccent(texto.toLowerCase());

        Lista lista = new Lista(),
                listaInversa = new Lista();

        for (int i = 0; i < texto.length(); i++) {
            if(Character.isLetter(textoVerif.charAt(i))) {
                Palabra palabra = new Palabra(textoVerif.charAt(i));
                lista.agregarAlFinal(palabra);
                listaInversa.agregarAlInicio(palabra);
            }
        }

        return  lista.listar().equals(listaInversa.listar());
    }

    public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
}

package codes.alexanderdev.palindromeapp.lista;

public class Nodo {

    private Palabra valor;
    private Nodo siguiente;

    public Nodo(){
        this.valor = null;
        this.siguiente = null;
    }

    public Nodo(Palabra a){
        this.valor = a;
        this.siguiente = null;
    }


    public Palabra getValor() {
        return valor;
    }

    public void setValor(Palabra valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

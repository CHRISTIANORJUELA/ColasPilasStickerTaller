package Contenedor;

import java.util.ArrayList;

public class Nodo {
    static int id;
    int uniqueId;
    ArrayList<String> items = new ArrayList<>();
    String destino;
    String procedencia;
    Nodo sig;
    public Nodo(String destino,String procedencia){
        Nodo.id += 1;
        this.uniqueId = id;
        this.procedencia = procedencia;
        this.destino = destino;
    }
    public void setItem(ArrayList<String> arrayList){
        items.addAll(arrayList);
    }
    public void setItem(String item){
        items.add(item);
    }
}

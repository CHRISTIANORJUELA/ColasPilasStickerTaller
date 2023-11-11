package FilaBanco;

public class Nodo {
    static int id;
    int uniqueId;
    String namePerson;
    int amoung;
    Nodo sig;

    public Nodo(String namePerson,int amoung){
        Nodo.id+=1;
        this.namePerson = namePerson;
        this.amoung = amoung;
        this.uniqueId = Nodo.id;
    }
}

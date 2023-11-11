package FilaBanco;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Fila {
    Nodo cab;
    Nodo fin;
    Nodo movil;
    Nodo borra;

    public void agregar(){
        String name = JOptionPane.showInputDialog("Ingresa el nombre de la persona");
        int amoung = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dinero de la persona"));
        Nodo nodo = new Nodo(name,amoung);
        if (cab==null){
            cab = nodo;
            fin = nodo;
        }else {
            fin.sig = nodo;
            fin = nodo;
        }
    }

    public void mostrar(){
        movil = cab;
        System.out.println("*".repeat(10));
        System.out.println("Las personas en la fila son : ");
        while (movil!=null){
            System.out.println("Tiquete de la persona en la fila "+movil.uniqueId);
            System.out.println("Nombre de la persona "+movil.namePerson);
            System.out.println("Monto de la persona "+movil.amoung);
            movil = movil.sig;
        }
    }

    public void atender(){
        while (true){
            if (JOptionPane.showInputDialog("1. Para continuar \n Presiona e para salir").equalsIgnoreCase("e")){
                break;
            }else {
                int discountAmoung = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dinero que vas ha retirar"));
                int amoungBefore = cab.amoung;
                cab.amoung = discountAmoung>cab.amoung?0:cab.amoung-discountAmoung;
                mostrarCabeza(cab,amoungBefore);
                borra = cab;
                cab = cab.sig;
                borra = null;
                System.out.println("Persona atendida");
            }
        }
    }

    public void mostrarCabeza(Nodo nodo,int amoungBefore){
        System.out.println("Id unico de la persona "+nodo.uniqueId);
        System.out.println("Nombre de la persona "+nodo.namePerson);
        System.out.println("Monto de la persona antes "+amoungBefore+" ahora el monto es "+nodo.amoung);
    }

    public void consultar(){
        int tiquetSearch = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiquete que desea buscar"));
        movil = cab;
        String name = "";
        while (movil != null){
            if (movil.uniqueId == tiquetSearch){
                name = movil.namePerson;
            }
            movil = movil.sig;
        }

        if (name.isEmpty()){
            System.out.println("Ninguna persona en la fila tiene ese tiquete");
        }else {
            System.out.println("La persona con el tiquete "+tiquetSearch+" es "+name);
        }
    }
    public static void main(String[] args) {
        Fila fila = new Fila();
       while (true){
            switch (JOptionPane.showInputDialog("1. Agregar persona \n 2. Atender personas y recibir el dinero \n 3.Consultar si una persona tiene un tiquete especifico en la fila \n 4.Mostrar integrantes de la fila")){
                case "1":
                      fila.agregar();
                    break;
                case "2":
                    fila.atender();
                    break;
                case "3":
                    fila.consultar();
                    break;
                case "4":
                    fila.mostrar();
                    break;
            }
       }
    }
}
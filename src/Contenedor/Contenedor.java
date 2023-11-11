package Contenedor;

import javax.swing.*;

public class Contenedor {
    Nodo cab;
    Nodo fin;
    Nodo movil;

    public void Agregar() {
        String procedencia = JOptionPane.showInputDialog("Ingresa la procedencia del contenedor");
        String destiono = JOptionPane.showInputDialog("Ingresa el destiono de contenedor");
        String producto = JOptionPane.showInputDialog("Ingresa un producto al contenedor ");
        Nodo nodo = new Nodo(destiono,procedencia);
        nodo.setItem(producto);
        nodo.sig = cab;
        cab = nodo;
    }

    public void agregarItems(){
        String valor = "";
        boolean out = true;
        while (true){
            valor = JOptionPane.showInputDialog("Escribe el id del contenedor o presiona la letra e para salir");
            if (valor.equalsIgnoreCase("e")){
                break;
            }else {
                movil = cab;
                while (movil!=null){

                    if (movil.uniqueId == Integer.parseInt(valor)){
                        String producto = JOptionPane.showInputDialog("Ingresa el producto que deseas ingresar al contenedor");
                        movil.setItem(producto);
                        System.out.println("Contenedor con mas productos !!!");
                        out = false;
                        break;
                    }
                    movil = movil.sig;
                }
                if (out){
                    System.out.println("Contenedor no existe");
                }
            }
        }
    }


    public void consultar(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Escribe el id del contenedor"));
        movil = cab;
        boolean out = true;
        while (movil!=null){
            if (movil.uniqueId == id){
                System.out.println("*".repeat(10));
                System.out.println("Contenedor encontrado");
                System.out.println("id del contenedor "+movil.uniqueId);
                System.out.println("procedencia del contenedor "+movil.procedencia);
                System.out.println("Destino del contenedor "+movil.destino);
                System.out.println("Productos del contenedor "+movil.items);
                out = false;
                break;
            }
            movil = movil.sig;
        }
        if (out){
            System.out.println("Contenedor no existe");
        }
    }

    public void mostrar(){
        movil = cab;
        System.out.println("Contenedores");
        while (movil!=null){
                System.out.println("*".repeat(10));
                System.out.println("id del contenedor "+movil.uniqueId);
                System.out.println("procedencia del contenedor "+movil.procedencia);
                System.out.println("Destino del contenedor "+movil.destino);
                System.out.println("Productos del contenedor "+movil.items);
            movil = movil.sig;
        }
    }

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        while (true){
            switch (JOptionPane.showInputDialog("1. Agregar contenedor \n 2.Consultar un contenedor por su Id \n 3.Agregar elementos a un contenedor en especifico \n 4. Mostrar Contendeor")){
                case "1":
                    contenedor.Agregar();
                    break;
                case "2":
                    contenedor.consultar();
                    break;
                case "3":
                    contenedor.agregarItems();
                    break;
                case "4":
                    contenedor.mostrar();
                    break;
            }
        }
    }
}

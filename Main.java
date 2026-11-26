/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 * Ander Esau Hernandez Jimenez
 */

public class Main {
    
    // --- PRUEBAS DE LISTA LIGADA DOBLE ---
    public static void main(String[] args) {
        ListaLigadaD lista = new ListaLigadaD();

        System.out.println("=== 1. insertarFinal 10, 20, 30 ===");
        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        System.out.println(lista);                       // [10]->[20]->[30]->NULL
        lista.mostrarAtras();                            // 30 <-> 20 <-> 10

        System.out.println("\n=== 2. insertarInicio 5 ===");
        lista.insertarInicio(5);
        System.out.println(lista);                       // [5]->[10]->[20]->[30]->NULL
        lista.mostrarAtras();                            // 30 <-> 20 <-> 10 <-> 5

        System.out.println("\n=== 3. insertarEnPosicion(3, 15) ===");
        lista.insertarEnPosicion(3, 15);
        System.out.println(lista);                       // [5]->[10]->[15]->[20]->[30]->NULL
        lista.mostrarAtras();                            // 30 <-> 20 <-> 15 <-> 10 <-> 5

        System.out.println("\n=== 4. insertarFinal 40 ===");
        lista.insertarFinal(40);
        System.out.println(lista);                       // [5]->[10]->[15]->[20]->[30]->[40]->NULL

        System.out.println("\n=== 5. buscar ===");
        System.out.println("buscar(15): " + lista.buscar(15));    // true
        System.out.println("buscar(999): " + lista.buscar(999));  // false

        System.out.println("\n=== 6. actualizar posicion 4 a 25 ===");
        lista.actualizar(25, 4);
        System.out.println(lista);                       // [5]->[10]->[15]->[25]->[30]->[40]->NULL

        System.out.println("\n=== 7. eliminarPorValor(15) (en medio) ===");
        System.out.println("Resultado: " + lista.eliminarPorValor(15));  // true
        System.out.println(lista);                       // [5]->[10]->[25]->[30]->[40]->NULL
        lista.mostrarAtras();                            // 40 <-> 30 <-> 25 <-> 10 <-> 5

        System.out.println("\n=== 8. eliminarPorValor(999) (no existe) ===");
        System.out.println("Resultado: " + lista.eliminarPorValor(999)); // false

        System.out.println("\n=== 9. eliminarPorValor(5) (cabeza) ===");
        System.out.println("Resultado: " + lista.eliminarPorValor(5));   // true
        System.out.println(lista);                       // [10]->[25]->[30]->[40]->NULL

        System.out.println("\n=== 10. eliminarPorValor(40) (cola) ===");
        System.out.println("Resultado: " + lista.eliminarPorValor(40));  // true
        System.out.println(lista);                       // [10]->[25]->[30]->NULL
        lista.mostrarAtras();                            // 30 <-> 25 <-> 10

        System.out.println("\n=== 11. eliminarEnPosicion(2) (en medio) ===");
        System.out.println("Eliminado: " + lista.eliminarEnPosicion(2)); // 25
        System.out.println(lista);                       // [10]->[30]->NULL

        System.out.println("\n=== 12. eliminarEnPosicion(tamanio) (cola) ===");
        System.out.println("Eliminado: " + lista.eliminarEnPosicion(lista.getTamanio())); // 30
        System.out.println(lista);                       // [10]->NULL

        System.out.println("\n=== 13. eliminarAlInicio (un solo nodo) ===");
        System.out.println("Eliminado: " + lista.eliminarAlInicio()); // 10
        System.out.println(lista);                       // NULL
        System.out.println("estaVacia: " + lista.estaVacia() + ", tamanio: " + lista.getTamanio());

        System.out.println("\n=== 14. eliminarUltimo en lista vacia ===");
        System.out.println("Resultado: " + lista.eliminarUltimo()); // false

        System.out.println("\n=== 15. eliminarAlInicio en lista vacia ===");
        try {
            lista.eliminarAlInicio();
        } catch (IllegalStateException e) {
            System.out.println("Excepcion esperada: " + e.getMessage());
        }

        System.out.println("\n=== 16. insertarOrdenado: 30, 10, 50, 20, 40 ===");
        ListaLigadaD ordenada = new ListaLigadaD();
        ordenada.insertarOrdenado(30);
        ordenada.insertarOrdenado(10);   // inicio
        ordenada.insertarOrdenado(50);   // final
        ordenada.insertarOrdenado(20);   // medio
        ordenada.insertarOrdenado(40);   // medio
        System.out.println(ordenada);                    // [10]->[20]->[30]->[40]->[50]->NULL
        ordenada.mostrarAtras();                         // 50 <-> 40 <-> 30 <-> 20 <-> 10

        System.out.println("\n=== 17. eliminarUltimo hasta vaciar ===");
        System.out.println("Resultado: " + ordenada.eliminarUltimo()); // true
        System.out.println(ordenada);                    // [10]->[20]->[30]->[40]->NULL
        ordenada.mostrarAtras();                         // 40 <-> 30 <-> 20 <-> 10
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * Ander Esau Hernandez Jimenez 4:A
 */
public class ListaLigadaD {
    //Esto fue lo hablado en clase
    private int tamanio;
    private nodoD cabeza;
    private nodoD cola;//nuevo
    
    public ListaLigadaD(){
        tamanio=0;
        cabeza=null;
        cola=null;
    }
    
    public boolean estaVacia(){
        if(cabeza==null && cola==null){
            return true;
        }
        return false;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    //Obtener int actualizar int obtener nodo it, to string.
    
    
    public boolean buscar(int valor) {
        nodoD actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == valor) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    //Obtener un nodo en la de la lista
    public nodoD obtenerNodo(int posicion){
        //Validamos que la posicion que se esta solicitando esta dentro de los rangos, es decir, que este acorde al tamaño de la lista
        if(posicion <=0 || posicion > tamanio){
            throw new IllegalStateException("Posicion Invalida " + posicion + " Rango valido es de 1 a "+tamanio);
        }
        nodoD aux=cabeza;
        for(int i = 1;i<posicion;i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    
    //metodo para imprimir la lista
    @Override
    public String toString() {
        if (estaVacia()) {
            return "NULL";
        }
        String res = "";
        nodoD aux = cabeza;
        while (aux != null) {
            res = res + "[" + aux.getDato() + "]->";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }
    
    public void actualizar(int dato, int posicion){
        nodoD aux = obtenerNodo(posicion);
        aux.setDato(dato);
    }

    //metodos de verdad
    
    public void insertarInicio(int dato){
        nodoD nuevo = new nodoD(dato);
       if(estaVacia()){
           cola=nuevo;
       }else{
        nuevo.setSiguiente(cabeza);
        cabeza.setAnterior(nuevo);
       }
       cabeza=nuevo;
       tamanio++;
       //Como nos comento el ing que son acciones que se repiten en ambas
       //Condiciones se puede poner fuera del if
    }
       
       
    public void insertarFinal(int dato){
        nodoD nuevo = new nodoD(dato);
    
        if(estaVacia()){
            cabeza=nuevo;
        }
        else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }
        cola=nuevo;
        tamanio++;
        //Condiciones que se repiten en ambas circunstancias
    }
    
    public int eliminarAlInicio(){
        //Verifico si la lista tiene elementos antes de eliminar algo
        if(estaVacia()){
            throw new IllegalStateException("La lista esta vacia");
        }
        int dato = cabeza.getDato();
        if(cabeza==cola){
            //Solo habia un nodo: la lista queda vacia
            cabeza=null;
            cola=null;
        }else{
            cabeza=cabeza.getSiguiente();
            cabeza.setAnterior(null);
            //no se considero con el ing pero se implementa
        }
        tamanio--;
        return dato;
    }
    //Metodos de tarea en classroom
    public void insertarEnPosicion(int pos, int dato){
        //Validamos rangos
        if(pos <=0 || pos > tamanio){
            throw new IllegalStateException("Posicion Invalida " + pos + " Rango valido es de 1 a "+tamanio);
        }
        //Caso 1: posicion al inicio
        if(pos==1){
            insertarInicio(dato);
            return;
        }
        //Caso 2: posicion en medio
        nodoD anterior = obtenerNodo(pos-1);
        nodoD siguiente = anterior.getSiguiente();
        nodoD nuevo = new nodoD(dato);

        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(siguiente);
        siguiente.setAnterior(nuevo);
        anterior.setSiguiente(nuevo);
        tamanio++;
    }
    
    //Metodo para eliminar el ultimo elemento de la lista
    public boolean eliminarUltimo(){
        //Primer caso: la lista esta vacia
        if(estaVacia()){
            return false;
        }
        //Segundo caso: solo hay un nodo
        if(cabeza==cola){
            cabeza=null;
            cola=null;
            tamanio--;
            return true;
        }
        //Tercer caso: varios nodos. La cola se va para atras y se salta para el enlace de hacia adelante
        cola=cola.getAnterior();
        cola.setSiguiente(null);
        tamanio--;
        return true;
    }
    
    //Metodo para eliminar por un valor especifico
    public boolean eliminarPorValor(int x){
        //Primer caso: queremos eliminar algo de una lista vacia
        if(estaVacia()){
            return false;
        }
        //Segundo caso: el elemento esta justamente en la cabeza
        if(cabeza.getDato()==x){
            eliminarAlInicio();
            return true;
        }
        //Tercer caso: el dato se encuentra en cualquier posicion despues de la primera
        nodoD aux = cabeza;
        while(aux.getSiguiente()!=null){
            if(aux.getSiguiente().getDato()==x){
                nodoD aux2 = aux.getSiguiente();
                if(aux2==cola){
                    //Esta al final
                    eliminarUltimo();
                }else{
                    //Esta en medio: unimos a sus vecinos en los dos sentidos
                    aux.setSiguiente(aux2.getSiguiente());
                    aux2.getSiguiente().setAnterior(aux);
                    tamanio--;
                }
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    //Eliminar por posicion
    public int eliminarEnPosicion(int pos){
        //Caso 1: validacion de rangos
        if(pos<=0 || pos > tamanio){
            throw new IllegalStateException("Posicion Invalida " + pos + " Rango valido es de 1 a "+tamanio);
        }
        //Caso 2: eliminar el primer nodo de la lista
        if(pos==1){
            return eliminarAlInicio();
        }
        //Caso 3: el resto de las posiciones
        nodoD aux = obtenerNodo(pos-1);
        nodoD aux2 = aux.getSiguiente();
        int res = aux2.getDato();
        if(aux2==cola){
            //Es el ultimo
            cola=aux;
            aux.setSiguiente(null);
        }else{
            //Esta en medio: unimos a los de alado en los dos sentidos
            aux.setSiguiente(aux2.getSiguiente());
            aux2.getSiguiente().setAnterior(aux);
        }
        tamanio--;
        return res;
    }
    
    //Inserta el dato en su lugar para que la lista quede de menor a mayor
    //Precondicion: la lista debe estar ordenada
    public void insertarOrdenado(int dato){
        //Caso a: la lista esta vacia
        if(estaVacia()){
            insertarInicio(dato);
            return;
        }
        //Caso b: el dato es menor que el primero
        if(dato < cabeza.getDato()){
            insertarInicio(dato);
            return;
        }
        //Caso c: recorremos hasta el nodo justo antes del lugar donde va el dato
        nodoD aux = cabeza;
        while(aux.getSiguiente()!=null && aux.getSiguiente().getDato() < dato){
            aux = aux.getSiguiente();
        }
        nodoD nuevo = new nodoD(dato);
        if(aux.getSiguiente()!=null){
            //Caso d: el dato va en medio de dos nodos
            nodoD siguiente = aux.getSiguiente();
            nuevo.setSiguiente(siguiente);
            siguiente.setAnterior(nuevo);
        }else{
            //Caso e: el dato es mayor o igual a todos, queda como el ultimo
            cola=nuevo;
        }
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        tamanio++;
    }
    //metodo para imprimir desde atras
    public void mostrarAtras(){
        if(estaVacia()){
            System.out.println("(lista vacia)");
            return;
        }
        nodoD aux = cola;
        while(aux!=null){
            System.out.print("[" + aux.getDato() + "]");
            if(aux.getAnterior()!=null){
                System.out.print(" <-> ");
            }
            aux=aux.getAnterior();
        }
        System.out.println();
    }
}


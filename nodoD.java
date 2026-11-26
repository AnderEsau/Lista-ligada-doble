/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * @author Daniel H J
 */
public class nodoD {
    private int dato;
    private nodoD siguiente;
    private nodoD anterior; //nuevo
    
    public nodoD(int dato){
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public nodoD getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodoD siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public nodoD getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(nodoD anterior) {
        this.anterior = anterior;
    }

    
}

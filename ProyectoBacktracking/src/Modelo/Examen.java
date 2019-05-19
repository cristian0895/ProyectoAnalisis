/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Examen {
    
    int cantPreguntas, nivelDificultad,tiempoDuracion,cantidadTemas;
    ArrayList<Pregunta> listaPreguntas;

    public Examen(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public Examen(int cantPreguntas, int nivelDificultad, int tiempoDuracion, int cantidadTemas, ArrayList<Pregunta> listaPreguntas) {
        this.cantPreguntas = cantPreguntas;
        this.nivelDificultad = nivelDificultad;
        this.tiempoDuracion = tiempoDuracion;
        this.cantidadTemas = cantidadTemas;
        this.listaPreguntas = listaPreguntas;
    }

    public int getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(int cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public int getTiempoDuracion() {
        return tiempoDuracion;
    }

    public void setTiempoDuracion(int tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }

    public int getCantidadTemas() {
        return cantidadTemas;
    }

    public void setCantidadTemas(int cantidadTemas) {
        this.cantidadTemas = cantidadTemas;
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    
}

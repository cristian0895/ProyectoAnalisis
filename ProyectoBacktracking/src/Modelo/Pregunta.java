/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Pregunta implements Comparable {

    String texto;
    int dificultad, tiempo, tema_id;
    String FECHA_CREACION;

    public Pregunta(String texto, int difiultad, int tiempo, int tema, String fechaCreacion) {
        this.texto = texto;
        this.dificultad = difiultad;
        this.tiempo = tiempo;
        this.tema_id = tema;
        this.FECHA_CREACION = fechaCreacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTema_id() {
        return tema_id;
    }

    public void setTema_id(int tema_id) {
        this.tema_id = tema_id;
    }

    public String getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public void setFECHA_CREACION(String FECHA_CREACION) {
        this.FECHA_CREACION = FECHA_CREACION;
    }

    @Override
    public int compareTo(Object objeto) {
// Indica en base a que atributos se compara el objeto
// Devuelve +1 si this es > que objeto
// Devuelve -1 si this es < que objeto
// Devuelve 0 si son iguales

        Pregunta pregunta = (Pregunta) objeto;
        String nombreObjeto = pregunta.texto.toLowerCase();
        String nombreThis = this.texto.toLowerCase();

        return (nombreThis.compareTo(nombreObjeto));
    }

}

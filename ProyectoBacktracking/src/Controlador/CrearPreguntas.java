/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
import Modelo.ClsConexion;
import Modelo.Pregunta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CrearPreguntas {

    ClsConexion conexion = new ClsConexion();
    String tabla = "preguntas";
    int numPreguntas;
    private ArrayList<Pregunta> bancoPreguntas;

    public CrearPreguntas(ArrayList<Pregunta> bancoPreguntas, int numPreguntas) {
        this.bancoPreguntas = bancoPreguntas;
        this.numPreguntas = numPreguntas;
    }

    public DefaultTableModel SolicitudListar() {
        DAOGenerico usuDAO = new DAOGenerico();

        DefaultTableModel modelTabla;
        ResultSet resut = usuDAO.listar(tabla, numPreguntas);
        String nombreColumnas[] = {"Preguunta", "Dificultad", "Tiempo", "Tema", "Fecha de Creacion"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        try {
            while (resut.next()) {
                modelTabla.addRow(new Object[]{
                    resut.getString("texto"),
                    resut.getInt("nombre"),
                    resut.getInt("tiempo"),
                    usuDAO.asignar2("nombre", "temas", "tema_id", resut.getInt("tema")),
                    resut.getString("fecha_creacion")});

            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");
        }
        return modelTabla;
    }


    public CrearPreguntas(ArrayList<Pregunta> bancoPreguntas) {

        this.bancoPreguntas = bancoPreguntas;
    }



    public void SolicitudListarArrayList() {
        DAOGenerico usuDAO = new DAOGenerico();
        Pregunta p;

        ResultSet resut = usuDAO.listar(tabla,numPreguntas);

        try {
            while (resut.next()) {

                p = new Pregunta(resut.getString("texto"),
                        resut.getInt("dificultad"), resut.getInt("tiempo"),
                        resut.getInt("tema_id"),
                        resut.getString("fecha_creacion"));

                bancoPreguntas.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");
        }

    }
}

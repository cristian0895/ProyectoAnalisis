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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CrearPreguntas {

    ClsConexion conexion = new ClsConexion();
    String tabla = "preguntas";

    public CrearPreguntas() {

    }

    

    public DefaultTableModel SolicitudListar() {
        DAOGenerico usuDAO = new DAOGenerico();

        DefaultTableModel modelTabla;
        ResultSet resut = usuDAO.listar(tabla);
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

    private ArrayList<String> organizadores = new ArrayList<>();
    private ArrayList<String> verbo = new ArrayList<>();
    private ArrayList<String> nombre = new ArrayList<>();
    private ArrayList<String> apellido = new ArrayList<>();

    private ArrayList<Pregunta> bancoPreguntas;

    public CrearPreguntas(ArrayList<Pregunta> bancoPreguntas) {

        this.bancoPreguntas = bancoPreguntas;
    }

//    public void crearPreguntas(int numero) {
//        int bien = 0;
//        organizadores.add("¿Quien");
//        organizadores.add("¿Como");
//        organizadores.add("¿Cuando");
//        organizadores.add("¿Donde");
//        organizadores.add("¿Por que");
//        organizadores.add("¿En que momento");
//        verbo.add("Nacio");
//        verbo.add("Vivio");
//        verbo.add("Murio");
//        verbo.add("Estudio");
//        verbo.add("Batallo contra");
//        verbo.add("Trabajo");
//        verbo.add("Canto");
//        verbo.add("Bailo");
//        verbo.add("Actuo");
//        verbo.add("Viajo");
//        verbo.add("Enseño");
//        verbo.add("Entreno");
//        verbo.add("Ataco a");
//        verbo.add("Le mintio a");
//        verbo.add("Escondio el tesoro de");
//        verbo.add("Dibujo a");
//        verbo.add("Comio con");
//        verbo.add("Compuso la obra de");
//        verbo.add("Comio con");
//        nombre.add("Sara");
//        nombre.add("Mateo");
//        nombre.add("Daniel");
//        nombre.add("Pablo");
//        nombre.add("Ezra");
//        nombre.add("Luke");
//        nombre.add("Dante");
//        nombre.add("Evangeline");
//        nombre.add("Mellea");
//        nombre.add("Santiago");
//        nombre.add("Luis");
//        nombre.add("Valeria");
//        nombre.add("Justin");
//        nombre.add("Will");
//        nombre.add("Marco");
//        nombre.add("Paola");
//        nombre.add("Lizeth");
//        nombre.add("Daryl");
//        nombre.add("Michelle");
//        nombre.add("Emily");
//        nombre.add("Anna");
//        nombre.add("Gabriel");
//        nombre.add("Lili");
//        nombre.add("Gabriel");
//        nombre.add("Sakura");
//
//        apellido.add("Smith?");
//        apellido.add("Meneses?");
//        apellido.add("Ospina?");
//        apellido.add("Vander Wall?");
//        apellido.add("Tovar?");
//        apellido.add("Da Vincci?");
//        apellido.add("Cortes?");
//        apellido.add("Un domingo por la noche?");
//        apellido.add("El 11 de septiembre?");
//        apellido.add("Mientras dormia?");
//        apellido.add("Elish?");
//        apellido.add("Triviño?");
//        apellido.add("Angarita?");
//        String pregunta;
//        for (int i = 0; i < numero; i++) {
//
//            int o = (int) (Math.random() * 6);
//            int v = (int) (Math.random() * 19);
//            int n = (int) (Math.random() * 25);
//            int a = (int) (Math.random() * 13);
//            int dificultad = (int) (Math.random() * 10) + 1;
//            int tiempo = (int) (Math.random() * 60) + 1;
//            int tema = (int) (Math.random() * 10) + 1;
//            Date date = Calendar.getInstance().getTime();
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//            String strDate = dateFormat.format(date);
//
//            pregunta = organizadores.get(o) + " " + verbo.get(v) + " "
//                    + nombre.get(n) + " " + apellido.get(a);
//            if (SolicitudGuardar(pregunta, dificultad, tiempo, tema, strDate)) {
//                System.out.println(bien);
//                bien++;
//            } else {
//
//            }
//
////            Pregunta p = new Pregunta(pregunta, dificultad, tiempo, tema, fecha);
////            bancoPreguntas.add(p);
//        }
//        organizadores.retainAll(organizadores);
//        verbo.retainAll(verbo);
//        nombre.retainAll(nombre);
//        apellido.retainAll(apellido);
//    }

    public void eliminarRepetidas(int numero) {
        int cont = 0;
        for (int i = 0; i < bancoPreguntas.size() - 1; i++) {
            for (int j = i + 1; j < bancoPreguntas.size() - 1; j++) {
                if (bancoPreguntas.get(i).getTexto().equals(bancoPreguntas.get(j).getTexto())) {
                    bancoPreguntas.remove(j);
//                    System.out.println(bancoPreguntas.get(i) + " " + bancoPreguntas.get(j));
                    cont++;
                }
            }
        }
        System.out.println("Repetidas:" + cont);
    }

    public void SolicitudListarArrayList() {
        DAOGenerico usuDAO = new DAOGenerico();
        Pregunta p;

        ResultSet resut = usuDAO.listar(tabla);

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

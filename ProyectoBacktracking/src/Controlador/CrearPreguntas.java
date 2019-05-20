/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOGenerico;
import Modelo.ClsConexion;
import Modelo.Pregunta;
import Vista.Matriz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        ResultSet resut = usuDAO.listar(tabla, numPreguntas);

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

    public void OrdenarBurbuja(int inicio) {
        ArrayList<Pregunta> temp = new ArrayList<>();
        int t = bancoPreguntas.size();

        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (inicio == 1) {
                    if (bancoPreguntas.get(k).getDificultad() > bancoPreguntas.get(k - 1).getDificultad()) {
                        temp.add(bancoPreguntas.get(k));
                        bancoPreguntas.set(k, bancoPreguntas.get(k - 1));
                        bancoPreguntas.set(k - 1, temp.get(0));
                        temp.remove(0);
                    }
                } else {
                    if (bancoPreguntas.get(k).getTiempo() < bancoPreguntas.get(k - 1).getTiempo()) {
                        temp.add(bancoPreguntas.get(k));
                        bancoPreguntas.set(k, bancoPreguntas.get(k - 1));
                        bancoPreguntas.set(k - 1, temp.get(0));
                        temp.remove(0);
                    }
                }

            }
        }

    }

    /**
     * Metodo de ordenacion por burbuja bidireccional
     *
     *
     * @param criterio
     */
    public void OrdenarBurbujaBidireccional(int criterio) {

        int izquierda = 1, derecha = bancoPreguntas.size() - 1, ultimo = bancoPreguntas.size() - 1;
        ArrayList<Pregunta> aux = new ArrayList<>();
        if (criterio == 1) {
            do {
                for (int i = bancoPreguntas.size() - 1; i > 0; i--) {
                    //Burbuja hacia la izquierda
                    //Los valores menores van a la izquierda 
                    if (bancoPreguntas.get(i - 1).getDificultad() < bancoPreguntas.get(i).getDificultad()) {
                        // variable auxiliar para poder hacer intercambio de
                        aux.add(bancoPreguntas.get(i));
                        bancoPreguntas.set(i, bancoPreguntas.get(i - 1));// posicion
                        bancoPreguntas.set(i - 1, aux.get(0));
                        aux.remove(0);
                        ultimo = i;

                    }
                }
                izquierda = ultimo + 1;
                for (int j = 1; j < bancoPreguntas.size(); j++) {
                    //Burbuja hacia la derecha
                    //Los valores mayores van a la derecha 
                    if (bancoPreguntas.get(j - 1).getDificultad() < bancoPreguntas.get(j).getDificultad()) {
                        aux.add(bancoPreguntas.get(j));
                        bancoPreguntas.set(j, bancoPreguntas.get(j - 1));// posicion
                        bancoPreguntas.set(j - 1, aux.get(0));
                        aux.remove(0);
                        ultimo = j;
                    }
                }
                derecha = ultimo - 1;
            } while (derecha >= izquierda);
        } else {
            do {
                for (int i = bancoPreguntas.size() - 1; i > 0; i--) {
                    //Burbuja hacia la izquierda
                    //Los valores menores van a la izquierda 
                    if (bancoPreguntas.get(i - 1).getTiempo() > bancoPreguntas.get(i).getTiempo()) {
                        // variable auxiliar para poder hacer intercambio de
                        aux.add(bancoPreguntas.get(i));
                        bancoPreguntas.set(i, bancoPreguntas.get(i - 1));// posicion
                        bancoPreguntas.set(i - 1, aux.get(0));
                        aux.remove(0);
                        ultimo = i;

                    }
                }
                izquierda = ultimo + 1;
                for (int j = 1; j < bancoPreguntas.size(); j++) {
                    //Burbuja hacia la derecha
                    //Los valores mayores van a la derecha 
                    if (bancoPreguntas.get(j - 1).getTiempo() > bancoPreguntas.get(j).getTiempo()) {
                        aux.add(bancoPreguntas.get(j));
                        bancoPreguntas.set(j, bancoPreguntas.get(j - 1));// posicion
                        bancoPreguntas.set(j - 1, aux.get(0));
                        aux.remove(0);
                        ultimo = j;
                    }
                }
                derecha = ultimo - 1;
            } while (derecha >= izquierda);
        }

    }

    /**
     * Metodo de ordenacion de insercion
     *
     */
    public void insertSort(int criterio) {
        ArrayList<Pregunta> aux = new ArrayList<>();
        if (criterio == 1) {
            for (int i = 1; i < bancoPreguntas.size(); i++) {
                aux.add(bancoPreguntas.get(i));
                int j;
                for (j = i - 1; j >= 0 && bancoPreguntas.get(j).getDificultad() < aux.get(0).getDificultad(); j--) {
                    bancoPreguntas.set(j + 1, bancoPreguntas.get(j));
                }
                bancoPreguntas.set(j + 1, aux.get(0));
                aux.remove(0);
            }
        } else {
            for (int i = 1; i < bancoPreguntas.size(); i++) {
                aux.add(bancoPreguntas.get(i));
                int j;
                for (j = i - 1; j >= 0 && bancoPreguntas.get(j).getTiempo() > aux.get(0).getTiempo(); j--) {
                    bancoPreguntas.set(j + 1, bancoPreguntas.get(j));
                }
                bancoPreguntas.set(j + 1, aux.get(0));
                aux.remove(0);

            }
        }

    }

    /**
     * Metodo de ordenamiento Merge Sort
     *
     * @param ls = bancoPreguntas
     * @return ls
     */
    public ArrayList<Pregunta> mergeSort(ArrayList<Pregunta> ls) {
        ArrayList<Pregunta> left = new ArrayList<>();
        ArrayList<Pregunta> right = new ArrayList<>();
        int center;

        if (ls.size() == 1) {
            return ls;
        } else {
            center = ls.size() / 2;
            // copy the left half of whole into the left.
            for (int i = 0; i < center; i++) {
                left.add(ls.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i = center; i < ls.size(); i++) {
                right.add(ls.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left = mergeSort(left);
            right = mergeSort(right);

            // Merge the results back together.
            merge(left, right, ls);
        }
        return ls;
    }

    private void merge(ArrayList<Pregunta> left, ArrayList<Pregunta> right, ArrayList<Pregunta> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getDificultad()) > (right.get(rightIndex).getDificultad())) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Pregunta> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }

    /**
     * Metodo de ordenamiento Seleccion
     *
     */
    public void selecccion(int criterio) {
        ArrayList<Pregunta> aux = new ArrayList<>();
        if (criterio == 1) {
            for (int i = 0; i < bancoPreguntas.size() - 1; i++) {
                int min = i;
                for (int j = i + 1; j < bancoPreguntas.size(); j++) {
                    if (bancoPreguntas.get(j).getDificultad() > bancoPreguntas.get(min).getDificultad()) {
                        min = j;
                    }
                }
                if (i != min) {
                    aux.add(bancoPreguntas.get(i));
                    bancoPreguntas.set(i, bancoPreguntas.get(min));
                    bancoPreguntas.set(min, aux.get(0));
                    aux.remove(0);
                }
            }
        } else {
            for (int i = 0; i < bancoPreguntas.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < bancoPreguntas.size(); j++) {
                if (bancoPreguntas.get(j).getTiempo() < bancoPreguntas.get(min).getTiempo()) {
                    min = j;
                }
            }
            if (i != min) {
                aux.add(bancoPreguntas.get(i));
                bancoPreguntas.set(i, bancoPreguntas.get(min));
                bancoPreguntas.set(min, aux.get(0));
                aux.remove(0);
            }
        }
        }

    }

    /**
     * Metodo de ordenamiento QuickSort
     *
     * @param lista
     * @param primero = 0
     * @param ultimo = bancoPreguntas.size -1
     */
    public void ordenarQuicksortDificultad(ArrayList<Pregunta> lista, int primero, int ultimo) {
        ArrayList<Pregunta> piv = new ArrayList<>();
        ArrayList<Pregunta> aux = new ArrayList<>();
        int i = primero, j = ultimo;
        piv.add(lista.get((primero + ultimo) / 2));

        do {
            while (lista.get(i).getDificultad() > piv.get(0).getDificultad()) {
                i++;
            }
            while (lista.get(j).getDificultad() < piv.get(0).getDificultad()) {
                j--;
            }

            if (i <= j) {
                aux.add(lista.get(j));
                lista.set(j, lista.get(i));
                lista.set(i, aux.get(0));
                i++;
                j--;
                aux.remove(0);
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksortDificultad(lista, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksortDificultad(lista, i, ultimo);
        }

        //return arregloDesorden;
    }

   

    /**
     * Metodo de ordenamiento QuickSort
     *
     * @param lista
     * @param primero = 0
     * @param ultimo = bancoPreguntas.size -1
     */
    public void ordenarQuicksortTiempo(ArrayList<Pregunta> lista, int primero, int ultimo) {
        ArrayList<Pregunta> piv = new ArrayList<>();
        ArrayList<Pregunta> aux = new ArrayList<>();
        int i = primero, j = ultimo;
        piv.add(lista.get((primero + ultimo) / 2));

        do {
            while (lista.get(i).getTiempo() < piv.get(0).getTiempo()) {
                i++;
            }
            while (lista.get(j).getTiempo() > piv.get(0).getTiempo()) {
                j--;
            }

            if (i <= j) {
                aux.add(lista.get(j));
                lista.set(j, lista.get(i));
                lista.set(i, aux.get(0));
                i++;
                j--;
                aux.remove(0);
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksortDificultad(lista, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksortDificultad(lista, i, ultimo);
        }

        //return arregloDesorden;
    }
    
    // ----------- Con arreglos --------------  

    public static int[] OrdenarBurbuja(int[] arregloDesorden) {
        int temp;
        int t = arregloDesorden.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (arregloDesorden[k] < arregloDesorden[k - 1]) {
                    temp = arregloDesorden[k];
                    arregloDesorden[k] = arregloDesorden[k - 1];
                    arregloDesorden[k - 1] = temp;
                }
            }
        }
        return arregloDesorden;
    }

    /**
     * Metodo de ordenacion por burbuja bidireccional
     *
     * @param arregloDesorden
     * @return
     */
    public static int[] OrdenarBurbujaBidireccional(int[] arregloDesorden) {

        int izquierda = 1, derecha = arregloDesorden.length - 1, ultimo = arregloDesorden.length - 1;

        do {
            for (int i = arregloDesorden.length - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (arregloDesorden[i - 1] > arregloDesorden[i]) {
                    int aux = arregloDesorden[i]; // variable auxiliar para poder hacer intercambio de
                    arregloDesorden[i] = arregloDesorden[i - 1];  // posicion
                    arregloDesorden[i - 1] = aux;
                    ultimo = i;
                }
            }
            izquierda = ultimo + 1;
            for (int j = 1; j < arregloDesorden.length; j++) {
                //Burbuja hacia la derecha
                //Los valores mayores van a la derecha 
                if (arregloDesorden[j - 1] > arregloDesorden[j]) {
                    int aux = arregloDesorden[j];
                    arregloDesorden[j] = arregloDesorden[j - 1];
                    arregloDesorden[j - 1] = aux;
                    ultimo = j;
                }
            }
            derecha = ultimo - 1;
        } while (derecha >= izquierda);

        return arregloDesorden;

    }

    /**
     * Metodo de ordenacion de insercion
     *
     * @param arregloDesorden
     */
    public static int[] insertSort(int[] arregloDesorden) {
        for (int i = 1; i < arregloDesorden.length; i++) {
            int aux = arregloDesorden[i];
            int j;
            for (j = i - 1; j >= 0 && arregloDesorden[j] > aux; j--) {
                arregloDesorden[j + 1] = arregloDesorden[j];
            }
            arregloDesorden[j + 1] = aux;
        }

        return arregloDesorden;
    }

    public static int[] mergeSort(int[] arregloDesorden) {
        //buscarlo
        return null;
    }

    /**
     * Metodo de ordenamiento Seleccion
     *
     * @param arregloDesorden
     * @return
     */
    public static int[] selecccion(int[] arregloDesorden) {
        for (int i = 0; i < arregloDesorden.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arregloDesorden.length; j++) {
                if (arregloDesorden[j] < arregloDesorden[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int aux = arregloDesorden[i];
                arregloDesorden[i] = arregloDesorden[min];
                arregloDesorden[min] = aux;
            }
        }
        return arregloDesorden;
    }

    public static void ordenarQuicksort(int[] arregloDesorden, int primero, int ultimo) {
        int i = primero, j = ultimo;
        int pivote = arregloDesorden[(primero + ultimo) / 2];
        int auxiliar;

        do {
            while (arregloDesorden[i] < pivote) {
                i++;
            }
            while (arregloDesorden[j] > pivote) {
                j--;
            }

            if (i <= j) {
                auxiliar = arregloDesorden[j];
                arregloDesorden[j] = arregloDesorden[i];
                arregloDesorden[i] = auxiliar;
                i++;
                j--;
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksort(arregloDesorden, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksort(arregloDesorden, i, ultimo);
        }

        //return arregloDesorden;
    }

}

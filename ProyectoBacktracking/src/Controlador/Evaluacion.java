/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Examen;
import Modelo.Pregunta;
import Vista.FrmPreguntas;
import Vista.Matriz;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian
 */
public class Evaluacion {
// Se declaran variables a usar 

    private Examen salon[][];
    private ArrayList<Examen> examenes;
    private int filas;
    private int columnas;
    private int numPreguntas;
    private Examen examen;
    private ArrayList<Pregunta> bancoPreguntas;
    private ArrayList<Pregunta> preguntas;

//  Se crea constructor de la clase en el cual se le da valores a las variables y se instancian los arreglos 
    /**
     *
     * @param filas que contiene la matriz
     * @param columnas que contiene la matriz
     * @param numPreguntas que contiene el examen
     * @param bancoPreguntas Arraylist de preguntas
     */
    public Evaluacion(int filas, int columnas, int numPreguntas, ArrayList<Pregunta> bancoPreguntas) {
//      Se instancia el arreglo 
        salon = new Examen[filas][columnas];
        examenes = new ArrayList<>();
        preguntas = new ArrayList<>();
        examen = new Examen(preguntas);
//      Se llena la matriz con (-) guiones para validar despues donde falten valores
//        for (int i = 0; i < filas; i++) {
//            for (int j = 0; j < columnas; j++) {
//                Examen ex = new Examen(numPreguntas, 5, 5, 5, null);
//                salon[i][j] = ex;
//            }
//        }
//      Se le da valor a las variables y se instancia el arraylist que contiene las preguntas
        this.filas = filas;
        this.columnas = columnas;
        this.numPreguntas = numPreguntas;
        this.bancoPreguntas = bancoPreguntas;
    }

    /**
     * Metodo backtranking recursivo que se encarga de asignar n pregunta a cada
     * examen validando una por una
     *
     * @param fila
     * @param col
     * @param posPregunta
     * @return boolean
     */
    public boolean aux;

    public boolean asignarExamen(int fila, int col, int posPregunta) {
        try {
            if (fila == filas) {
                return true;
            }

            for (int preguntaActual = 0; preguntaActual < bancoPreguntas.size(); preguntaActual++) {
                if (validarPregunta(fila, col, bancoPreguntas.get(preguntaActual).getTexto(), posPregunta, preguntas)) {
                    preguntas.add(bancoPreguntas.get(preguntaActual));
                    if (preguntas.size() < numPreguntas) {
                        aux = asignarExamen(fila, col, posPregunta + 1);
                    } else if (preguntas.size() == numPreguntas) {
                        Examen ex = new Examen(numPreguntas, 5, 5, 5, preguntas);
                        salon[fila][col] = ex;
//                    salon[fila][col].getListaPreguntas().get(0).getTema_id();
                        preguntas = new ArrayList<>();
//                    salon[fila][col].getListaPreguntas().get(1).getTexto();
                        if (col == salon[0].length - 1) {
                            aux = asignarExamen(fila + 1, 0, 0);
                        } else {
                            aux = asignarExamen(fila, col + 1, 0);
                        }
                    }
                }
                if (aux) {
                return true;
            }
            }
             return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param fila en la que se esta evalauando esa pregunta que se pueda
     * asignar a ese examen
     * @param columna en la que se esta evalauando esa pregunta que se pueda
     * asignar a ese examen
     * @param pregunta pregunta que se va a validar
     * @param posActual actual posicion de una pregunta asignar
     * @return boolean
     */
    private boolean validarPregunta(int fila, int columna, String pregunta, int posActual, ArrayList<Pregunta> lista) {
//  Accede cuando sea la primera fila
        try {
            if (fila == 0) {
//  Al ser el primer ingreso cualquier ingreso es totalmente valido      
                if (columna == 0 && posActual == 0) {
                    return true;
//  Se valida que no se repita en ese primer examen 
                } else if (columna == 0 && posActual > 0) {
                    if (posActual > 0) {
                        for (int j = posActual - 1; j > -1; j--) {
                            if (lista.get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
//                        if (salon[fila][columna].getListaPreguntas().get(j).getTexto().equalsIgnoreCase(pregunta)) {
//                            return false;
//                        }
                        }
                    }
                } else if (columna > 0) {
//  Se crea un for para recorrer las preguntas de ese examen y que no esten en uno cercano             
                    for (int i = 0; i < numPreguntas; i++) {
//  Se valida que ninguna pregunta este al lado y que no tenga en su mismo examen preguntas de otros alumnos                 
                        if (salon[fila][columna - 1].getListaPreguntas().get(i).getTexto().equalsIgnoreCase(pregunta)) {
                            return false;
                        }
                    }
                    if (posActual > 0) {
                        for (int j = posActual - 1; j > -1; j--) {
                            // Por aqui 4 vez
                            if (lista.get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                }
                // la del inicio pero en filas mayores
//  Se valida que fila mayor a la actual no cuente con examenes iguales           
            } else if (fila > 0) {
//  Se valida que columnas de ultima posicion no tengas examenes iguales          
                if (columna == 0) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < numPreguntas; j++) {
                            if (salon[fila - 1][i].getListaPreguntas().get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                    if (posActual > 0) {
                        for (int z = posActual - 1; z > -1; z--) {
                            if (lista.get(z).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }

                } else if (columna > 0 && columna < columnas - 1) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < numPreguntas; j++) {
                            if (salon[fila - 1][i].getListaPreguntas().get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < numPreguntas; i++) {
                        if (salon[fila][columna - 1].getListaPreguntas().get(i).getTexto().equalsIgnoreCase(pregunta)) {
                            return false;
                        }
                    }
                    if (posActual > 0) {
                        for (int j = posActual - 1; j > -1; j--) {
                            if (lista.get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                } else if (columna == columnas - 1) {

                    for (int i = columna - 1; i <= columna; i++) {
                        for (int j = 0; j < numPreguntas; j++) {
                            if (salon[fila - 1][i].getListaPreguntas().get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < numPreguntas; i++) {
                        if (salon[fila][columna - 1].getListaPreguntas().get(i).getTexto().equalsIgnoreCase(pregunta)) {
                            return false;
                        }
                    }
                    if (posActual > 0) {
                        for (int j = posActual - 1; j > -1; j--) {
                            if (lista.get(j).getTexto().equalsIgnoreCase(pregunta)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que muestra si en la matriz existe algun examen sin asignarle una
     * pregunta
     *
     * @return String valor
     */
    public String mostrar() {
        String valor = null;
        for (int i = 0; i < salon.length; i++) {
            for (int j = 0; j < salon[0].length; j++) {
                for (int k = 0; k < salon[0][0].getListaPreguntas().size(); k++) {
//                    System.out.print("[" + tablero[i][j][k] + "]");
                    if (salon[i][j].getListaPreguntas().get(k).equals(null)) {
                        valor = "Si";
                    } else {
                        valor = "No";
                    }
                }
            }
        }
        return valor;
    }

    /**
     * Metodo que se encarga de listar todos los examenes del salon
     */
    public void listar() {
        DefaultTableModel model = (DefaultTableModel) Matriz.tblExamenes.getModel();
        model.setRowCount(filas);
        model.setColumnCount(columnas);
        int contador = 1;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                Matriz.tblExamenes.setValueAt("Examen " + contador, i, j);
                contador++;

            }

            System.out.println("");
        }

    }

    /**
     * Metodo que valida que no se salga de la matriz y de la cantidad de
     * preguntas por examen
     *
     * @param fila que se selecciono
     * @param colum que se selecciono
     * @param posicion de la pregunta selecionada
     * @return boolean que especifica que es valida o no esa posicion
     */
    public boolean validar(int fila, int colum, int posicion) {
        try {
            String hola = salon[fila][colum].getListaPreguntas().get(0).getTexto();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que valida que no se salga de la matriz
     *
     * @param fila que se selecciono
     * @param colum que se selecciono
     * @return boolean que especifica que es valida o no esa posicion
     */
    public boolean validarPos(int fila, int colum) {
        try {
            int hola = salon[fila][colum].getCantPreguntas();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param fila Que se selecciona
     * @param colum Que se selecciona
     * @param numPreguntas Cantidad preguntas examen
     * @throws ArrayIndexOutOfBoundsException
     */
    public void mostrarAlrededor(int fila, int colum, int numPreguntas) throws ArrayIndexOutOfBoundsException {

        String resultado = "";

        if (validarPos(fila, colum)) {
            resultado += "Examen Seleccionado: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {

                resultado += "P" + (i + 1) + ":" + salon[fila][colum].getListaPreguntas().get(i).getTexto() + "\n";

            }
        }

        FrmPreguntas.txtExamenActual.setText(resultado);
        resultado = "";

        //Examen Diagonal Superior Izquierda
        if (validarPos(fila - 1, colum - 1)) {
            resultado += "Diagonal Superior Izquierda\n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila - 1, colum - 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila - 1][colum - 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila - 1, colum - 1);
            FrmPreguntas.txtDiagSuperIz.setText(resultado);
        }
//      Examen Superior
        resultado = "";
        if (validarPos(fila - 1, colum)) {
            resultado += "Examen Superior: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila - 1, colum, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila - 1][colum].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila - 1, colum);
            FrmPreguntas.txtSuperior.setText(resultado);
        }
        //Examen Diagonal Superior Derecha
        resultado = "";
        if (validarPos(fila - 1, colum + 1)) {
            resultado += "Examen Diagonal Superior Derecho: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila - 1, colum + 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila - 1][colum + 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila - 1, colum + 1);
            FrmPreguntas.txtDiagSupDere.setText(resultado);
        }
        //Examen a la Izquierda
        resultado = "";
        if (validarPos(fila, colum - 1)) {
            resultado += "Examen Izquierda: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila, colum - 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila][colum - 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila, colum - 1);
            FrmPreguntas.txtIzquier.setText(resultado);
        }
        //Examen a la Derecha
        resultado = "";
        if (validarPos(fila, colum + 1)) {
            resultado += "Examen Derecha: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila, colum + 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila][colum + 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila, colum + 1);
            FrmPreguntas.txtDerecha.setText(resultado);
        }
        //Examen Diagonal Inferior Izquierda
        resultado = "";
        if (validarPos(fila + 1, colum - 1)) {
            resultado += "Examen Diagonal Inferior Izquierda: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila + 1, colum - 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila + 1][colum - 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila + 1, colum - 1);
            FrmPreguntas.txtDiagInfeIzquier.setText(resultado);
        }

        //Examen Abajo
        resultado = "";
        if (validarPos(fila + 1, colum)) {
            resultado += "Examen Abajo: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila + 1, colum, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila + 1][colum].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }

            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila + 1, colum);
            FrmPreguntas.txtAbajo.setText(resultado);
        }

        resultado = "";
        //Examen Diagonal Inferior Derecha
        if (validarPos(fila + 1, colum + 1)) {
            resultado += "Examen Diagonal inferior Derecha: \n";
            for (int i = 0; i <= numPreguntas - 1; i++) {
                if (validar(fila + 1, colum + 1, i)) {
                    resultado += "P" + (i + 1) + ":" + salon[fila + 1][colum + 1].getListaPreguntas().get(i).getTexto() + "\n";
                } else {
                    resultado += "";
                    break;
                }
            }
//            Matriz.tblExamenes1.setValueAt(resultado, fila + 1, colum + 1);
            FrmPreguntas.txtDiagInfeDere.setText(resultado);
        }
    }

    // ------------------------ Seccion de ORDENAMIENTO ------------------------
    // Seccion Ordenamiento
    /**
     * Metodo de ordenación por burbuja
     *
     */
    public void OrdenarBurbujaDificultad() {
        ArrayList<Pregunta> temp = new ArrayList<>();
        int t = bancoPreguntas.size();
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (bancoPreguntas.get(k).getDificultad() < bancoPreguntas.get(k - 1).getDificultad()) {
                    temp.add(bancoPreguntas.get(k));
                    bancoPreguntas.set(k, bancoPreguntas.get(k - 1));
                    bancoPreguntas.set(k - 1, temp.get(0));
                    temp.remove(0);
                }
            }
        }
    }

    /**
     * Metodo de ordenacion por burbuja bidireccional
     *
     *
     */
    public void OrdenarBurbujaBidireccionalDificultad() {

        int izquierda = 1, derecha = bancoPreguntas.size() - 1, ultimo = bancoPreguntas.size() - 1;
        ArrayList<Pregunta> aux = new ArrayList<>();
        do {
            for (int i = bancoPreguntas.size() - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (bancoPreguntas.get(i - 1).getDificultad() > bancoPreguntas.get(i).getDificultad()) {
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
                if (bancoPreguntas.get(j - 1).getDificultad() > bancoPreguntas.get(j).getDificultad()) {
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

    /**
     * Metodo de ordenacion de insercion
     *
     */
    public void insertSortDificultad() {
        ArrayList<Pregunta> aux = new ArrayList<>();
        for (int i = 1; i < bancoPreguntas.size(); i++) {
            aux.add(bancoPreguntas.get(i));
            int j;
            for (j = i - 1; j >= 0 && bancoPreguntas.get(j).getDificultad() > aux.get(0).getDificultad(); j--) {
                bancoPreguntas.set(j + 1, bancoPreguntas.get(j));
            }
            bancoPreguntas.set(j + 1, aux.get(0));
            aux.remove(0);
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
            if ((left.get(leftIndex).getTexto()).compareTo(right.get(rightIndex).getTexto()) < 0) {
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
    public void selecccionDificultad() {
        ArrayList<Pregunta> aux = new ArrayList<>();
        for (int i = 0; i < bancoPreguntas.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < bancoPreguntas.size(); j++) {
                if (bancoPreguntas.get(j).getDificultad() < bancoPreguntas.get(min).getDificultad()) {
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
            while (lista.get(i).getDificultad() < piv.get(0).getDificultad()) {
                i++;
            }
            while (lista.get(j).getDificultad() > piv.get(0).getDificultad()) {
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

    public void mostrarLista() {
        insertSortDificultad();
        for (int i = 0; i < bancoPreguntas.size(); i++) {
            System.out.println(bancoPreguntas.get(i).getTexto() + " " + bancoPreguntas.get(i).getDificultad());
        }
    }

    // ORDENAR POR TIEMPO
    public void OrdenarBurbujaTiempo() {
        ArrayList<Pregunta> temp = new ArrayList<>();
        int t = bancoPreguntas.size();
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (bancoPreguntas.get(k).getTiempo() < bancoPreguntas.get(k - 1).getTiempo()) {
                    temp.add(bancoPreguntas.get(k));
                    bancoPreguntas.set(k, bancoPreguntas.get(k - 1));
                    bancoPreguntas.set(k - 1, temp.get(0));
                    temp.remove(0);
                }
            }
        }
    }

    /**
     * Metodo de ordenacion por burbuja bidireccional
     *
     *
     */
    public void OrdenarBurbujaBidireccionalTiempo() {

        int izquierda = 1, derecha = bancoPreguntas.size() - 1, ultimo = bancoPreguntas.size() - 1;
        ArrayList<Pregunta> aux = new ArrayList<>();
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

    /**
     * Metodo de ordenacion de insercion
     *
     */
    public void insertSortTiempo() {
        ArrayList<Pregunta> aux = new ArrayList<>();
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

    /**
     * Metodo de ordenamiento Seleccion
     *
     */
    public void selecccionTiempo() {
        ArrayList<Pregunta> aux = new ArrayList<>();
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

    // Ordenamientos en arreglos 
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

    public double[] llenarContainer(int pesoMax, int tipo) {
        double[] aux = new double[bancoPreguntas.size()];
        int parcial = 0;
        int i = 0;
        double k;

        // Mientras hayan objetos 
        while (parcial < pesoMax && i < bancoPreguntas.size()) {
            //busca el primer posible objeto
            while (i < bancoPreguntas.size() && (parcial + bancoPreguntas.get(i).getPeso()) > pesoMax && bancoPreguntas.get(i).getValor() > 0) {
                i++;
            }
            //en caso de encontrar un objeto
            if (i < bancoPreguntas.size()) {
                //Determina la cantidad de objetos que necesesitaria
                k = (pesoMax - parcial) / bancoPreguntas.get(i).getDificultad();
                //en caso de que exista la cantidad 
                if (k > bancoPreguntas.get(i).get) {
                    //se agrega al auxiliar la cantidad de los productos
                    k = bancoPreguntas.get(i).getCantidad();
                }
                // asignacion de 
                aux[i] += k;
                //se suma el valor el peso total del container
                parcial += bancoPreguntas.get(i).getPeso() * k;
            } else {
                // en caso de no encontrar mas objetos 
                parcial = pesoMax;
            }
            //iterador
            i++;
        }
        return aux;
    }

    //utilizar en caso de error
    public double[] llenarContiner(int pesoMax, int tipo) {
        double[] aux = new double[bancoPreguntas.size()];
        int parcial = 0;
        int i = 0;
        double k;

        // Mientras hayan objetos 
        while (parcial < pesoMax && i < bancoPreguntas.size()) {
            //busca el primer posible objeto
            while (i < bancoPreguntas.size() && (parcial + (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor())) > pesoMax && listaObjetos.get(i).getValor() > 0) {
                i++;
            }
            //en caso de encontrar un objeto
            if (i < listaObjetos.size()) {
                //Determina la cantidad de objetos que necesesitaria
                k = (pesoMax - parcial) / (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor());
                //en caso de que exista la cantidad 
                if (k > bancoPreguntas.get(i).getCantidad()) {
                    //se al auxiliar la cantidad de los productos
                    k = bancoPreguntas.get(i).getCantidad();
                }
                // asignacion de 
                aux[i] += k;
                //se suma el valor el peso total del container
                parcial += (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor()) * k;
            } else {
                // en caso de no encontrar mas objetos 
                parcial = pesoMax;
            }
            //iterador
            i++;
        }
        return aux;
    }

}

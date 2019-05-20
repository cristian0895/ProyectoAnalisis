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
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
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
   
    // Ordenamientos en arreglos 
    

//    public double[] llenarContainer(int pesoMax, int tipo) {
//        double[] aux = new double[bancoPreguntas.size()];
//        int parcial = 0;
//        int i = 0;
//        double k;
//
//        // Mientras hayan objetos 
//        while (parcial < pesoMax && i < bancoPreguntas.size()) {
//            //busca el primer posible objeto
//            while (i < bancoPreguntas.size() && (parcial + bancoPreguntas.get(i).getPeso()) > pesoMax && bancoPreguntas.get(i).getValor() > 0) {
//                i++;
//            }
//            //en caso de encontrar un objeto
//            if (i < bancoPreguntas.size()) {
//                //Determina la cantidad de objetos que necesesitaria
//                k = (pesoMax - parcial) / bancoPreguntas.get(i).getDificultad();
//                //en caso de que exista la cantidad 
//                if (k > bancoPreguntas.get(i).get) {
//                    //se agrega al auxiliar la cantidad de los productos
//                    k = bancoPreguntas.get(i).getCantidad();
//                }
//                // asignacion de 
//                aux[i] += k;
//                //se suma el valor el peso total del container
//                parcial += bancoPreguntas.get(i).getPeso() * k;
//            } else {
//                // en caso de no encontrar mas objetos 
//                parcial = pesoMax;
//            }
//            //iterador
//            i++;
//        }
//        return aux;
//    }
    //utilizar en caso de error
//    public double[] llenarContiner(int pesoMax, int tipo) {
//        double[] aux = new double[bancoPreguntas.size()];
//        int parcial = 0;
//        int i = 0;
//        double k;
//
//        // Mientras hayan objetos 
//        while (parcial < pesoMax && i < bancoPreguntas.size()) {
//            //busca el primer posible objeto
//            while (i < bancoPreguntas.size() && (parcial + (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor())) > pesoMax && listaObjetos.get(i).getValor() > 0) {
//                i++;
//            }
//            //en caso de encontrar un objeto
//            if (i < listaObjetos.size()) {
//                //Determina la cantidad de objetos que necesesitaria
//                k = (pesoMax - parcial) / (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor());
//                //en caso de que exista la cantidad 
//                if (k > bancoPreguntas.get(i).getCantidad()) {
//                    //se al auxiliar la cantidad de los productos
//                    k = bancoPreguntas.get(i).getCantidad();
//                }
//                // asignacion de 
//                aux[i] += k;
//                //se suma el valor el peso total del container
//                parcial += (tipo == 1 ? bancoPreguntas.get(i).getPeso() : bancoPreguntas.get(i).getValor()) * k;
//            } else {
//                // en caso de no encontrar mas objetos 
//                parcial = pesoMax;
//            }
//            //iterador
//            i++;
//        }
//        return aux;
//    }
//    Metodos de creacion 
    public void crearenPilar(int cantidadPregunta) throws InterruptedException {
        long inicio = System.nanoTime();
        Stack<Pregunta> pila = new Stack<Pregunta>();

        for (int i = 0; i < cantidadPregunta; i++) {

            pila.push(bancoPreguntas.get(i));
        }

        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "Pila Nanosegundos");

//        while (!pila.isEmpty()) { // mostrar pila completa
//            System.out.println(pila.pop().getTitulo()); // extrae un elemento de la pila
//        }
    }

    public void crearenArray(int cantidadPregunta) {
        long inicio = System.nanoTime();
        Pregunta[] array = new Pregunta[cantidadPregunta];
        for (int i = 0; i < cantidadPregunta; i++) {
            array[i] = bancoPreguntas.get(i);
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "Array  Nanosegundos");
    }

    public void crearenArrayList(int cantidadPregunta) {
        long inicio = System.nanoTime();
        ArrayList<Pregunta> pregun = new ArrayList<>();
        for (int i = 0; i < cantidadPregunta; i++) {
            pregun.add(bancoPreguntas.get(i));
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "ArrayList  Nanosegundos");
    }

    public void crearenArbol(int cantidadPregunta) {
        TreeSet<String> treeSet = new TreeSet<>();
        long inicio = System.nanoTime();
        for (int i = 0; i < cantidadPregunta; i++) {
            treeSet.add(bancoPreguntas.get(i).getTexto());
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "Arbol  Nanosegundos");
    }
//  Busqueda en los diferentes tipos de datos

    public Pregunta busquedaenPila(int cantidadPregunta, String id) {
        long inicio = System.nanoTime();
        Pregunta pregunta = null;
        Stack<Pregunta> pila = new Stack<Pregunta>();

        for (int i = 0; i < cantidadPregunta; i++) {

            pila.push(bancoPreguntas.get(i));
        }
        while (!pila.isEmpty()) { // mostrar pila completa
            if (pila.pop().getTexto().equals(id)) {
                pregunta = new Pregunta(pila.pop().getTexto(), pila.pop().getDificultad(), pila.pop().getTiempo(), pila.pop().getTema_id(), pila.pop().getFECHA_CREACION());
                break;
            }
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;
        System.out.println(tiempo + "Busqueda Pila Nanosegundos");

        return pregunta;
    }

    public Pregunta busquedaenArray(int cantidadPregunta, String id) {
        long inicio = System.nanoTime();
        Pregunta pregun = null;
        Pregunta[] array = new Pregunta[cantidadPregunta];
        for (int i = 0; i < cantidadPregunta; i++) {
            array[i] = bancoPreguntas.get(i);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].getTexto().equals(id)) {
                pregun = new Pregunta(array[i].getTexto(), array[i].getTiempo(), array[i].getTiempo(), array[i].getTema_id(), array[i].getFECHA_CREACION());
            }
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "Busqueda Array  Nanosegundos");

        return pregun;
    }

    public Pregunta busquedaenArrayList(int cantidadPregunta, String id) {
        long inicio = System.nanoTime();
        Pregunta preg = null;
        ArrayList<Pregunta> pregun = new ArrayList<>();
        for (int i = 0; i < cantidadPregunta; i++) {
            pregun.add(bancoPreguntas.get(i));
        }
        for (int i = 0; i < pregun.size(); i++) {
            if (pregun.get(i).getTexto().equals(id)) {
                preg = new Pregunta(pregun.get(i).getTexto(), pregun.get(i).getDificultad(), pregun.get(i).getTiempo(), pregun.get(i).getTema_id(), pregun.get(i).getFECHA_CREACION());
    //utilizar en caso de error
            }
        }
        long fin = System.nanoTime();
//
        long tiempo = fin - inicio;

        System.out.println(tiempo + " Busqueda ArrayList  Nanosegundos");

        return preg;
    }
    public double[] llenarContiner(int pesoMax, int tipo) {
        double[] aux = new double[bancoPreguntas.size()];
        int parcial = 0;
        int i = 0;
        double k;

        // Mientras hayan objetos 
        while (parcial < pesoMax && i < bancoPreguntas.size()) {
            //busca el primer posible objeto
            while (i < bancoPreguntas.size() && (parcial + (tipo == 1 ? bancoPreguntas.get(i).getDificultad() : bancoPreguntas.get(i).getTiempo())) 
                    > pesoMax && bancoPreguntas.get(i).getTiempo()> 0) {
                i++;
            }
            //en caso de encontrar un objeto
            if (i < bancoPreguntas.size()) {
                //Determina la cantidad de objetos que necesesitaria
                k = (pesoMax - parcial) / (tipo == 1 ? bancoPreguntas.get(i).getDificultad(): bancoPreguntas.get(i).getTiempo());
                //en caso de que exista la cantidad 
                
                // asignacion de 
                aux[i] += k;
                //se suma el valor el peso total del container
                parcial += (tipo == 1 ? bancoPreguntas.get(i).getDificultad(): bancoPreguntas.get(i).getTiempo()) * k;
            } else {
                // en caso de no encontrar mas objetos 
                parcial = pesoMax;
            }
        }
//        
    }
    /**
     * 
     * @param 
     * @param id por el cual se busca
     * @return 
     */
    public Pregunta busquedaenArbol(int cantidadPregunta, String id) {
        TreeSet<Pregunta> treeSet = new TreeSet<>();
        Pregunta pregu = null;
        long inicio = System.nanoTime();
        for (int i = 0; i < cantidadPregunta; i++) {
            treeSet.add(bancoPreguntas.get(i));
        }
        for (Iterator it = treeSet.iterator(); it.hasNext();) {
            Pregunta pregunta = (Pregunta) it.next();
            if(pregunta.getTexto().equalsIgnoreCase(id)){
                pregu = new Pregunta(pregunta.getTexto(), pregunta.getDificultad(), pregunta.getTiempo(), pregunta.getTema_id(), pregunta.getFECHA_CREACION());
            }
        }
        long fin = System.nanoTime();

        long tiempo = fin - inicio;

        System.out.println(tiempo + "Busqueda Arbol  Nanosegundos");
        
        return pregu;
    }
}



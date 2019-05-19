/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class ClsConexion {
    
    protected String driver = "oracle.jdbc.OracleDriver"; //nombre del driver
    protected String connectString = "jdbc:oracle:thin:@localhost:1521:XE"; //ubicacion de la base de datos, para postgres esta es por defecto
    protected String user = "Analisis"; //usuario de la base de datos
    protected String password = "1234"; //password de la base de datos
    protected Connection conexionDB; // variable que permite la conexion
    protected Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    protected ResultSet resultadoDB;//almacena el resultado de una consulta

    /**
     * Permite la conexion de la base de datos
    */
    public void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la conexion de la base de datos
     */
    public void desconectar() {
        try {
            //sentenciaSQL.close();//cierra la consulta
            conexionDB.close();//cierra conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            conectar();
            sentenciaSQL.executeUpdate(sentencia);
            desconectar();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);
            
//            desconectar();
        } catch (Exception e) {

        }
    }

}



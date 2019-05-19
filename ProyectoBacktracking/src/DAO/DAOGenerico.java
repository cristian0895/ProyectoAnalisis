/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsConexion;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author HP
 */
public class DAOGenerico extends ClsConexion{
    
     public boolean guardar(String objeto, String tabla) {

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();

        for (int i = 0; i < listCampos.size(); i++) {
            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }
        for (int i = 0; i < listValores.size(); i++) {

        }
        String consulta = "insert into " + tabla + "(";
        Iterator<String> itrCampos = listCampos.iterator();

        while (itrCampos.hasNext()) {
            Object atributo = itrCampos.next();
            consulta = consulta + "" + atributo.toString().toLowerCase();
            if (itrCampos.hasNext()) {
                consulta = consulta + ",";
            } else {
                consulta = consulta + ") values (";
            }

        }
        Iterator<String> itrValores = listValores.iterator();
        while (itrValores.hasNext()) {
            Object valor = itrValores.next();

            consulta = consulta + "'" + valor;

            if (itrValores.hasNext()) {
                consulta = consulta + "',";
            } else {
                consulta = consulta + "')";
            }

        }
        

        return super.ejecutar(consulta);
    }
     
     public ResultSet listar(String tabla, int numPreguntas) {
        String consulta = "select * from " + tabla + " where ROWNUM <= " + numPreguntas;
        super.ejecutarRetorno(consulta);
        return resultadoDB;
    }
    
      public String asignar(String objeto, String tabla, String donde, int llave) {
        String consulta = "select " + objeto + " from " + tabla + " where " + donde + "=" + llave;
        String cosa = null;
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                cosa = resultadoDB.getString(objeto);
            }
        } catch (Exception e) {
        }

        return cosa;
    }
      
            public int asignar2(String objeto, String tabla, String donde, int llave) {
        String consulta = "select " + objeto + " from " + tabla + " where " + donde + "=" + llave;
        int cosa = 0;
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                cosa = resultadoDB.getInt(objeto);
            }
        } catch (Exception e) {
        }

        return cosa;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.codesoftware.logica.administracion;

import com.co.codesoftware.interfaces.HibernateSesionInterface;
import com.co.codesoftware.persistencia.entidades.administracion.SocioEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author John
 */
public class SocioLogica implements AutoCloseable, HibernateSesionInterface {

    private Session sesion;
    private Transaction tx;

    /**
     * metodo que inserta un socio a la base de datos
     *
     * @param entidad
     * @return
     */
    public String insertarSocio(SocioEntity entidad) {
        String respuesta = "Error";
        try {
            initOperation(sesion, tx);
            sesion.save(entidad);
            respuesta = "OK";
        } catch (Exception e) {
            respuesta += e.getMessage();
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public void close() throws Exception {
        if (tx != null) {
            tx.commit();
        }
        if (sesion != null) {
            sesion.close();
        }
    }

}

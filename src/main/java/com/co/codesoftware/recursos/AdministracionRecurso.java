/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.codesoftware.recursos;

import com.co.codesoftware.logica.administracion.SocioLogica;
import com.co.codesoftware.persistencia.entidades.administracion.SocioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author John
 */
@Path("/admin")
@Produces("application/json")
public class AdministracionRecurso {

    /**
     * funcion que inserta un socio a la base de datos
     *
     * @param socio
     * @return
     */
    @POST
    @Path("/socio/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertarSocio(SocioEntity socio) {
        String respuesta = "";
        try (SocioLogica logica = new SocioLogica()) {
            respuesta = logica.insertarSocio(socio);
        } catch (Exception e) {
            respuesta = e.getMessage();
            e.printStackTrace();
        }
        return respuesta;
    }

    /**
     * metodo que consulta todos los socios
     *
     * @return
     */
    @POST
    @Path("/socio/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SocioEntity> obtenerSocios() {
        List<SocioEntity> respuesta = new ArrayList<>();
        try (SocioLogica logica = new SocioLogica()) {
            respuesta = logica.consultaSocios();
            respuesta = logica.consultaSocios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    /**
     * metodo que consulta un socio por el id
     *
     * @param id
     * @return
     */
    @POST
    @Path("/socio")
    @Produces(MediaType.APPLICATION_JSON)
    public SocioEntity obtenerSocio(Integer id) {
        SocioEntity respuesta = new SocioEntity();
        try (SocioLogica logica = new SocioLogica()) {
            respuesta = logica.consultaSocio(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    /**
     * metodo quee actualiza un socio
     *
     * @param socio
     * @return
     */
    @POST
    @Path("/socio/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public String actualizarSocio(SocioEntity socio) {
        String respuesta = "";
        try (SocioLogica logica = new SocioLogica()) {
            respuesta = logica.actualizaSocio(socio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

}

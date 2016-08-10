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
import javax.ws.rs.GET;
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
public class AdministracionRecurso  {

    @POST
    @Path("/socio/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertaSocio(SocioEntity socio) {
        System.out.println("hola");
        String respuesta = "";
        try (SocioLogica logica = new SocioLogica()) {
            respuesta = logica.insertarSocio(socio);
        } catch (Exception e) {
            respuesta = e.getMessage();
            e.printStackTrace();
        }
        return respuesta;
    }

    @GET
    @Path("/lista")
    @Produces("application/json")
    public List<SocioEntity> traeLista() {
        List<SocioEntity> respuesta = new ArrayList<>();
        try {
            SocioEntity entidad = new SocioEntity();
            entidad.setId(1);
            entidad.setCiudad(1);
            entidad.setDigitoVer("2");
            entidad.setDireccion("cra");
            entidad.setEstado("A");
            respuesta.add(entidad);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

}

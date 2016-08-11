/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import com.co.codesoftware.persistencia.entidades.administracion.SocioEntity;
import java.util.List;

/**
 *
 * @author john
 */
public class Cliente2 {
    public static void main(String arg[]){
        Cliente.AdministracionRecurso_JerseyClient<SocioEntity> ob= new Cliente.AdministracionRecurso_JerseyClient<>();
        List<SocioEntity> lista= ob.obtenerSocio(null);
        for(int i=0;i<lista.size();i++){
            System.out.println(""+lista.get(i).getId());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author john
 */
public class Cliente {

    static class AdministracionRecurso_JerseyClient<T> {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8084/SIGEMCORS/rest";

        public AdministracionRecurso_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("admin");
        }

        public <T> T obtenerSocios(Class<T> responseType) throws ClientErrorException {
            return webTarget.path("socio/lista").request().post(null, responseType);
        }

        public String insertarSocio() throws ClientErrorException {
            return webTarget.path("socio/insertar").request().post(null, String.class);
        }

        public <T> T obtenerSocio(Class<T> responseType) throws ClientErrorException {
            return webTarget.path("socio").request().post(null, responseType);
        }

        public String actualizarSocio() throws ClientErrorException {
            return webTarget.path("socio/actualizar").request().post(null, String.class);
        }

        public void close() {
            client.close();
        }
    }
    
    
}

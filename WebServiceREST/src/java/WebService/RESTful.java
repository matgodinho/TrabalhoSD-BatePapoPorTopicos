/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Diego
 */
@Path("Service REST")
public class RESTful {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RESTful
     */
    public RESTful() {
    }

    /**
     * Retrieves representation of an instance of WebService.RESTful
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Acessos/{dataInicial}/{dataFinal}")
    public String Acessos(@PathParam("dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal) {

        DAO_WebService_REST a = new DAO_WebService_REST();
        int i = a.getAcessos(dataInicial, dataFinal);

        return ""+i;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("ChatsRalizados/{dataInicial}/{dataFinal}")
    public String ChatsRalizados(@PathParam("dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal) {

        DAO_WebService_REST a = new DAO_WebService_REST();
        int i = a.getChats_Realizados(dataInicial, dataFinal);

        return ""+i;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("ChatsRalizadosUser/{dataInicial}/{dataFinal}/{coduser}")
    public String ChatsRalizadosUser(@PathParam("dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal,@PathParam("coduser")int coduser) {

        DAO_WebService_REST a = new DAO_WebService_REST();
        int i = a.getChats_User(dataInicial, dataFinal,coduser);

        return ""+i;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("TopicosAcessos/{dataInicial}/{dataFinal}")
    public String TopicosAcessos(@PathParam("dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal) {

        DAO_WebService_REST a = new DAO_WebService_REST();
        int i[] = a.getTopicos_Acessados(dataInicial, dataFinal);
        
        String s = ""+i[0]+" "+i[1]+" "+i[2]+" "+i[3]+" "+i[4]+" "+i[5]+" "+i[6]+" "+i[7];
        return s;
    }

    /**
     * PUT method for updating or creating an instance of RESTful
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSeviceSOAP;

import Models.ModelUrl;
import javax.xml.ws.Endpoint;

public class Web_Service_SOAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModelUrl s = new ModelUrl();
        Endpoint.publish(s.GetAux(), new Implements_SOAP());

    }

}

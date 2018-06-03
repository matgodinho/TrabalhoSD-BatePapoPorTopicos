/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSeviceSOAP;

import Models.UserModel;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Interface_SOAP {

    @WebMethod
    int Incluir(int id, String nome, String Senha, String IPaddres);

    @WebMethod
    void Alterar(int id, String nome, String senha, String IPaddres);

    @WebMethod
    void Excluir(int id);

    @WebMethod
    UserModel[] Listar();

    @WebMethod
    void RegistrarAcesso(int id);

    @WebMethod
    void RegistrarPesquisa(int topico);

    @WebMethod
    void RegistrarChat(int user1, int user2, int topico);

    @WebMethod
    void RegistrarChatOnline(int topico, int codusuario);

    @WebMethod
    void ExcluirChatOnline(int codusuario);

}

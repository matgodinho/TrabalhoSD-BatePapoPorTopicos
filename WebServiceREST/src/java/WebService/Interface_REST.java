/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

/**
 *
 * @author Diego
 */
public interface Interface_REST {
    
    public int getAcessos(String dataInicial,String dataFinal);
    public int[] getTopicos_Acessados(String dataInicial,String dataFinal);
    public int getChats_Realizados(String dataInicial,String dataFinal);
    public int getChats_User(String dataInicial,String dataFinal,int coduser);
    
}

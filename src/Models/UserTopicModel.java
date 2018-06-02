/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Matheus
 */
/**
 *
 * Classe com o modelo de usuário e tópico usado na UDP para realizar a
 * validação do login.
 */
public class UserTopicModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codusuario;
    private String Senha;
    private int codtopico;

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public UserTopicModel(int codusuario, String senha, int codtopico) {
        this.codusuario = codusuario;
        this.codtopico = codtopico;
        this.Senha = senha;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public int getCodtopico() {
        return codtopico;
    }

    public void setCodtopico(int codtopico) {
        this.codtopico = codtopico;
    }

    public String toString() {
        return "Id = " + getCodusuario() + " Name = " + getCodtopico();
    }
}

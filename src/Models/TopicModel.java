/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * Classe utilizada para auxiliar na gravação dos tópicos no BD.
 */
public class TopicModel {

    int codtopico;

    public int getCodtopico() {
        return codtopico;
    }

    public void setCodtopico(int codtopico) {
        this.codtopico = codtopico;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }
    String topico;
}

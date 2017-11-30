/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DavidMorales
 */
public class Inscripcion {
    private Participante participante;
    private Competencia competencia;

    public Inscripcion(Participante participante, Competencia competencia) {
        this.participante = participante;
        this.competencia = competencia;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    
    
}

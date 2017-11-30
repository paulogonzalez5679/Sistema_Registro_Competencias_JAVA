/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Ciudad;
import modelo.Competencia;
import modelo.Inscripcion;
import modelo.Participante;

/**
 *
 * @author DavidMorales
 */
public class GestionDato {
    private List<Ciudad> ciudadList;
    private List<Competencia> competenciaList;
    private List<Inscripcion> inscripcionList;
    private List<Participante> participanteList;

    public GestionDato(List<Ciudad> ciudadList, List<Competencia> competenciaList, List<Inscripcion> inscripcionList, List<Participante> participanteList) {
        this.ciudadList = ciudadList;
        this.competenciaList = competenciaList;
        this.inscripcionList = inscripcionList;
        this.participanteList = participanteList;
    }
    

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }

    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

    public boolean addCiudad(Ciudad c){
        return this.ciudadList.add(c);
    }
    
    public boolean addCompetencia(Competencia c){
        return this.competenciaList.add(c);
    }
    
    public boolean addInscripcion(Inscripcion i){
        return this.inscripcionList.add(i);
    }
    
    public boolean addParticipante(Participante p){
        return this.participanteList.add(p);
    }
    
    public Ciudad buscarCiudad(String ciudad){
        for(Ciudad c:this.getCiudadList()){
            if(c.getNombre().equals(ciudad)==true){
                return c;
            }
        }
        return null;
    }
    
    public Participante buscarParticipante(String participante){
        for(Participante p:this.getParticipanteList()){
            if((p.getNombre()+p.getApellido()).equals(participante)==true){
                return p;
            }
        }
        return null;
    }
    
    public Competencia buscarCompetencia(String competencia){
        for(Competencia c:this.getCompetenciaList()){
            if(c.getNombre().equals(competencia)==true){
                return c;
            }
        }
        return null;
    }
}

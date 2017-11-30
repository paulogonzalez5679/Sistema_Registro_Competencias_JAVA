/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Participante;
import vista.VentanaRegParticipante;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaRegParticipante implements ActionListener {
    private VentanaRegParticipante ventanaRegParticipante;

    public EventoVentanaRegParticipante(VentanaRegParticipante ventanaRegParticipante) {
        this.ventanaRegParticipante = ventanaRegParticipante;
    }

    public VentanaRegParticipante getVentanaRegParticipante() {
        return ventanaRegParticipante;
    }

    public void setVentanaRegParticipante(VentanaRegParticipante ventanaRegParticipante) {
        this.ventanaRegParticipante = ventanaRegParticipante;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = this.ventanaRegParticipante.getTxtList().get(0).getText();
        String a = this.ventanaRegParticipante.getTxtList().get(1).getText();
        String c = this.ventanaRegParticipante.getTxtList().get(2).getText();
        String fn = this.ventanaRegParticipante.getTxtList().get(3).getText();
        Participante p = new Participante(n,a,c,fn);
        this.ventanaRegParticipante.getgD().addParticipante(p);
        
        Object [][] datoParticipante=this.ventanaRegParticipante.cargaDatosTabla(this.ventanaRegParticipante.getgD().getParticipanteList().size(),4);
        this.ventanaRegParticipante.setDatos(datoParticipante);
        this.ventanaRegParticipante.getModeloTabla().setDataVector(this.ventanaRegParticipante.getDatos(), this.ventanaRegParticipante.getEncabezado());
    }
    
}

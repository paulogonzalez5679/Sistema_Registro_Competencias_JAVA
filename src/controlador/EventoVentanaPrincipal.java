/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPrincipal;
import vista.VentanaRegCiudad;
import vista.VentanaRegCompetencia;
import vista.VentanaRegInscripcion;
import vista.VentanaRegParticipante;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaPrincipal implements ActionListener {
    
    private VentanaPrincipal ventanaPrincipal;

    public EventoVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(0))){
            VentanaRegCiudad vRC = new VentanaRegCiudad(this.ventanaPrincipal.getgD());
            vRC.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vRC);
        }
        if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(1))){
            VentanaRegCompetencia vRC = new VentanaRegCompetencia(this.ventanaPrincipal.getgD());
            vRC.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vRC);
        }
        if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(2))){
            VentanaRegParticipante vRP = new VentanaRegParticipante(this.ventanaPrincipal.getgD());
            vRP.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vRP);
        }
        if(ae.getSource().equals(this.ventanaPrincipal.getMenuItemList().get(3))){
            VentanaRegInscripcion vRI = new VentanaRegInscripcion(this.ventanaPrincipal.getgD());
            vRI.setVisible(true);
            this.ventanaPrincipal.getEscritorio().add(vRI);
        }
    }
    
}

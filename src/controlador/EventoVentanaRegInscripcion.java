/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Inscripcion;
import vista.VentanaRegInscripcion;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaRegInscripcion implements ActionListener {
    private VentanaRegInscripcion ventanaRegInscripcion;

    public EventoVentanaRegInscripcion(VentanaRegInscripcion ventanaRegInscripcion) {
        this.ventanaRegInscripcion = ventanaRegInscripcion;
    }

    public VentanaRegInscripcion getVentanaRegInscripcion() {
        return ventanaRegInscripcion;
    }

    public void setVentanaRegInscripcion(VentanaRegInscripcion ventanaRegInscripcion) {
        this.ventanaRegInscripcion = ventanaRegInscripcion;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String p = this.ventanaRegInscripcion.getComboList().get(0).getSelectedItem().toString();
        String c = this.ventanaRegInscripcion.getComboList().get(1).getSelectedItem().toString();
        Inscripcion i = new Inscripcion(this.ventanaRegInscripcion.getgD().buscarParticipante(p),this.ventanaRegInscripcion.getgD().buscarCompetencia(c));
        this.ventanaRegInscripcion.getgD().addInscripcion(i);
        
        Object [][] datoInscripcion=this.ventanaRegInscripcion.cargaDatosTabla(this.ventanaRegInscripcion.getgD().getInscripcionList().size(),3);
        this.ventanaRegInscripcion.setDatos(datoInscripcion);
        this.ventanaRegInscripcion.getModeloTabla().setDataVector(this.ventanaRegInscripcion.getDatos(), this.ventanaRegInscripcion.getEncabezado());
    }
    
}

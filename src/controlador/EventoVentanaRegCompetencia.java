/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Competencia;
import vista.VentanaRegCompetencia;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaRegCompetencia implements ActionListener {
    private VentanaRegCompetencia ventanaRegCompetencia;

    public EventoVentanaRegCompetencia(VentanaRegCompetencia ventanaRegCompetencia) {
        this.ventanaRegCompetencia = ventanaRegCompetencia;
    }

    public VentanaRegCompetencia getVentanaRegCompetencia() {
        return ventanaRegCompetencia;
    }

    public void setVentanaRegCompetencia(VentanaRegCompetencia ventanaRegCompetencia) {
        this.ventanaRegCompetencia = ventanaRegCompetencia;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = this.ventanaRegCompetencia.getTxtList().get(0).getText();
        String f = this.ventanaRegCompetencia.getTxtList().get(1).getText();
        String c = this.ventanaRegCompetencia.getComboCiudad().getSelectedItem().toString();
        
        Competencia com = new Competencia(n,f,this.ventanaRegCompetencia.getgD().buscarCiudad(c));
        this.ventanaRegCompetencia.getgD().addCompetencia(com);
        
        Object [][] datoCompetencia=this.ventanaRegCompetencia.cargaDatosTabla(this.ventanaRegCompetencia.getgD().getCompetenciaList().size(),3);
        this.ventanaRegCompetencia.setDatos(datoCompetencia);
        this.ventanaRegCompetencia.getModeloTabla().setDataVector(this.ventanaRegCompetencia.getDatos(), this.ventanaRegCompetencia.getEncabezado());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Ciudad;
import vista.VentanaRegCiudad;

/**
 *
 * @author DavidMorales
 */
public class EventoVentanaRegCiudad implements ActionListener {
    
    private VentanaRegCiudad ventanaRegCiudad;

    public EventoVentanaRegCiudad(VentanaRegCiudad ventanaRegCiudad) {
        this.ventanaRegCiudad = ventanaRegCiudad;
    }

    public VentanaRegCiudad getVentanaRegCiudad() {
        return ventanaRegCiudad;
    }

    public void setVentanaRegCiudad(VentanaRegCiudad ventanaRegCiudad) {
        this.ventanaRegCiudad = ventanaRegCiudad;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = this.ventanaRegCiudad.getTxtList().get(0).getText();
        String p = this.ventanaRegCiudad.getTxtList().get(1).getText();
        Ciudad c = new Ciudad(n,p);
        this.ventanaRegCiudad.getgD().addCiudad(c);
        
        Object [][] datoCiudad=this.ventanaRegCiudad.cargaDatosTabla(this.ventanaRegCiudad.getgD().getCiudadList().size(),2);
        this.ventanaRegCiudad.setDatos(datoCiudad);
        this.ventanaRegCiudad.getModeloTabla().setDataVector(this.ventanaRegCiudad.getDatos(), this.ventanaRegCiudad.getEncabezado());
    }
    
}

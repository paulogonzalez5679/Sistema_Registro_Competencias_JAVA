/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Ciudad;
import modelo.Competencia;
import modelo.Inscripcion;
import modelo.Participante;

/**
 *
 * @author DavidMorales
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Ciudad> ciuList = new ArrayList<Ciudad>();
        List<Competencia> comList = new ArrayList<Competencia>();
        List<Inscripcion> insList = new ArrayList<Inscripcion>();
        List<Participante> partList = new ArrayList<Participante>();
        GestionDato gD = new GestionDato(ciuList,comList,insList,partList);
        
        VentanaPrincipal vP = new VentanaPrincipal("Competencia",gD);
        vP.setVisible(true);
        
    }
    
}

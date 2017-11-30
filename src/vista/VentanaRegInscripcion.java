/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaRegInscripcion;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Competencia;
import modelo.Inscripcion;
import modelo.Participante;

/**
 *
 * @author DavidMorales
 */
public class VentanaRegInscripcion extends JInternalFrame {
    private List<JLabel> etiList;
    private List<JComboBox> comboList;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD;
    
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaRegInscripcion(GestionDato gD) {
        super("Registrar Inscripcion",true,true,true,true);
        this.gD=gD;
        this.iniciaComponente();
        this.setSize(500, 500);
    }
    
    public void iniciaComponente(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Participante"));
        this.etiList.add(new JLabel("Competencia"));
        this.comboList = new ArrayList<JComboBox>();
        this.comboList.add(new JComboBox(this.cargarComboParticipante()));
        this.comboList.add(new JComboBox(this.cargarComboCompetencia()));
        this.boton = new JButton("Guardar");
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(3,2);
        JPanel panelSup = new JPanel(disenioSup);
        panelSup.add(this.etiList.get(0));
        panelSup.add(this.comboList.get(0));
        panelSup.add(this.etiList.get(1));
        panelSup.add(this.comboList.get(1));
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[3];
        this.encabezado[0] = "Numero";
        this.encabezado[1] = "Participante";
        this.encabezado[1] = "Competencia";
        
        this.datos = this.cargaDatosTabla(this.gD.getInscripcionList().size(), 3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
        this.boton.addActionListener(new EventoVentanaRegInscripcion(this));
        
        this.add(this.panelPrincipal);
    }
    
    public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Inscripcion in:this.gD.getInscripcionList())
        {
            retorno[i][0]=i+1;
            retorno[i][1]=in.getParticipante().getNombre()+in.getParticipante().getApellido();
            retorno[i][2]=in.getCompetencia().getNombre();
            i++;
        }        
        return retorno;
    }
    
    public String[] cargarComboParticipante(){
        String[] retorno = new String[this.gD.getParticipanteList().size()];
        int i=0;
        for(Participante p:this.gD.getParticipanteList()){
            retorno[i]=p.getNombre()+p.getApellido();
            i++;
        }
        return retorno;
    }

    public String[] cargarComboCompetencia(){
        String[] retorno = new String[this.gD.getCompetenciaList().size()];
        int i=0;
        for(Competencia c:this.gD.getCompetenciaList()){
            retorno[i]=c.getNombre();
            i++;
        }
        return retorno;
    }
    
    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JComboBox> getComboList() {
        return comboList;
    }

    public void setComboList(List<JComboBox> comboList) {
        this.comboList = comboList;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
    
    
    
}

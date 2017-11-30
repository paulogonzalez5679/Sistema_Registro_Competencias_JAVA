/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaRegCompetencia;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudad;
import modelo.Competencia;

/**
 *
 * @author DavidMorales
 */
public class VentanaRegCompetencia extends JInternalFrame {
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private JComboBox comboCiudad;
    private JButton boton;
    private JPanel panelPrincipal;
    private GestionDato gD;
    
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaRegCompetencia(GestionDato gD) {
        super("Registrar Competencia",true,true,true,true);
        this.gD=gD;
        this.iniciaComponente();
        this.setSize(500, 500);
    }
    
    public void iniciaComponente(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Nombre"));
        this.etiList.add(new JLabel("Fecha"));
        this.etiList.add(new JLabel("Ciudad"));
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.comboCiudad = new JComboBox(this.cargarCombo());
        this.boton = new JButton("Guardar");
        
        LayoutManager disenioPrincipal = new BorderLayout();
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioSup = new GridLayout(4,2);
        JPanel panelSup = new JPanel(disenioSup);
        panelSup.add(this.etiList.get(0));
        panelSup.add(this.txtList.get(0));
        panelSup.add(this.etiList.get(1));
        panelSup.add(this.txtList.get(1));
        panelSup.add(this.etiList.get(2));
        panelSup.add(this.comboCiudad);
        panelSup.add(this.boton);
        this.panelPrincipal.add(panelSup,BorderLayout.NORTH);
        
        this.encabezado = new Object[3];
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Fecha";
        this.encabezado[2] = "Ciudad";
        
        this.datos = this.cargaDatosTabla(this.gD.getCompetenciaList().size(), 3);
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        
        this.panelPrincipal.add(this.scroll,BorderLayout.CENTER);
        
        this.boton.addActionListener(new EventoVentanaRegCompetencia(this));
        
        this.add(this.panelPrincipal);
        
    }
    
    public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Competencia c:this.gD.getCompetenciaList())
        {
            retorno[i][0]=c.getNombre();
            retorno[i][1]=c.getFecha();
            retorno[i][2]=c.getCiudad().getNombre();
            i++;
        }        
        return retorno;
    }
    
    public String[] cargarCombo(){
        String[] retorno = new String[this.gD.getCiudadList().size()];
        int i=0;
        for(Ciudad c:this.gD.getCiudadList()){
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

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JComboBox getComboCiudad() {
        return comboCiudad;
    }

    public void setComboCiudad(JComboBox comboCiudad) {
        this.comboCiudad = comboCiudad;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
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

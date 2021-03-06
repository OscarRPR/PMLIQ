/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View.panel;

import com.brainstorm.PMLIQ.Model.Equipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Accesorio;
import com.brainstorm.PMLIQ.Model.EquipoInfo.DatosTecnicosEquipo;
import com.brainstorm.PMLIQ.Model.EquipoInfo.EquipoAsociado;
import com.brainstorm.PMLIQ.Model.EquipoInfo.PlanMantenimiento;
import com.brainstorm.PMLIQ.Model.EquipoInfo.Proveedor;
import com.brainstorm.PMLIQ.Model.Inventario.Item;
import com.brainstorm.PMLIQ.View.PMLIApp;
import com.brainstorm.PMLIQ.View.dialogs.CrearAccesorio;
import com.brainstorm.PMLIQ.View.dialogs.CrearEquipoAsociado;
import com.brainstorm.PMLIQ.View.dialogs.CrearPlanMantenimiento;
import com.brainstorm.PMLIQ.View.dialogs.ModificarAccesorio;
import com.brainstorm.PMLIQ.View.dialogs.ModificarEquipoAsociado;
import com.brainstorm.PMLIQ.View.dialogs.ModificarPlanMantenimiento;
import com.brainstorm.PMLIQ.View.panel.list.EquiposListaPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silex RPR
 */
public class modificarEquipoPanel extends javax.swing.JPanel {
    
    private final int EQUIPOSTAB = 1;
    
    private final int DESCRIPCIONBASICA = 0;
    private final int DATOSTECNICOS = 1;
    private final int ADQUISICION = 5;

    /**
     * Creates new form crearEquipoPanel
     */
    public modificarEquipoPanel(Equipo equipo) {
        initComponents();
        
        bGroupManual = new ButtonGroup();
        bGroupManual.add(instalacionCheckBox);
        bGroupManual.add(tecnicoCheckBox);
        bGroupManual.add(usuarioCheckBox);
        bGroupManual.add(labCheckBox);
        
        instalacionCheckBox.setSelected(true);
        
        bGroupUso = new ButtonGroup();
        bGroupUso.add(docenciaCheckBox);
        bGroupUso.add(investigacionCheckBox);
        bGroupUso.add(extensionCheckBox);
        
        docenciaCheckBox.setSelected(true);
        
        bGroupForma = new ButtonGroup();
        bGroupForma.add(compraCheckBox);
        bGroupForma.add(donacionCheckBox);
        
        compraCheckBox.setSelected(true);
        usoSpinner.setEnabled(false);
        
        adquisicionDateChooser.setDate(new Date());
        servicioDateChooser.setDate(new Date());
        
        accesoriosTable.setModel(accesoriosModel);
        accesoriosTable.setColumnSelectionAllowed(false);
        accesoriosTable.setRowSelectionAllowed(true);

        accesoriosModel.addColumn("Nombre");
        accesoriosModel.addColumn("Marca");
        accesoriosModel.addColumn("Cantidad Disponible");
        
        accesoriosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        accesoriosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int selectedRow = accesoriosTable.getSelectedRow();
                    String nombre = (String) accesoriosModel.getValueAt(accesoriosTable.convertRowIndexToModel(selectedRow), 0);
                    int indice = getAccesorio(nombre);
                    ModificarAccesorio modificarAccesorio = new ModificarAccesorio(
                            (JFrame)PMLIApp.getInstance().getMainWindow(), true, accesorios, indice);
        
                    modificarAccesorio.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                updateAccesorioListModel();
                            }
                    });

                    modificarAccesorio.setLocationRelativeTo(null);
                    modificarAccesorio.setVisible(true);
                    
                }
            }
        });
        
        equiposTable.setModel(equiposModel);
        equiposTable.setColumnSelectionAllowed(false);
        equiposTable.setRowSelectionAllowed(true);

        equiposModel.addColumn("Nombre");
        equiposModel.addColumn("Placa de Inventario");
        
        equiposTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        equiposTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int selectedRow = equiposTable.getSelectedRow();
                    String placa = (String) equiposModel.getValueAt(equiposTable.convertRowIndexToModel(selectedRow), 1);
                    int indice = getEquipoAsociado(placa);
                    ModificarEquipoAsociado modificarEquipoAsociado = new ModificarEquipoAsociado(
                            (JFrame)PMLIApp.getInstance().getMainWindow(), true, equipos, indice);
        
                    modificarEquipoAsociado.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                updateEquiposAsociadosListModel();
                            }
                    });

                    modificarEquipoAsociado.setLocationRelativeTo(null);
                    modificarEquipoAsociado.setVisible(true);
                    
                }
            }
        });        
        
        mantenimientoTable.setModel(mantenimientoModel);
        mantenimientoTable.setColumnSelectionAllowed(false);
        mantenimientoTable.setRowSelectionAllowed(true);

        mantenimientoModel.addColumn("Nombre");
        mantenimientoModel.addColumn("Codigo");
        mantenimientoModel.addColumn("Responsable");
        mantenimientoModel.addColumn("Tipo de Plan");
        
        mantenimientoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 

        mantenimientoTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int selectedRow = mantenimientoTable.getSelectedRow();
                    String codigo = (String) mantenimientoModel.getValueAt(mantenimientoTable.convertRowIndexToModel(selectedRow), 1);
                    int indice = getPlan(codigo);
                    ModificarPlanMantenimiento modificarPlanMantenimiento = new ModificarPlanMantenimiento(
                            (JFrame)PMLIApp.getInstance().getMainWindow(), true, planes, indice);
        
                    modificarPlanMantenimiento.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                updateMantenimientoListModel();
                            }
                    });

                    modificarPlanMantenimiento.setLocationRelativeTo(null);
                    modificarPlanMantenimiento.setVisible(true);
                    
                }
            }
        });          
        
        nombreTextField.setText(equipo.getNombre());
        placaTextField.setEnabled(false);
        placaTextField.setText(equipo.getPlacaInventario());
        claseTextField.setText(equipo.getClaseEquipo());
        tipoModeloComboBox.setSelectedItem(equipo.getTipoEquipo().toString());
        marcaTextField.setText(equipo.getMarca());
        modeloTextField.setText(equipo.getModelo());
        serieTextField.setText(equipo.getSerieEquipo());
        bGroupManual.setSelected(getButtonSelected(bGroupManual, equipo.getTipoManual().toString()), true);
        codigoTextField.setText(equipo.getCodigoDocumento());
        ubicacionTextField.setText(equipo.getUbicacionEnLaboratorio());
        bGroupUso.setSelected(getButtonSelected(bGroupUso, equipo.getUsoEquipo().toString()), true);
        tareasTextArea.setText(equipo.getTareasEquipo());
       
        DatosTecnicosEquipo datos = equipo.getDatosTecnicosEquipo();
        
        voltajeTextField.setText(datos.getDatosElectricos().getVoltaje().toString());
        potenciaTextField.setText(datos.getDatosElectricos().getPotencia().toString());
        corrienteTextField.setText(datos.getDatosElectricos().getCorriente().toString());
        fasesTextField.setText(datos.getDatosElectricos().getFases().toString());
        tipoComboBox.setSelectedItem(datos.getDatosElectricos().getTipoElectrico().toString());
        altoTextField.setText(datos.getDimensiones().getAlto().toString());
        anchoTextField.setText(datos.getDimensiones().getAncho().toString());
        profundoTextField.setText(datos.getDimensiones().getProfundo().toString());
        pesoTextField.setText(datos.getDimensiones().getPeso().toString());
        usoComboBox.setSelectedItem(datos.getDimensiones().getPosicionUsoEquipo().toString());
        ambienteTextField.setText(datos.getTemperaturaAmbiente().toString());
        hrTextField.setText(datos.getHR().toString());
        otroTextField.setText(datos.getOtraOpcion());
        requerimientosTextArea.setText(datos.getRequerimientosAdicionales());
        especificacionTextArea.setText(datos.getEspecificacionMedicion());
        
        this.accesorios = equipo.getAccesorios();
        updateAccesorioListModel();
        
        this.equipos = equipo.getEquiposAsociados();
        updateEquiposAsociadosListModel();
        
        this.planes = equipo.getPlanes();
        updateMantenimientoListModel();
        
        Proveedor proveedor = equipo.getMetodoAdquisicion();
        fabricanteTextField.setText(proveedor.getFabricante());
        proveedorTextField.setText(proveedor.getProveedor());
        nitTextField.setText(proveedor.getNIT());
        contactoTextField.setText(proveedor.getContacto());
        telefonoTextField.setText(proveedor.getTelefono());
        direccionTextField.setText(proveedor.getDireccion());
        emailTextField.setText(proveedor.getEmail());
        
        if ( proveedor.getFormaAdquisicion().isCompra()) {
            compraCheckBox.setSelected(true);
            precioTextField.setEnabled(true);
            precioTextField.setText(proveedor.getFormaAdquisicion().getValorCompra());
            usoSpinner.setValue(0);
            usoSpinner.setEnabled(false);
        } else {
            donacionCheckBox.setSelected(true);
            usoSpinner.setEnabled(true);
            usoSpinner.setValue(proveedor.getFormaAdquisicion().getTiempoUso());
            precioTextField.setText("");
            precioTextField.setEnabled(false);
        }

        Date dateAdquisicion = null;
        Date dateServicio = null;
        try {
            dateAdquisicion = new SimpleDateFormat("dd-MM-yyyy").parse(proveedor.getFormaAdquisicion().getFechaAdquisicion().getFullDate());
            dateServicio = new SimpleDateFormat("dd-MM-yyyy").parse(proveedor.getFormaAdquisicion().getPuestaEnServicio().getFullDate());
        } catch (ParseException ex) {
            Logger.getLogger(modificarEquipoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        adquisicionDateChooser.setDate(dateAdquisicion);
        servicioDateChooser.setDate(dateServicio);
        vidaSpinner.setValue(proveedor.getFormaAdquisicion().getVidaUtil());
    }

    private ButtonModel getButtonSelected(ButtonGroup group, String text) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.getText().equals(text)) {
                return button.getModel();
            }
        }
        
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creacionEquipoTabPanel = new javax.swing.JTabbedPane();
        descripcionBasicaScrollPane = new javax.swing.JScrollPane();
        descripcionBasicaPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descripcionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        placaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        claseTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tipoModeloComboBox = new javax.swing.JComboBox();
        marcaTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        modeloTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        serieTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        instalacionCheckBox = new javax.swing.JCheckBox();
        tecnicoCheckBox = new javax.swing.JCheckBox();
        usuarioCheckBox = new javax.swing.JCheckBox();
        labCheckBox = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        codigoTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ubicacionTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        docenciaCheckBox = new javax.swing.JCheckBox();
        investigacionCheckBox = new javax.swing.JCheckBox();
        extensionCheckBox = new javax.swing.JCheckBox();
        guardarBasicosButton = new javax.swing.JButton();
        cancelarBasicaButton = new javax.swing.JButton();
        tareasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tareasTextArea = new javax.swing.JTextArea();
        errorBasicaLabel = new javax.swing.JLabel();
        datosTecnicosScrollPane = new javax.swing.JScrollPane();
        datosTecnicosPanel = new javax.swing.JPanel();
        tituloPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        datosElectricosPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        voltajeTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        potenciaTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        corrienteTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fasesTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox();
        dimensionesPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        altoTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        anchoTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        profundoTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pesoTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        usoComboBox = new javax.swing.JComboBox();
        ambientePanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        ambienteTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        hrTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        otroTextField = new javax.swing.JTextField();
        requerimientosPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requerimientosTextArea = new javax.swing.JTextArea();
        requerimientosPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        especificacionTextArea = new javax.swing.JTextArea();
        guardarTecnicosButton = new javax.swing.JButton();
        cancelarTecnicosButton = new javax.swing.JButton();
        errorTecnicosLabel = new javax.swing.JLabel();
        accesoriosScrollPane = new javax.swing.JScrollPane();
        accesoriosPanel = new javax.swing.JPanel();
        accionesPanel = new javax.swing.JPanel();
        nuevoAccesorioButton = new javax.swing.JButton();
        eliminarAccesorioButton = new javax.swing.JButton();
        buscarInternalPanel = new javax.swing.JPanel();
        filtroComboBox = new javax.swing.JComboBox();
        buscarTextField = new javax.swing.JTextField();
        separadorLabel = new javax.swing.JLabel();
        guardarAccesoriosButton = new javax.swing.JButton();
        cancelarAccesoriosBoton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        accesoriosTable = new javax.swing.JTable();
        equiposAsociadosScrollPane = new javax.swing.JScrollPane();
        equiposAsociadosPanel = new javax.swing.JPanel();
        accionesPanel1 = new javax.swing.JPanel();
        nuevoEquipoAsociadoButton = new javax.swing.JButton();
        eliminarEquipoAsociadoButton = new javax.swing.JButton();
        buscarInternalPanel1 = new javax.swing.JPanel();
        filtroComboBox1 = new javax.swing.JComboBox();
        buscarTextField1 = new javax.swing.JTextField();
        separadorLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        equiposTable = new javax.swing.JTable();
        guardarAsociadosButton = new javax.swing.JButton();
        cancelarAsociadosBoton = new javax.swing.JButton();
        mantenimientoScrollPane = new javax.swing.JScrollPane();
        mantenimientoPanel = new javax.swing.JPanel();
        accionesPanel2 = new javax.swing.JPanel();
        nuevoMantenimientoButton = new javax.swing.JButton();
        eliminarMantenimientoButton = new javax.swing.JButton();
        buscarInternalPanel2 = new javax.swing.JPanel();
        filtroComboBox2 = new javax.swing.JComboBox();
        buscarTextField2 = new javax.swing.JTextField();
        separadorLabel2 = new javax.swing.JLabel();
        guardarMantenimientoButton = new javax.swing.JButton();
        cancelarMantenimientoBoton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        mantenimientoTable = new javax.swing.JTable();
        adquisicionScrollPane = new javax.swing.JScrollPane();
        adquisicionPanel = new javax.swing.JPanel();
        tituloPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        descripcionPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        fabricanteTextField = new javax.swing.JTextField();
        nitTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        proveedorTextField = new javax.swing.JTextField();
        contactoTextField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        telefonoTextField = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        direccionTextField = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        compraCheckBox = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        precioTextField = new javax.swing.JTextField();
        donacionCheckBox = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        usoSpinner = new javax.swing.JSpinner();
        vidaSpinner = new javax.swing.JSpinner();
        adquisicionDateChooser = new com.toedter.calendar.JDateChooser();
        servicioDateChooser = new com.toedter.calendar.JDateChooser();
        guardarAdquisicionButton = new javax.swing.JButton();
        cancelarAdquisicionBoton = new javax.swing.JButton();
        errorAdquisicionLabel = new javax.swing.JLabel();

        jLabel1.setText("MODIFICANDO UN EQUIPO");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        descripcionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción Básica"));

        jLabel2.setText("Nombre");

        nombreTextField.setText("cccccccccccc");

        jLabel3.setText("Placa De Inventario");

        placaTextField.setText("wwwwwwwww");

        jLabel4.setText("Clase");

        claseTextField.setText("aaaaaaaaaaaa");

        jLabel5.setText("Tipo - Modelo");

        tipoModeloComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basico", "Especializado", "Computo" }));

        marcaTextField.setText("aaaaaaaaa");

        jLabel7.setText("Modelo");

        modeloTextField.setText("wwwwwww");

        jLabel8.setText("Serie");

        serieTextField.setText("232323");

        jLabel6.setText("Marca");

        jLabel9.setText("Manuales");

        instalacionCheckBox.setText("Instalacion");

        tecnicoCheckBox.setText("Tecnico");

        usuarioCheckBox.setText("Usuario");

        labCheckBox.setText("Laboratorio");

        jLabel10.setText("Código Documentos");

        codigoTextField.setText("23212121");

        jLabel11.setText("Ubicación En Laboratorio");

        ubicacionTextField.setText("asdsadsadsad");

        jLabel12.setText("Uso:");

        docenciaCheckBox.setText("Docencia");

        investigacionCheckBox.setText("Investigacion");

        extensionCheckBox.setText("Extension");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(claseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(marcaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modeloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(tecnicoCheckBox)
                                        .addGap(0, 0, 0)
                                        .addComponent(usuarioCheckBox)
                                        .addGap(0, 0, 0)
                                        .addComponent(labCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(docenciaCheckBox))
                                            .addComponent(jLabel10)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(investigacionCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(extensionCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(placaTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipoModeloComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(instalacionCheckBox))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ubicacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serieTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigoTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(placaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(claseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoModeloComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(marcaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(modeloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(serieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(instalacionCheckBox)
                    .addComponent(tecnicoCheckBox)
                    .addComponent(usuarioCheckBox)
                    .addComponent(labCheckBox)
                    .addComponent(jLabel10)
                    .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ubicacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(docenciaCheckBox)
                    .addComponent(investigacionCheckBox)
                    .addComponent(extensionCheckBox))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout descripcionPanelLayout = new javax.swing.GroupLayout(descripcionPanel);
        descripcionPanel.setLayout(descripcionPanelLayout);
        descripcionPanelLayout.setHorizontalGroup(
            descripcionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descripcionPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        descripcionPanelLayout.setVerticalGroup(
            descripcionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        guardarBasicosButton.setText("Guardar");
        guardarBasicosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBasicosButtonActionPerformed(evt);
            }
        });

        cancelarBasicaButton.setText("Cancelar");
        cancelarBasicaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBasicaButtonActionPerformed(evt);
            }
        });

        tareasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas/Determinaciones"));

        tareasTextArea.setColumns(20);
        tareasTextArea.setRows(5);
        tareasTextArea.setText("adfsafsdfdf asnmxz mn  njndnbfmdfd fd\naskljwewer erierrrrrrrrrrrrrrrrrrrrrrr dnfd fds sdfds fdsfklndslfjew m dfhsjd\ndfmds fdsnbfjsdhfe ");
        jScrollPane1.setViewportView(tareasTextArea);

        javax.swing.GroupLayout tareasPanelLayout = new javax.swing.GroupLayout(tareasPanel);
        tareasPanel.setLayout(tareasPanelLayout);
        tareasPanelLayout.setHorizontalGroup(
            tareasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tareasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        tareasPanelLayout.setVerticalGroup(
            tareasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tareasPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        errorBasicaLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout descripcionBasicaPanelLayout = new javax.swing.GroupLayout(descripcionBasicaPanel);
        descripcionBasicaPanel.setLayout(descripcionBasicaPanelLayout);
        descripcionBasicaPanelLayout.setHorizontalGroup(
            descripcionBasicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionBasicaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(descripcionBasicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descripcionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(descripcionBasicaPanelLayout.createSequentialGroup()
                        .addGroup(descripcionBasicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descripcionBasicaPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(guardarBasicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelarBasicaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tareasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorBasicaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        descripcionBasicaPanelLayout.setVerticalGroup(
            descripcionBasicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionBasicaPanelLayout.createSequentialGroup()
                .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tareasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorBasicaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(descripcionBasicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBasicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBasicaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        descripcionBasicaScrollPane.setViewportView(descripcionBasicaPanel);

        creacionEquipoTabPanel.addTab("Descripción Básica", descripcionBasicaScrollPane);

        jLabel13.setText("MODIFICANDO UN EQUIPO");

        javax.swing.GroupLayout tituloPanel1Layout = new javax.swing.GroupLayout(tituloPanel1);
        tituloPanel1.setLayout(tituloPanel1Layout);
        tituloPanel1Layout.setHorizontalGroup(
            tituloPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel1Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tituloPanel1Layout.setVerticalGroup(
            tituloPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel13)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        datosElectricosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables Electricas"));

        jLabel14.setText("Voltaje (V)");

        voltajeTextField.setText("2");

        jLabel15.setText("Potencia (W)");

        potenciaTextField.setText("3");

        jLabel16.setText("Corriente (A)");

        corrienteTextField.setText("1");

        jLabel17.setText("Fases");

        fasesTextField.setText("2");

        jLabel18.setText("Tipo");

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Neutro", "Tierra" }));
        tipoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datosElectricosPanelLayout = new javax.swing.GroupLayout(datosElectricosPanel);
        datosElectricosPanel.setLayout(datosElectricosPanelLayout);
        datosElectricosPanelLayout.setHorizontalGroup(
            datosElectricosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosElectricosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(potenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corrienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fasesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosElectricosPanelLayout.setVerticalGroup(
            datosElectricosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosElectricosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosElectricosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(voltajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(potenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(corrienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(fasesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        dimensionesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dimensiones"));

        jLabel19.setText("Alto (m)");

        altoTextField.setText("8");

        jLabel20.setText("Ancho (m)");

        anchoTextField.setText("8");

        jLabel21.setText("Profundo (m)");

        profundoTextField.setText("5");

        jLabel22.setText("Peso (Kg)");

        pesoTextField.setText("6");
        pesoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoTextFieldActionPerformed(evt);
            }
        });

        jLabel23.setText("Uso");

        usoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mesa", "Piso", "Campo" }));
        usoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usoComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dimensionesPanelLayout = new javax.swing.GroupLayout(dimensionesPanel);
        dimensionesPanel.setLayout(dimensionesPanelLayout);
        dimensionesPanelLayout.setHorizontalGroup(
            dimensionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dimensionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(altoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anchoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profundoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        dimensionesPanelLayout.setVerticalGroup(
            dimensionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dimensionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dimensionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(altoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(anchoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(profundoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(pesoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(usoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ambientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ambiente y Funcionamiento"));

        jLabel24.setText("T. Ambiente (ºC)");

        ambienteTextField.setText("6");

        jLabel25.setText("HR (%)");

        hrTextField.setText("4");

        jLabel26.setText("Otro");

        otroTextField.setText("nnnnnnnnnn nnnnn");
        otroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otroTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ambientePanelLayout = new javax.swing.GroupLayout(ambientePanel);
        ambientePanel.setLayout(ambientePanelLayout);
        ambientePanelLayout.setHorizontalGroup(
            ambientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ambientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ambienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otroTextField)
                .addContainerGap())
        );
        ambientePanelLayout.setVerticalGroup(
            ambientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ambientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ambientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(ambienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(hrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(otroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        requerimientosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Requerimientos Adicionales"));

        requerimientosTextArea.setColumns(20);
        requerimientosTextArea.setRows(5);
        requerimientosTextArea.setText("kkkkk kkk kkkkk kk kkk kkkkk kkk kkkk\ndddd ddddd\nee\ne\neeeeee ooooooo");
        jScrollPane2.setViewportView(requerimientosTextArea);

        javax.swing.GroupLayout requerimientosPanelLayout = new javax.swing.GroupLayout(requerimientosPanel);
        requerimientosPanel.setLayout(requerimientosPanelLayout);
        requerimientosPanelLayout.setHorizontalGroup(
            requerimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requerimientosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        requerimientosPanelLayout.setVerticalGroup(
            requerimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requerimientosPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        requerimientosPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Especificación de Medición (Para Equipos de Medición)"));

        especificacionTextArea.setColumns(20);
        especificacionTextArea.setRows(5);
        jScrollPane4.setViewportView(especificacionTextArea);

        javax.swing.GroupLayout requerimientosPanel2Layout = new javax.swing.GroupLayout(requerimientosPanel2);
        requerimientosPanel2.setLayout(requerimientosPanel2Layout);
        requerimientosPanel2Layout.setHorizontalGroup(
            requerimientosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requerimientosPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        requerimientosPanel2Layout.setVerticalGroup(
            requerimientosPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requerimientosPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        guardarTecnicosButton.setText("Guardar");
        guardarTecnicosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarTecnicosButtonActionPerformed(evt);
            }
        });

        cancelarTecnicosButton.setText("Cancelar");
        cancelarTecnicosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarTecnicosButtonActionPerformed(evt);
            }
        });

        errorTecnicosLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout datosTecnicosPanelLayout = new javax.swing.GroupLayout(datosTecnicosPanel);
        datosTecnicosPanel.setLayout(datosTecnicosPanelLayout);
        datosTecnicosPanelLayout.setHorizontalGroup(
            datosTecnicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosTecnicosPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(datosTecnicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(datosTecnicosPanelLayout.createSequentialGroup()
                        .addComponent(guardarTecnicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarTecnicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(datosTecnicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tituloPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ambientePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requerimientosPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requerimientosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dimensionesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datosElectricosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorTecnicosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        datosTecnicosPanelLayout.setVerticalGroup(
            datosTecnicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosTecnicosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datosElectricosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimensionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ambientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requerimientosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requerimientosPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(errorTecnicosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosTecnicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarTecnicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarTecnicosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        datosTecnicosScrollPane.setViewportView(datosTecnicosPanel);

        creacionEquipoTabPanel.addTab("Datos Técnicos", datosTecnicosScrollPane);

        nuevoAccesorioButton.setText("Nuevo");
        nuevoAccesorioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoAccesorioButtonActionPerformed(evt);
            }
        });

        eliminarAccesorioButton.setText("Eliminar");
        eliminarAccesorioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAccesorioButtonActionPerformed(evt);
            }
        });

        buscarInternalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Marca" }));

        buscarTextField.setForeground(new java.awt.Color(255, 153, 0));
        buscarTextField.setText("Buscar");
        buscarTextField.setDisabledTextColor(new java.awt.Color(255, 204, 0));

        separadorLabel.setText(" :");

        javax.swing.GroupLayout buscarInternalPanelLayout = new javax.swing.GroupLayout(buscarInternalPanel);
        buscarInternalPanel.setLayout(buscarInternalPanelLayout);
        buscarInternalPanelLayout.setHorizontalGroup(
            buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInternalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        buscarInternalPanelLayout.setVerticalGroup(
            buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarInternalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarInternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorLabel))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout accionesPanelLayout = new javax.swing.GroupLayout(accionesPanel);
        accionesPanel.setLayout(accionesPanelLayout);
        accionesPanelLayout.setHorizontalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarInternalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevoAccesorioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarAccesorioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        accionesPanelLayout.setVerticalGroup(
            accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanelLayout.createSequentialGroup()
                .addGroup(accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarInternalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(accionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nuevoAccesorioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarAccesorioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        guardarAccesoriosButton.setText("Guardar");
        guardarAccesoriosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAccesoriosButtonActionPerformed(evt);
            }
        });

        cancelarAccesoriosBoton.setText("Cancelar");
        cancelarAccesoriosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAccesoriosBotonActionPerformed(evt);
            }
        });

        accesoriosTable.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(accesoriosTable);

        javax.swing.GroupLayout accesoriosPanelLayout = new javax.swing.GroupLayout(accesoriosPanel);
        accesoriosPanel.setLayout(accesoriosPanelLayout);
        accesoriosPanelLayout.setHorizontalGroup(
            accesoriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accesoriosPanelLayout.createSequentialGroup()
                .addGroup(accesoriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accesoriosPanelLayout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addComponent(guardarAccesoriosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelarAccesoriosBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accesoriosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(accesoriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(accionesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        accesoriosPanelLayout.setVerticalGroup(
            accesoriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accesoriosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(accesoriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarAccesoriosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarAccesoriosBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        accesoriosScrollPane.setViewportView(accesoriosPanel);

        creacionEquipoTabPanel.addTab("Accesorios", accesoriosScrollPane);

        nuevoEquipoAsociadoButton.setText("Nuevo");
        nuevoEquipoAsociadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEquipoAsociadoButtonActionPerformed(evt);
            }
        });

        eliminarEquipoAsociadoButton.setText("Eliminar");
        eliminarEquipoAsociadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEquipoAsociadoButtonActionPerformed(evt);
            }
        });

        buscarInternalPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre" }));

        buscarTextField1.setForeground(new java.awt.Color(255, 153, 0));
        buscarTextField1.setText("Buscar");
        buscarTextField1.setDisabledTextColor(new java.awt.Color(255, 204, 0));

        separadorLabel1.setText(" :");

        javax.swing.GroupLayout buscarInternalPanel1Layout = new javax.swing.GroupLayout(buscarInternalPanel1);
        buscarInternalPanel1.setLayout(buscarInternalPanel1Layout);
        buscarInternalPanel1Layout.setHorizontalGroup(
            buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInternalPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        buscarInternalPanel1Layout.setVerticalGroup(
            buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarInternalPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarInternalPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorLabel1))
                .addGap(25, 25, 25))
        );

        equiposTable.setRowSelectionAllowed(false);
        jScrollPane5.setViewportView(equiposTable);

        javax.swing.GroupLayout accionesPanel1Layout = new javax.swing.GroupLayout(accionesPanel1);
        accionesPanel1.setLayout(accionesPanel1Layout);
        accionesPanel1Layout.setHorizontalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addGroup(accionesPanel1Layout.createSequentialGroup()
                        .addComponent(buscarInternalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuevoEquipoAsociadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarEquipoAsociadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        accionesPanel1Layout.setVerticalGroup(
            accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accionesPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(buscarInternalPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accionesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nuevoEquipoAsociadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarEquipoAsociadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        guardarAsociadosButton.setText("Guardar");
        guardarAsociadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAsociadosButtonActionPerformed(evt);
            }
        });

        cancelarAsociadosBoton.setText("Cancelar");
        cancelarAsociadosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAsociadosBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout equiposAsociadosPanelLayout = new javax.swing.GroupLayout(equiposAsociadosPanel);
        equiposAsociadosPanel.setLayout(equiposAsociadosPanelLayout);
        equiposAsociadosPanelLayout.setHorizontalGroup(
            equiposAsociadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equiposAsociadosPanelLayout.createSequentialGroup()
                .addComponent(accionesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, equiposAsociadosPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardarAsociadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelarAsociadosBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        equiposAsociadosPanelLayout.setVerticalGroup(
            equiposAsociadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, equiposAsociadosPanelLayout.createSequentialGroup()
                .addComponent(accionesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(equiposAsociadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarAsociadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarAsociadosBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        equiposAsociadosScrollPane.setViewportView(equiposAsociadosPanel);

        creacionEquipoTabPanel.addTab("Equipos Asociados", equiposAsociadosScrollPane);

        nuevoMantenimientoButton.setText("Nuevo");
        nuevoMantenimientoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMantenimientoButtonActionPerformed(evt);
            }
        });

        eliminarMantenimientoButton.setText("Eliminar");
        eliminarMantenimientoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMantenimientoButtonActionPerformed(evt);
            }
        });

        buscarInternalPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

        filtroComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo", "Responsable" }));

        buscarTextField2.setForeground(new java.awt.Color(255, 153, 0));
        buscarTextField2.setText("Buscar");
        buscarTextField2.setDisabledTextColor(new java.awt.Color(255, 204, 0));

        separadorLabel2.setText(" :");

        javax.swing.GroupLayout buscarInternalPanel2Layout = new javax.swing.GroupLayout(buscarInternalPanel2);
        buscarInternalPanel2.setLayout(buscarInternalPanel2Layout);
        buscarInternalPanel2Layout.setHorizontalGroup(
            buscarInternalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarInternalPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        buscarInternalPanel2Layout.setVerticalGroup(
            buscarInternalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarInternalPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarInternalPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorLabel2))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout accionesPanel2Layout = new javax.swing.GroupLayout(accionesPanel2);
        accionesPanel2.setLayout(accionesPanel2Layout);
        accionesPanel2Layout.setHorizontalGroup(
            accionesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarInternalPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(nuevoMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        accionesPanel2Layout.setVerticalGroup(
            accionesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accionesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accionesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarInternalPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(accionesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nuevoMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        guardarMantenimientoButton.setText("Guardar");
        guardarMantenimientoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMantenimientoButtonActionPerformed(evt);
            }
        });

        cancelarMantenimientoBoton.setText("Cancelar");
        cancelarMantenimientoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarMantenimientoBotonActionPerformed(evt);
            }
        });

        mantenimientoTable.setRowSelectionAllowed(false);
        jScrollPane6.setViewportView(mantenimientoTable);

        javax.swing.GroupLayout mantenimientoPanelLayout = new javax.swing.GroupLayout(mantenimientoPanel);
        mantenimientoPanel.setLayout(mantenimientoPanelLayout);
        mantenimientoPanelLayout.setHorizontalGroup(
            mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                .addGroup(mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accionesPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mantenimientoPanelLayout.createSequentialGroup()
                                .addComponent(guardarMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelarMantenimientoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        mantenimientoPanelLayout.setVerticalGroup(
            mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mantenimientoPanelLayout.createSequentialGroup()
                .addComponent(accionesPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mantenimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarMantenimientoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarMantenimientoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mantenimientoScrollPane.setViewportView(mantenimientoPanel);

        creacionEquipoTabPanel.addTab("Mantenimiento", mantenimientoScrollPane);

        jLabel27.setText("MODIFICANDO UN EQUIPO");

        javax.swing.GroupLayout tituloPanel2Layout = new javax.swing.GroupLayout(tituloPanel2);
        tituloPanel2.setLayout(tituloPanel2Layout);
        tituloPanel2Layout.setHorizontalGroup(
            tituloPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel2Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tituloPanel2Layout.setVerticalGroup(
            tituloPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel27)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        descripcionPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adquisición de Equipo"));

        jLabel28.setText("Fabricante");

        fabricanteTextField.setText("bbbbbbbbbb");
        fabricanteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricanteTextFieldActionPerformed(evt);
            }
        });

        nitTextField.setText("232323323");

        jLabel30.setText("Proveedor");

        proveedorTextField.setText("cvbvbvbvb");

        contactoTextField.setText("fdgfgdfgfdgdfgdfgfdg");

        jLabel33.setText("Telefono");

        telefonoTextField.setText("545465656");

        jLabel34.setText("Contacto");

        jLabel35.setText("Dirección");

        emailTextField.setText("fgdfgdfgfdg");

        direccionTextField.setText("fdgdfgdfgfdgf");

        jLabel39.setText("NIT");

        jLabel40.setText("Email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel30))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(proveedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(contactoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel39))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(direccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fabricanteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fabricanteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(proveedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(contactoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(direccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout descripcionPanel1Layout = new javax.swing.GroupLayout(descripcionPanel1);
        descripcionPanel1.setLayout(descripcionPanel1Layout);
        descripcionPanel1Layout.setHorizontalGroup(
            descripcionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descripcionPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        descripcionPanel1Layout.setVerticalGroup(
            descripcionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de Adquisición"));

        compraCheckBox.setText("Compra");
        compraCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraCheckBoxActionPerformed(evt);
            }
        });

        jLabel29.setText("Precio");

        precioTextField.setText("23423434");

        donacionCheckBox.setText("Donación");
        donacionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donacionCheckBoxActionPerformed(evt);
            }
        });

        jLabel31.setText("Tiempo de Uso (Años)");

        jLabel32.setText("Fecha Adquisición");

        jLabel36.setText("Fecha Puesta en Servicio");

        jLabel37.setText("Vida Útil Estimada");

        usoSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        vidaSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adquisicionDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(compraCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(donacionCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(usoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servicioDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(vidaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compraCheckBox)
                    .addComponent(jLabel29)
                    .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donacionCheckBox)
                    .addComponent(jLabel31)
                    .addComponent(usoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37)
                        .addComponent(vidaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adquisicionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicioDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        guardarAdquisicionButton.setText("Guardar");
        guardarAdquisicionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAdquisicionButtonActionPerformed(evt);
            }
        });

        cancelarAdquisicionBoton.setText("Cancelar");
        cancelarAdquisicionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAdquisicionBotonActionPerformed(evt);
            }
        });

        errorAdquisicionLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout adquisicionPanelLayout = new javax.swing.GroupLayout(adquisicionPanel);
        adquisicionPanel.setLayout(adquisicionPanelLayout);
        adquisicionPanelLayout.setHorizontalGroup(
            adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adquisicionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(adquisicionPanelLayout.createSequentialGroup()
                            .addComponent(guardarAdquisicionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cancelarAdquisicionBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(errorAdquisicionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcionPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        adquisicionPanelLayout.setVerticalGroup(
            adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adquisicionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(errorAdquisicionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adquisicionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarAdquisicionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarAdquisicionBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        adquisicionScrollPane.setViewportView(adquisicionPanel);

        creacionEquipoTabPanel.addTab("Método de Adquisición", adquisicionScrollPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creacionEquipoTabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creacionEquipoTabPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usoComboBoxActionPerformed

    private void tipoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoComboBoxActionPerformed

    private void nuevoAccesorioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoAccesorioButtonActionPerformed
        CrearAccesorio crearAccesorio = new CrearAccesorio((JFrame)PMLIApp.getInstance().getMainWindow(), true, accesorios);
        
        crearAccesorio.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    updateAccesorioListModel();
                }
        });
        
        crearAccesorio.setLocationRelativeTo(null);
        crearAccesorio.setVisible(true);
    }//GEN-LAST:event_nuevoAccesorioButtonActionPerformed

    private void eliminarAccesorioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAccesorioButtonActionPerformed
        int selectedRow = accesoriosTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) accesoriosModel.getValueAt(accesoriosTable.convertRowIndexToModel(selectedRow), 0);
            eliminarAccesorio(nombre);
            updateAccesorioListModel();
            
        } else {
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun accesorio para eliminar.", 
                                    "Error Al Eliminar Accesorio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarAccesorioButtonActionPerformed

    private boolean eliminarAccesorio(String nombre) {
        for(Accesorio a : accesorios) {
            if (a.getNombre().equals(nombre)) {
                accesorios.remove(a);
                return true;
            }
        }
        return false;
    }
    
    private int getAccesorio(String nombre) {
        int indice = 0;
        for(Accesorio a : accesorios) {
            if (a.getNombre().equals(nombre)) {
                break;
            }
            indice += 1;
        }
        return indice;
    }
    
    private void nuevoEquipoAsociadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEquipoAsociadoButtonActionPerformed
        CrearEquipoAsociado crearEquipoAsociado = new CrearEquipoAsociado((JFrame)PMLIApp.getInstance().getMainWindow(), true, equipos);
        
        crearEquipoAsociado.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    updateEquiposAsociadosListModel();
                }
        });
        
        crearEquipoAsociado.setLocationRelativeTo(null);
        crearEquipoAsociado.setVisible(true);
    }//GEN-LAST:event_nuevoEquipoAsociadoButtonActionPerformed

    private void eliminarEquipoAsociadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEquipoAsociadoButtonActionPerformed
        int selectedRow = equiposTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) equiposModel.getValueAt(equiposTable.convertRowIndexToModel(selectedRow), 0);
            eliminarEquipoAsociado(nombre);
            updateEquiposAsociadosListModel();
            
        } else {
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun equipo asociado para eliminar.", 
                                    "Error Al Eliminar Equipo Asociado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarEquipoAsociadoButtonActionPerformed

    private boolean eliminarEquipoAsociado(String nombre) {
        for(EquipoAsociado e : equipos) {
            if (e.getNombre().equals(nombre)) {
                equipos.remove(e);
                return true;
            }
        }
        return false;
    }
    
    private int getEquipoAsociado(String placa) {
        int indice = 0;
        for(EquipoAsociado e : equipos) {
            if (e.getPlacaInventario().equals(placa)) {
                return indice;
            }
            indice += 1;
        }
        return indice;
    }
    
    private void nuevoMantenimientoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoMantenimientoButtonActionPerformed
        CrearPlanMantenimiento crearPlanMantenimiento = new CrearPlanMantenimiento((JFrame)PMLIApp.getInstance().getMainWindow(), true, planes);
        
        crearPlanMantenimiento.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    updateMantenimientoListModel();
                }
        });
        
        crearPlanMantenimiento.setLocationRelativeTo(null);
        crearPlanMantenimiento.setVisible(true);
    }//GEN-LAST:event_nuevoMantenimientoButtonActionPerformed

    private void eliminarMantenimientoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMantenimientoButtonActionPerformed
        int selectedRow = mantenimientoTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) mantenimientoModel.getValueAt(mantenimientoTable.convertRowIndexToModel(selectedRow), 0);
            eliminarPlanMantenimiento(nombre);
            updateMantenimientoListModel();
            
        } else {
              JOptionPane.showMessageDialog(PMLIApp.getInstance().getMainWindow(), "No esta seleccionado ningun plan de mantenimiento para eliminar.", 
                                    "Error Al Eliminar Plan de Mantenimiento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarMantenimientoButtonActionPerformed

    private boolean eliminarPlanMantenimiento(String nombre) {
        for(PlanMantenimiento p : planes) {
            if (p.getNombre().equals(nombre)) {
                planes.remove(p);
                return true;
            }
        }
        return false;
    }
    
    private int getPlan(String codigo) {
        int indicePlan = 0;
        for(PlanMantenimiento p : planes) {
            if(p.getCodigo().equals(codigo)) {
                break;
            }
            indicePlan += 1;
        }
        
        return indicePlan;
    }
    
    private void guardarBasicosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBasicosButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarBasicosButtonActionPerformed

    private void guardarTecnicosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarTecnicosButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarTecnicosButtonActionPerformed

    private void guardarAccesoriosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAccesoriosButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarAccesoriosButtonActionPerformed

    private void guardarAsociadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAsociadosButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarAsociadosButtonActionPerformed

    private void guardarMantenimientoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMantenimientoButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarMantenimientoButtonActionPerformed

    private void guardarAdquisicionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAdquisicionButtonActionPerformed
        guardarDatosEquipo();
    }//GEN-LAST:event_guardarAdquisicionButtonActionPerformed

    private void cancelarBasicaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBasicaButtonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarBasicaButtonActionPerformed

    private void fabricanteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabricanteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricanteTextFieldActionPerformed

    private void pesoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoTextFieldActionPerformed

    private void cancelarTecnicosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarTecnicosButtonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarTecnicosButtonActionPerformed

    private void cancelarAccesoriosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAccesoriosBotonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarAccesoriosBotonActionPerformed

    private void cancelarAsociadosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAsociadosBotonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarAsociadosBotonActionPerformed

    private void cancelarAdquisicionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAdquisicionBotonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarAdquisicionBotonActionPerformed

    private void cancelarMantenimientoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarMantenimientoBotonActionPerformed
        disposePanel();
    }//GEN-LAST:event_cancelarMantenimientoBotonActionPerformed

    private void otroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otroTextFieldActionPerformed

    private void compraCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraCheckBoxActionPerformed
        precioTextField.setEnabled(true);
        if ( compraCheckBox.isSelected() ) {
            usoSpinner.setEnabled(false);
        } else {
            usoSpinner.setEnabled(true);
        }
    }//GEN-LAST:event_compraCheckBoxActionPerformed

    private void donacionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donacionCheckBoxActionPerformed
        usoSpinner.setEnabled(true);
        if (donacionCheckBox.isSelected()) {
            precioTextField.setEnabled(false);
        } else {
            precioTextField.setEnabled(true);
        }
            
    }//GEN-LAST:event_donacionCheckBoxActionPerformed

    private void disposePanel() {
        setVisible(false);
        removeAll();
        PMLIApp.getInstance().getMainWindow().getAppTabPanel().setComponentAt(EQUIPOSTAB, new EquiposListaPanel());
    }
    
    private void setCurrentErrorTab(List<String> resultados) {
        for (int i = 0; i < resultados.size(); i++)
        {
            if ( !resultados.get(i).equals("") ) {
                creacionEquipoTabPanel.setSelectedIndex(i);
                return;
            }
        }
    }
    
    public void guardarDatosEquipo() {
        List<String> equiposExistentes = getPlacasEquipos();
        List<String> infoEquipo = getDatosBasicosEquipo();
        List<String> datosTecnicosEquipo = getDatosTecnicosEquipo();
        List<String> adquisicionEquipo = getDatosAdquisicionEquipo();
 
        List<String> resultados = PMLIApp.getInstance().getAdmEquipos().crearEquipo(infoEquipo,
                                                                        datosTecnicosEquipo,
                                                                        accesorios,
                                                                        equipos,
                                                                        planes,
                                                                        adquisicionEquipo,
                                                                        equiposExistentes);

        errorBasicaLabel.setText(resultados.get(DESCRIPCIONBASICA));
        errorTecnicosLabel.setText(resultados.get(DATOSTECNICOS));
        errorAdquisicionLabel.setText(resultados.get(ADQUISICION));
        
        setCurrentErrorTab(resultados);
        
        boolean hasFinishedCreation = true;
        for (String s : resultados) {
            if (!s.equals("")) {
                hasFinishedCreation = false;
                break;
            }
        }
        
        if ( hasFinishedCreation) {
            disposePanel();
        }
    }
    
    private  List<String> getPlacasEquipos() {
        List<String> placas = new ArrayList<String>();
        return placas;
    }
    
    public List<String> getDatosBasicosEquipo() {
        List<String> strings = new ArrayList<String>();
        
        strings.add(nombreTextField.getText());
        strings.add(placaTextField.getText());
        strings.add(claseTextField.getText());
        strings.add(tipoModeloComboBox.getSelectedItem().toString());
        strings.add(marcaTextField.getText());
        strings.add(modeloTextField.getText());
        strings.add(serieTextField.getText());
        strings.add(getSelectedButtonText(bGroupManual));
        strings.add(codigoTextField.getText());
        strings.add(ubicacionTextField.getText());
        strings.add(getSelectedButtonText(bGroupUso));
        strings.add(tareasTextArea.getText());
        
        return strings;
    }

    public List<String> getDatosTecnicosEquipo() {
        List<String> strings = new ArrayList<String>();
        
        strings.add(voltajeTextField.getText());
        strings.add(potenciaTextField.getText());
        strings.add(corrienteTextField.getText());
        strings.add(fasesTextField.getText());
        strings.add(tipoComboBox.getSelectedItem().toString());
        strings.add(altoTextField.getText());
        strings.add(anchoTextField.getText());
        strings.add(profundoTextField.getText());
        strings.add(pesoTextField.getText());
        strings.add(usoComboBox.getSelectedItem().toString());
        strings.add(ambienteTextField.getText());
        strings.add(hrTextField.getText());
        strings.add(otroTextField.getText());
        strings.add(requerimientosTextArea.getText());
        strings.add(especificacionTextArea.getText());
        
        return strings;
    }
    
    public List<String> getDatosAdquisicionEquipo() {
        List<String> strings = new ArrayList<String>();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        
        strings.add(fabricanteTextField.getText());
        strings.add(proveedorTextField.getText());
        strings.add(nitTextField.getText());
        strings.add(contactoTextField.getText());
        strings.add(telefonoTextField.getText());
        strings.add(direccionTextField.getText());
        strings.add(emailTextField.getText());
        strings.add(getSelectedButtonText(bGroupForma));
        
        String precio = "0";
        if (compraCheckBox.isSelected()) {
            precio = precioTextField.getText();
        }
        
        strings.add(precio);
        strings.add(usoSpinner.getValue().toString());
        strings.add(formateador.format(adquisicionDateChooser.getDate()));
        strings.add(formateador.format(servicioDateChooser.getDate()));
        strings.add(vidaSpinner.getValue().toString());
        
        return strings;
    }
    
    public String getSelectedButtonText(ButtonGroup buttonGroup) 
    {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    private void updateAccesorioListModel() {

        if (accesoriosModel.getRowCount() > 0) {
            for (int i = accesoriosModel.getRowCount() - 1; i > -1; i--) {
                accesoriosModel.removeRow(i);
            }
        }
        
        for(Accesorio a : accesorios) {
            accesoriosModel.addRow(new Object[] { a.getNombre(), a.getMarca(), a.getCantidad() });
        }

        accesoriosTable.setModel(accesoriosModel);
    }
    
    private void updateEquiposAsociadosListModel() {
        if (equiposModel.getRowCount() > 0) {
            for (int i = equiposModel.getRowCount() - 1; i > -1; i--) {
                equiposModel.removeRow(i);
            }
        }
        
        for(EquipoAsociado e : equipos) {
            equiposModel.addRow(new Object[] {e.getNombre(), e.getPlacaInventario()});
        }
        
        equiposTable.setModel(equiposModel);
    }
    
    private void updateMantenimientoListModel() {
        if (mantenimientoModel.getRowCount() > 0) {
            for (int i = mantenimientoModel.getRowCount() - 1; i > -1; i--) {
                mantenimientoModel.removeRow(i);
            }
        }
        
        for(PlanMantenimiento p : planes) {
            mantenimientoModel.addRow(new Object[] {p.getNombre(), p.getCodigo(), p.getResponsable(), p.getTipoPlan()});
        }
        
        mantenimientoTable.setModel(mantenimientoModel);
    }
    
    private DefaultTableModel accesoriosModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel equiposModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private DefaultTableModel mantenimientoModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private List<Accesorio> accesorios = new ArrayList<Accesorio>();
    private List<EquipoAsociado> equipos = new ArrayList<EquipoAsociado>();
    private List<PlanMantenimiento> planes = new ArrayList<PlanMantenimiento>();
    private ButtonGroup bGroupManual, bGroupUso, bGroupForma;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accesoriosPanel;
    private javax.swing.JScrollPane accesoriosScrollPane;
    private javax.swing.JTable accesoriosTable;
    private javax.swing.JPanel accionesPanel;
    private javax.swing.JPanel accionesPanel1;
    private javax.swing.JPanel accionesPanel2;
    private com.toedter.calendar.JDateChooser adquisicionDateChooser;
    private javax.swing.JPanel adquisicionPanel;
    private javax.swing.JScrollPane adquisicionScrollPane;
    private javax.swing.JTextField altoTextField;
    private javax.swing.JPanel ambientePanel;
    private javax.swing.JTextField ambienteTextField;
    private javax.swing.JTextField anchoTextField;
    private javax.swing.JPanel buscarInternalPanel;
    private javax.swing.JPanel buscarInternalPanel1;
    private javax.swing.JPanel buscarInternalPanel2;
    private javax.swing.JTextField buscarTextField;
    private javax.swing.JTextField buscarTextField1;
    private javax.swing.JTextField buscarTextField2;
    private javax.swing.JButton cancelarAccesoriosBoton;
    private javax.swing.JButton cancelarAdquisicionBoton;
    private javax.swing.JButton cancelarAsociadosBoton;
    private javax.swing.JButton cancelarBasicaButton;
    private javax.swing.JButton cancelarMantenimientoBoton;
    private javax.swing.JButton cancelarTecnicosButton;
    private javax.swing.JTextField claseTextField;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JCheckBox compraCheckBox;
    private javax.swing.JTextField contactoTextField;
    private javax.swing.JTextField corrienteTextField;
    private javax.swing.JTabbedPane creacionEquipoTabPanel;
    private javax.swing.JPanel datosElectricosPanel;
    private javax.swing.JPanel datosTecnicosPanel;
    private javax.swing.JScrollPane datosTecnicosScrollPane;
    private javax.swing.JPanel descripcionBasicaPanel;
    private javax.swing.JScrollPane descripcionBasicaScrollPane;
    private javax.swing.JPanel descripcionPanel;
    private javax.swing.JPanel descripcionPanel1;
    private javax.swing.JPanel dimensionesPanel;
    private javax.swing.JTextField direccionTextField;
    private javax.swing.JCheckBox docenciaCheckBox;
    private javax.swing.JCheckBox donacionCheckBox;
    private javax.swing.JButton eliminarAccesorioButton;
    private javax.swing.JButton eliminarEquipoAsociadoButton;
    private javax.swing.JButton eliminarMantenimientoButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JPanel equiposAsociadosPanel;
    private javax.swing.JScrollPane equiposAsociadosScrollPane;
    private javax.swing.JTable equiposTable;
    private javax.swing.JLabel errorAdquisicionLabel;
    private javax.swing.JLabel errorBasicaLabel;
    private javax.swing.JLabel errorTecnicosLabel;
    private javax.swing.JTextArea especificacionTextArea;
    private javax.swing.JCheckBox extensionCheckBox;
    private javax.swing.JTextField fabricanteTextField;
    private javax.swing.JTextField fasesTextField;
    private javax.swing.JComboBox filtroComboBox;
    private javax.swing.JComboBox filtroComboBox1;
    private javax.swing.JComboBox filtroComboBox2;
    private javax.swing.JButton guardarAccesoriosButton;
    private javax.swing.JButton guardarAdquisicionButton;
    private javax.swing.JButton guardarAsociadosButton;
    private javax.swing.JButton guardarBasicosButton;
    private javax.swing.JButton guardarMantenimientoButton;
    private javax.swing.JButton guardarTecnicosButton;
    private javax.swing.JTextField hrTextField;
    private javax.swing.JCheckBox instalacionCheckBox;
    private javax.swing.JCheckBox investigacionCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JCheckBox labCheckBox;
    private javax.swing.JPanel mantenimientoPanel;
    private javax.swing.JScrollPane mantenimientoScrollPane;
    private javax.swing.JTable mantenimientoTable;
    private javax.swing.JTextField marcaTextField;
    private javax.swing.JTextField modeloTextField;
    private javax.swing.JTextField nitTextField;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JButton nuevoAccesorioButton;
    private javax.swing.JButton nuevoEquipoAsociadoButton;
    private javax.swing.JButton nuevoMantenimientoButton;
    private javax.swing.JTextField otroTextField;
    private javax.swing.JTextField pesoTextField;
    private javax.swing.JTextField placaTextField;
    private javax.swing.JTextField potenciaTextField;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JTextField profundoTextField;
    private javax.swing.JTextField proveedorTextField;
    private javax.swing.JPanel requerimientosPanel;
    private javax.swing.JPanel requerimientosPanel2;
    private javax.swing.JTextArea requerimientosTextArea;
    private javax.swing.JLabel separadorLabel;
    private javax.swing.JLabel separadorLabel1;
    private javax.swing.JLabel separadorLabel2;
    private javax.swing.JTextField serieTextField;
    private com.toedter.calendar.JDateChooser servicioDateChooser;
    private javax.swing.JPanel tareasPanel;
    private javax.swing.JTextArea tareasTextArea;
    private javax.swing.JCheckBox tecnicoCheckBox;
    private javax.swing.JTextField telefonoTextField;
    private javax.swing.JComboBox tipoComboBox;
    private javax.swing.JComboBox tipoModeloComboBox;
    private javax.swing.JPanel tituloPanel;
    private javax.swing.JPanel tituloPanel1;
    private javax.swing.JPanel tituloPanel2;
    private javax.swing.JTextField ubicacionTextField;
    private javax.swing.JComboBox usoComboBox;
    private javax.swing.JSpinner usoSpinner;
    private javax.swing.JCheckBox usuarioCheckBox;
    private javax.swing.JSpinner vidaSpinner;
    private javax.swing.JTextField voltajeTextField;
    // End of variables declaration//GEN-END:variables
}

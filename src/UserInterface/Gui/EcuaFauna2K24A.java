package UserInterface.Gui;

import DataAccess.CCHormigaDAO;
import DataAccess.DTO.CCHormigaDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcuaFauna2K24A extends JFrame {

    private static final String CEDULA = "1755447057";
    private static final String NOMBRES = "Criollo Christopher";

    private JButton crearLarvaButton;
    private JButton alimentarGenoAlimentoButton;
    private JButton alimentarIngestaNativaButton;
    private JComboBox<String> genoAlimentoComboBox;
    private JComboBox<String> ingestaNativaComboBox;
    private JButton eliminarButton;
    private JButton guardarButton;
    private JTable hormigaTable;
    private DefaultTableModel tableModel;
    private JLabel cedulaLabel;
    private JLabel nombresLabel;
    private CCHormigaDAO hormigaDAO;

    public EcuaFauna2K24A() {
        setTitle("EcuaFauna 2k24A");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        hormigaDAO = new CCHormigaDAO();
        String[] columnNames = {"ID", "Nombre", "Sexo", "Tipo", "Estado", "Provincia", "Alimento", "Fecha Creación", "Fecha Modificación"};
        tableModel = new DefaultTableModel(columnNames, 0);
        hormigaTable = new JTable(tableModel);

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        cedulaLabel = new JLabel("Cédula: " + CEDULA);
        nombresLabel = new JLabel("Nombres: " + NOMBRES);
        topPanel.add(cedulaLabel);
        topPanel.add(new JLabel()); 
        topPanel.add(nombresLabel);
        topPanel.add(new JLabel()); 

        JScrollPane tableScrollPane = new JScrollPane(hormigaTable);

        JPanel bottomPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 filas y 2 columnas
        
        crearLarvaButton = new JButton("Crear Hormiga Larva");
        genoAlimentoComboBox = new JComboBox<>(new String[]{"X", "XX", "XY"});
        alimentarGenoAlimentoButton = new JButton("Alimentar con GenoAlimento");
        ingestaNativaComboBox = new JComboBox<>(new String[]{"Herbivoro", "Carnivoro", "Omnivoro", "Insectivoro", "Nectarivoro"});
        alimentarIngestaNativaButton = new JButton("Alimentar con Ingesta Nativa");
        eliminarButton = new JButton("Eliminar");
        guardarButton = new JButton("Guardar");

        bottomPanel.add(crearLarvaButton);
        bottomPanel.add(new JLabel()); 
        bottomPanel.add(genoAlimentoComboBox);
        bottomPanel.add(alimentarGenoAlimentoButton);
        bottomPanel.add(ingestaNativaComboBox);
        bottomPanel.add(alimentarIngestaNativaButton);
        bottomPanel.add(eliminarButton);
        bottomPanel.add(guardarButton);
        
        add(topPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        cargarHormigas();

        crearLarvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de crear una Hormiga larva?");
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        CCHormigaDTO nuevaHormiga = new CCHormigaDTO();
                        nuevaHormiga.ccSetNombreHormiga("Larva " + (tableModel.getRowCount() + 1));
                        nuevaHormiga.ccSetCodigoSexo(1); 
                        nuevaHormiga.ccSetCodigoTipoHormiga(1); 
                        nuevaHormiga.ccSetCodigoEstado(1); 
                        nuevaHormiga.ccSetCodigoProvincia(1); 
                        nuevaHormiga.ccSetCodigoAlimento(1); 
                        nuevaHormiga.ccSetEstado("A"); 
                        
                        hormigaDAO.create(nuevaHormiga);
                        cargarHormigas();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al crear hormiga: " + ex.getMessage());
                    }
                }
            }
        });

        alimentarGenoAlimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hormigaTable.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String selectedGenoAlimento = (String) genoAlimentoComboBox.getSelectedItem();
                        Integer codigoHormiga = (Integer) tableModel.getValueAt(selectedRow, 0);
                        CCHormigaDTO hormiga = hormigaDAO.readBy(codigoHormiga);
                        
                        if (hormiga != null) {
                            if ("XY".equals(selectedGenoAlimento)) {
                                hormiga.ccSetCodigoSexo(2); 
                                hormiga.ccSetCodigoTipoHormiga(3); 
                            }
                            hormigaDAO.update(hormiga);
                            cargarHormigas();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al alimentar con GenoAlimento: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay hormiga seleccionada para alimentar.");
                }
            }
        });

        alimentarIngestaNativaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hormigaTable.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String selectedIngestaNativa = (String) ingestaNativaComboBox.getSelectedItem();
                        Integer codigoHormiga = (Integer) tableModel.getValueAt(selectedRow, 0);
                        CCHormigaDTO hormiga = hormigaDAO.readBy(codigoHormiga);
                        
                        if (hormiga != null) {
                            if ("Omnivoro".equals(selectedIngestaNativa)) {
                                hormiga.ccSetCodigoEstado(1); 
                            } else {
                                hormiga.ccSetCodigoEstado(2); 
                            }
                            hormigaDAO.update(hormiga);
                            cargarHormigas();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al alimentar con Ingesta Nativa: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay hormiga seleccionada para alimentar.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = hormigaTable.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la hormiga seleccionada?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            Integer codigoHormiga = (Integer) tableModel.getValueAt(selectedRow, 0);
                            CCHormigaDTO hormiga = hormigaDAO.readBy(codigoHormiga);
                            if (hormiga != null) {
                                hormiga.ccSetEstado("I"); // Inactivo (eliminado)
                                hormigaDAO.update(hormiga);
                                cargarHormigas();
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar hormiga: " + ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay hormiga seleccionada para eliminar.");
                }
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Guardado Completo.");
            }
        });
    }

    private void cargarHormigas() {
        try {
            List<CCHormigaDTO> hormigas = hormigaDAO.readAll();
            tableModel.setRowCount(0); 
            for (CCHormigaDTO hormiga : hormigas) {
                Object[] rowData = {
                    hormiga.ccGetCodigoHormiga(),
                    hormiga.ccGetNombreHormiga(),
                    getDescripcionSexo(hormiga.ccGetCodigoSexo()),
                    getDescripcionTipo(hormiga.ccGetCodigoTipoHormiga()),
                    getDescripcionEstado(hormiga.ccGetCodigoEstado()),
                    getDescripcionProvincia(hormiga.ccGetCodigoProvincia()),
                    getDescripcionAlimento(hormiga.ccGetCodigoAlimento()),
                    hormiga.ccGetFechaCrea(),
                    hormiga.ccGetFechaModifica()
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar hormigas: " + e.getMessage());
        }
    }

    private String getDescripcionSexo(int codigoSexo) {
        switch (codigoSexo) {
            case 1: return "Asexual";
            case 2: return "Macho";
            case 3: return "Hembra";
            default: return "Desconocido";
        }
    }

    private String getDescripcionTipo(int codigoTipoHormiga) {
        switch (codigoTipoHormiga) {
            case 1: return "Larva";
            case 2: return "Obrera";
            case 3: return "Zángana";
            default: return "Desconocido";
        }
    }

    private String getDescripcionEstado(int codigoEstado) {
        switch (codigoEstado) {
            case 1: return "Viva";
            case 2: return "Muerta";
            default: return "Desconocido";
        }
    }

    private String getDescripcionProvincia(int codigoProvincia) {
        switch (codigoProvincia) {
            case 1: return "Pichincha";
            case 2: return "Guayas";
            case 3: return "Manabí";
            default: return "Desconocido";
        }
    }

    private String getDescripcionAlimento(int codigoAlimento) {
        switch (codigoAlimento) {
            case 1: return "Herbivoro";
            case 2: return "Carnivoro";
            case 3: return "Omnivoro";
            case 4: return "Insectivoro";
            case 5: return "Nectarivoro";
            default: return "Desconocido";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EcuaFauna2K24A().setVisible(true);
            }
        });
    }
}

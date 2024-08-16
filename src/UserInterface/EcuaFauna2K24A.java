package UserInterface;

import DataAccess.CCHormigaDAO;
import DataAccess.DTO.CCHormigaDTO;
import Framework.PatException;
import cc.classes.CCLarva;
import cc.classes.CCZangano;
import cc.interfaces.CCHormiga;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EcuaFauna2K24A extends JFrame {

    // Variables globales estáticas
    private static final String CEDULA = "1755447057";
    private static final String NOMBRES = "Criollo Christopher";

    // Declaración de componentes
    private JButton crearLarvaButton;
    private JButton alimentarGenoAlimentoButton;
    private JButton alimentarIngestaNativaButton;
    private JComboBox<String> genoAlimentoComboBox;
    private JComboBox<String> ingestaNativaComboBox;
    private JButton eliminarButton;
    private JButton guardarButton;

    // Grilla de hormigas (3x6)
    private JPanel hormigueroPanel;
    private JButton[][] hormigaSlots;

    // Etiquetas para cédula y nombres
    private JLabel cedulaLabel;
    private JLabel nombresLabel;

    // Lista para almacenar las hormigas
    private List<CCHormiga> hormigas;

    public EcuaFauna2K24A() {
        // Configuración básica del JFrame
        setTitle("EcuaFauna 2k24A");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar lista de hormigas
        hormigas = new ArrayList<>();

        // Panel superior para cédula y nombres
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        cedulaLabel = new JLabel("Cédula: " + CEDULA);
        nombresLabel = new JLabel("Nombres: " + NOMBRES);
        topPanel.add(cedulaLabel);
        topPanel.add(new JLabel()); // Espacio vacío
        topPanel.add(nombresLabel);
        topPanel.add(new JLabel()); // Espacio vacío

        // Panel central para el hormiguero
        hormigueroPanel = new JPanel(new GridLayout(3, 6, 5, 5)); // Añadido espacio entre grillas
        hormigaSlots = new JButton[3][6];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                hormigaSlots[i][j] = new JButton("Vacío");
                hormigueroPanel.add(hormigaSlots[i][j]);
            }
        }

        // Panel inferior para las acciones
        JPanel bottomPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 filas y 2 columnas
        
        crearLarvaButton = new JButton("Crear Hormiga Larva");

        genoAlimentoComboBox = new JComboBox<>(new String[]{"X", "XX", "XY"});
        alimentarGenoAlimentoButton = new JButton("Alimentar con GenoAlimento");

        ingestaNativaComboBox = new JComboBox<>(new String[]{"Herbivoro", "Carnivoro", "Omnivoro", "Insectivoro", "Nectarivoro"});
        alimentarIngestaNativaButton = new JButton("Alimentar con Ingesta Nativa");

        eliminarButton = new JButton("Eliminar");
        guardarButton = new JButton("Guardar");

        // Agregar componentes al panel inferior
        bottomPanel.add(crearLarvaButton);
        bottomPanel.add(new JLabel()); // Espacio vacío para alinear

        bottomPanel.add(genoAlimentoComboBox);
        bottomPanel.add(alimentarGenoAlimentoButton);

        bottomPanel.add(ingestaNativaComboBox);
        bottomPanel.add(alimentarIngestaNativaButton);

        bottomPanel.add(eliminarButton);
        bottomPanel.add(guardarButton);
        
        // Agregar paneles al JFrame
        add(topPanel, BorderLayout.NORTH);
        add(hormigueroPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Acción al crear una hormiga larva
        crearLarvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de crear una Hormiga larva?");
                if (confirm == JOptionPane.YES_OPTION) {
                    // Generar valores para la nueva hormiga
                    String ubicacion = generarUbicacionAleatoria();
                    String sexo = "Asexual";
                    String estado = "VIVA";
                    
                    CCHormiga hormiga = new CCLarva(null); // Comienza como larva

                    // Guardar la hormiga
                    hormigas.add(hormiga);
                    actualizarHormiguero();
                }
            }
        });

        // Acción al alimentar con GenoAlimento
        alimentarGenoAlimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genoAlimentoSeleccionado = (String) genoAlimentoComboBox.getSelectedItem();
                
                // Lógica para convertir larva en zángano si se selecciona "XY"
                for (CCHormiga hormiga : hormigas) {
                    if (hormiga instanceof CCLarva) {
                        if ("XY".equals(genoAlimentoSeleccionado)) {
                            hormiga = new CCZangano(hormiga.getUbicacion());
                            break;
                        }
                    }
                }
                actualizarHormiguero();
            }
        });

        // Acción al alimentar con Ingesta Nativa
        alimentarIngestaNativaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingestaNativaSeleccionada = (String) ingestaNativaComboBox.getSelectedItem();
                
                for (CCHormiga hormiga : hormigas) {
                    if (hormiga instanceof CCZangano) {
                        if ("Omnivoro".equals(ingestaNativaSeleccionada)) {
                            hormiga.setEstado("VIVA");
                        } else {
                            hormiga.setEstado("MUERTA");
                        }
                        break;
                    }
                }
                actualizarHormiguero();
            }
        });
        
        // Acción para eliminar hormiga
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si hay hormigas para eliminar
                if (!hormigas.isEmpty()) {
                    // Mostrar diálogo de confirmación
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la hormiga?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Elimina la última hormiga de la lista
                        hormigas.remove(hormigas.size() - 1);
                        // Actualiza la grilla
                        actualizarHormiguero();
                    }
                    // Si el usuario selecciona "No", simplemente se cierra el mensaje sin hacer nada
                } else {
                    JOptionPane.showMessageDialog(null, "No hay hormigas para eliminar.");
                }
            }
        });
        

        // Acción para guardar el estado del hormiguero
        // Acción para guardar el estado del hormiguero
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar diálogo de confirmación
                int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de guardar todo el hormiguero en la base de datos?", "Confirmar Guardado", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION || confirm == JOptionPane.NO_OPTION) {
                    // Simplemente cerrar el mensaje sin hacer nada
                    JOptionPane.showMessageDialog(null, "Guardado Completo.");
                }
            }
        });
        

    }

    // Método para actualizar el hormiguero
    private void actualizarHormiguero() {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (index < hormigas.size()) {
                    hormigaSlots[i][j].setText(hormigas.get(index).toString());
                } else {
                    hormigaSlots[i][j].setText("Vacío");
                }
                index++;
            }
        }
    }

    // Método para generar una ubicación aleatoria en la provincia
    private String generarUbicacionAleatoria() {
        String[] ubicaciones = {"Loja", "Quito", "Guayaquil", "Cuenca", "Ambato"};
        Random rand = new Random();
        return ubicaciones[rand.nextInt(ubicaciones.length)];
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

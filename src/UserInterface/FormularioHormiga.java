package UserInterface;

import javax.swing.*;
import java.awt.*;

public class FormularioHormiga extends JFrame {

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

    public FormularioHormiga() {
        // Configuración básica del JFrame
        setTitle("EcuaFauna 2k24A");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para cédula y nombres
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        cedulaLabel = new JLabel("Cédula: " + CEDULA);
        nombresLabel = new JLabel("Nombres: " + NOMBRES);
        topPanel.add(cedulaLabel);
        topPanel.add(new JLabel()); // Espacio vacío
        topPanel.add(nombresLabel);
        topPanel.add(new JLabel()); // Espacio vacío

        // Panel central para el hormiguero
        hormigueroPanel = new JPanel(new GridLayout(3, 6));
        hormigaSlots = new JButton[3][6];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                hormigaSlots[i][j] = new JButton("Vacío");
                hormigueroPanel.add(hormigaSlots[i][j]);
            }
        }

        // Panel inferior para las acciones
        JPanel bottomPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        
        crearLarvaButton = new JButton("Crear Hormiga Larva");
        genoAlimentoComboBox = new JComboBox<>(new String[]{"XY"});
        alimentarGenoAlimentoButton = new JButton("Alimentar con GenoAlimento");

        ingestaNativaComboBox = new JComboBox<>(new String[]{"Omnivoro"});
        alimentarIngestaNativaButton = new JButton("Alimentar con Ingesta Nativa");

        eliminarButton = new JButton("Eliminar");
        guardarButton = new JButton("Guardar");

        bottomPanel.add(crearLarvaButton);
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
    }

    public static void main(String[] args) {
        // Ejecutar el formulario
        FormularioHormiga formulario = new FormularioHormiga();
        formulario.setVisible(true);
    }
}

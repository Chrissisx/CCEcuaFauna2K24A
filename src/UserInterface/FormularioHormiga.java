package UserInterface;

import javax.swing.*;
import java.awt.*;

public class FormularioHormiga extends JFrame {

    // Declaración de componentes
    private JLabel ccNombreHormigaLabel;
    private JTextField ccNombreHormigaField;
    private JLabel ccTipoHormigaLabel;
    private JComboBox<String> ccTipoHormigaComboBox;
    private JLabel ccSexoLabel;
    private JComboBox<String> ccSexoComboBox;
    private JLabel ccEstadoLabel;
    private JComboBox<String> ccEstadoComboBox;
    private JLabel ccProvinciaLabel;
    private JComboBox<String> ccProvinciaComboBox;
    private JLabel ccAlimentoLabel;
    private JComboBox<String> ccAlimentoComboBox;
    private JButton ccGuardarButton;
    private JButton ccCancelarButton;

    public FormularioHormiga() {
        // Configuración básica del JFrame
        setTitle("Formulario de Hormigas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10)); // GridLayout con 7 filas y 2 columnas

        // Inicialización de componentes
        ccNombreHormigaLabel = new JLabel("Nombre de Hormiga:");
        ccNombreHormigaField = new JTextField();

        ccTipoHormigaLabel = new JLabel("Tipo de Hormiga:");
        ccTipoHormigaComboBox = new JComboBox<>(new String[]{"Larva", "Soldado", "Rastrera", "Reina"});

        ccSexoLabel = new JLabel("Sexo:");
        ccSexoComboBox = new JComboBox<>(new String[]{"Macho", "Hembra", "Asexual"});

        ccEstadoLabel = new JLabel("Estado:");
        ccEstadoComboBox = new JComboBox<>(new String[]{"Huevo", "Larva", "Pupa", "Adulta"});

        ccProvinciaLabel = new JLabel("Provincia:");
        ccProvinciaComboBox = new JComboBox<>(new String[]{
            "El Oro", "Esmeraldas", "Guayas", "Los Ríos", "Manabí", 
            "Santa Elena", "Santo Domingo de los Tsáchilas", "Azuay", 
            "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", 
            "Imbabura", "Loja", "Pichincha", "Tungurahua", "Morona Santiago", 
            "Napo", "Orellana", "Pastaza", "Sucumbíos", "Zamora Chinchipe", "Galápagos"
        });

        ccAlimentoLabel = new JLabel("Alimento:");
        ccAlimentoComboBox = new JComboBox<>(new String[]{"Carne", "Hierbas", "Insectos", "Frutas"});

        ccGuardarButton = new JButton("Guardar");
        ccCancelarButton = new JButton("Cancelar");

        // Agregar componentes al JFrame
        add(ccNombreHormigaLabel);
        add(ccNombreHormigaField);
        add(ccTipoHormigaLabel);
        add(ccTipoHormigaComboBox);
        add(ccSexoLabel);
        add(ccSexoComboBox);
        add(ccEstadoLabel);
        add(ccEstadoComboBox);
        add(ccProvinciaLabel);
        add(ccProvinciaComboBox);
        add(ccAlimentoLabel);
        add(ccAlimentoComboBox);
        add(ccGuardarButton);
        add(ccCancelarButton);
    }

    public static void main(String[] args) {
        // Ejecutar el formulario
        FormularioHormiga formulario = new FormularioHormiga();
        formulario.setVisible(true);
    }
}

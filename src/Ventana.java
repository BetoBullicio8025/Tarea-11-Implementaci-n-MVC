import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton boton;
    private JComboBox combo;
    private nombreModeloCombo modelo;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1100, 400);
        setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(3);

        lblNombre = new JLabel("Ingresa un nombre ");
        this.getContentPane().add(lblNombre);
        txtNombre = new JTextField(10);
        this.getContentPane().add(txtNombre);
        boton = new JButton("Agregar");
        this.getContentPane().add(boton);
        //Configurar modelo

        modelo = new nombreModeloCombo();
        modelo.agregarNombre("Lulu");
        modelo.agregarNombre("Mit");
        modelo.agregarNombre("Edu");
        combo = new JComboBox(modelo);
        this.getContentPane().add(combo);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nuevo = txtNombre.getText();
                modelo.agregarNombre(nuevo);
                txtNombre.setText("");
            }
        });

        combo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(combo.getSelectedIndex());
                System.out.println(combo.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Hola " + combo.getSelectedItem());
            }
        });


    }
}

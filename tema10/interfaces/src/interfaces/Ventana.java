package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    private JButton saludo, boton;
    private JTextField entrada;
    private JTextArea area;

    public Ventana() {
        super("Mi primera ventana");

        saludo = new JButton("PULSA AQUI");
        boton = new JButton("NO PULSES AQUI");
        entrada = new JTextField(30);
        area = new JTextArea(40, 70);

        entrada.addActionListener((e) -> {
            String contenido = entrada.getText().trim();

            if (!contenido.equals("")) {
                area.setText(area.getText() + contenido + "\n");
                entrada.setText("");
            }
        });

        boton.addActionListener((e) -> {
            String contenido = entrada.getText().trim();

            if (!contenido.equals("")) {
                area.setText(area.getText() + contenido + "\n");
                entrada.setText("");
            }

        });

        saludo.setBackground(Color.RED);
        saludo.setForeground(Color.GREEN);

        saludo.addActionListener(
                (e) -> {
                    String nombre = JOptionPane.
                            showInputDialog(rootPane, "Dime tu nombre");
                    if (nombre == null || nombre.equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Eres un maleducado");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, nombre);
                    }
                });

//        saludo.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Buenos dias");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
        //LAYOUT
        this.setLayout(new FlowLayout());

        this.add(boton);
        this.add(saludo);
        this.add(entrada);
        this.add(area);
        //this.setLocation(500,500);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1000,500);
        this.pack();
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }

}

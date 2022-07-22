package gcalc_java;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calc_gabriel implements ActionListener{
    int i;
    JButton tombol_clear, tombol_bagi, tombol_kali, tombol_kurang, tombol_tambah, tombol_koma, tombol_sama_dengan, tombol_delete, tombol_positif_negatif;
    JFrame root;
    Font font_layar = new Font("Comic Sans MS", Font.PLAIN, 30);
    JTextField layar;
    JButton[] operator_button = new JButton[9];
    JButton[] tombol_angka = new JButton[10];
    JPanel panel, panel_bawah;
    double angka_pertama, angka_kedua, hasil;
    String operasi;
    ImageIcon icon;

    calc_gabriel () {
        root = new JFrame();
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setTitle("G-Calc");
        root.setSize(400, 585);
        root.setResizable(false);

        icon = new ImageIcon("/home/gabriel/projects/java/workspace/gcalc_java/Logo transparan.png");

        layar = new JTextField();
        layar.setBounds(25, 25, 350, 50);
        layar.setEditable(false);
        layar.setFont(font_layar);
        layar.setBackground(new Color(77, 77, 77));
        layar.setForeground(Color.WHITE);
        layar.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));

        tombol_bagi = new JButton("÷");
        tombol_kali = new JButton("x");
        tombol_kurang = new JButton("-");
        tombol_tambah = new JButton("+");
        tombol_koma = new JButton(".");
        tombol_sama_dengan = new JButton("=");
        tombol_clear = new JButton("C");
        tombol_delete = new JButton("<-");
        tombol_positif_negatif = new JButton("+/-");
        
        operator_button[0] = tombol_bagi;
        operator_button[1] = tombol_kali;
        operator_button[2] = tombol_kurang;
        operator_button[3] = tombol_tambah;
        operator_button[4] = tombol_koma;
        operator_button[5] = tombol_sama_dengan;
        operator_button[6] = tombol_clear;
        operator_button[7] = tombol_delete;
        operator_button[8] = tombol_positif_negatif;

        for (i = 0; i < 9; i++) {
            operator_button[i].setFont(font_layar);
            operator_button[i].setFocusable(false);
            operator_button[i].addActionListener(this);
            operator_button[i].setForeground(Color.WHITE);
            operator_button[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            operator_button[i].setBackground(Color.DARK_GRAY);
            
        }

        for (i = 0; i < 10; i++) {
            tombol_angka[i] = new JButton(String.valueOf(i));
            tombol_angka[i].addActionListener(this);
            tombol_angka[i].setFont(font_layar);
            tombol_angka[i].setBackground(Color.DARK_GRAY);
            tombol_angka[i].setFocusable(false);
            tombol_angka[i].setForeground(Color.WHITE);
            tombol_angka[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            tombol_angka[i].setForeground(Color.WHITE);
        }

        panel = new JPanel();
        panel.setBounds(25, 100, 350, 350);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);
        panel.add(tombol_angka[1]);
        panel.add(tombol_angka[2]);
        panel.add(tombol_angka[3]);
        panel.add(tombol_bagi);
        panel.add(tombol_angka[4]);
        panel.add(tombol_angka[5]);
        panel.add(tombol_angka[6]);
        panel.add(tombol_kali);
        panel.add(tombol_angka[7]);
        panel.add(tombol_angka[8]);
        panel.add(tombol_angka[9]);
        panel.add(tombol_kurang);
        panel.add(tombol_angka[0]);
        panel.add(tombol_koma);
        panel.add(tombol_sama_dengan);
        panel.add(tombol_tambah);
        
        panel_bawah = new JPanel();
        panel_bawah.setBounds(25, 475, 350, 50);
        panel_bawah.setLayout(new GridLayout(0, 3, 10, 10));
        panel_bawah.add(tombol_positif_negatif);
        panel_bawah.add(tombol_delete);
        panel_bawah.setBackground(Color.DARK_GRAY);
        panel_bawah.add(tombol_clear);

        root.setIconImage(icon.getImage());
        root.add(layar);
        root.add(panel);
        root.add(panel_bawah);
        root.setLayout(null);
        root.getContentPane().setBackground(Color.DARK_GRAY);
        root.setVisible(true);
    }
    public static void main (String[] args) {
        new calc_gabriel();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == tombol_clear) {
            layar.setText("");
        }

        for (i = 0; i < 10; i++) {
            if (arg0.getSource() == tombol_angka[i]) {
                layar.setText(layar.getText().concat(String.valueOf(i)));
            }
        }

        if (arg0.getSource() == tombol_bagi) {
            angka_pertama = Double.valueOf(layar.getText());
            operasi = "bagi";
            layar.setText("");
        }
        
        if (arg0.getSource() == tombol_kali) {
            angka_pertama = Double.valueOf(layar.getText());
            operasi = "kali";
            layar.setText("");
        }

        if (arg0.getSource() == tombol_kurang) {
            angka_pertama = Double.valueOf(layar.getText());
            operasi = "kurang";
            layar.setText("");
        }

        if (arg0.getSource() == tombol_tambah) {
            angka_pertama = Double.valueOf(layar.getText());
            operasi = "tambah";
            layar.setText("");
        }

        if (arg0.getSource() == tombol_sama_dengan) {
            switch (operasi) {
                case "bagi" :
                hasil = angka_pertama / Double.valueOf(layar.getText());
                break;

                case "kali" :
                hasil = angka_pertama * Double.valueOf(layar.getText());
                break;

                case "kurang" :
                hasil = angka_pertama - Double.valueOf(layar.getText());
                break;

                case "tambah" :
                hasil = angka_pertama + Double.valueOf(layar.getText());
                break;
            }

            angka_pertama = hasil;
            layar.setText(String.valueOf(hasil));
        }

        if (arg0.getSource() == tombol_positif_negatif) {
            double temp = -1 * Double.valueOf(layar.getText());
            layar.setText(String.valueOf(temp));
        }
        
        if (arg0.getSource() == tombol_koma) {
            layar.setText(layar.getText().concat("."));
        }

        if (arg0.getSource() == tombol_delete) {
            String angka = layar.getText();
            layar.setText("");

            for (i = 0; i < angka.length() - 1; i++) {
                layar.setText(layar.getText() + angka.charAt(i));
            }
        }
    }
}

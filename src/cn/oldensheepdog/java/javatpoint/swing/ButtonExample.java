package cn.oldensheepdog.java.javatpoint.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");
        JButton b=new JButton("Click Here");
        b.setBounds(50,100,95,30);
        f.add(b);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

        JFrame frame=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        JButton button=new JButton("Click Here");
        button.setBounds(50,100,95,30);
        button.addActionListener(e -> tf.setText("Welcome to Javatpoint."));
        frame.add(b);frame.add(tf);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

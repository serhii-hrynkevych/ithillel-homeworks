package serhii.hrynkevych.classdescriptionext;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloFrame extends JFrame {

    public HelloFrame() {
        JButton btn = new JButton("Say 'Hello'");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Hello, world");
            }
        });

        add(btn, BorderLayout.NORTH);
        setBounds(100, 100, 200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        HelloFrame hf = new HelloFrame();
    }
}

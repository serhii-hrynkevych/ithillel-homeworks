package serhii.hrynkevych.shapeapplication;

import serhii.hrynkevych.shapeapplication.component.OvalComponent;
import serhii.hrynkevych.shapeapplication.component.RectangleComponent;
import serhii.hrynkevych.shapeapplication.component.TriangleComponent;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class ShapeFrame  extends JFrame {

    public ShapeFrame() {
        setLayout(new GridLayout(2, 3));

        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());
        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());

        setBounds(200, 200, 450, 350);
    }
}

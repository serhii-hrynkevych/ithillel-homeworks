package serhii.hrynkevych.shapeapplication2;

import serhii.hrynkevych.shapeapplication2.component.OvalComponent;
import serhii.hrynkevych.shapeapplication2.component.RectangleComponent;
import serhii.hrynkevych.shapeapplication2.component.TriangleComponent;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class ShapeFrame extends JFrame {

    public ShapeFrame() {
        // Устанавливаем LayoutManager в виде таблицы
        // размерами 2 строки на 3 столбца
        setLayout(new GridLayout(2, 3));

        // Создаем и "укладываем" на форму компоненты разных классов
        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());
        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());

        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 450, 350);
    }
}

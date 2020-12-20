package windows;

import windows.layout.MenuLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends Window {

    private final JButton continueWorldButton = new JButton("Продолжить эволюцию");
    private final JButton newWorldButton = new JButton("Новый мир");
    private final JButton loadWorldButton = new JButton("Загрузить мир");
    private final JButton exitWorldButton = new JButton("Выход");

    public Menu init() {
        super.init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new MenuLayout());
        contents.setBorder(BorderFactory.createEmptyBorder(100,20,100,20));

        exitWorldButton.addActionListener(e -> System.exit(0));

        // Добавим кнопки и текстовое поле в панель
        contents.add(continueWorldButton);
        contents.add(newWorldButton);
        contents.add(loadWorldButton);
        contents.add(exitWorldButton);

        // Размещаем панель в контейнере
        this.setContentPane(contents);

        return this;
    }

    @Override
    public WindowType getWindowType() {
        return WindowType.MENU;
    }

    @Override
    protected Dimension initSize() {
        return new Dimension(300, 500);
    }

    public void addNewWorldListener(ActionListener al) {
        newWorldButton.addActionListener(al);
    }

    public void addContinueWorldListener(ActionListener al) {
        continueWorldButton.addActionListener(al);
    }

    public void addLoadListener(ActionListener al) {
        loadWorldButton.addActionListener(al);
    }
}


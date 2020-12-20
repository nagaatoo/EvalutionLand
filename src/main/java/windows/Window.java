package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Window extends JFrame {

    private boolean isInitial = false;

    public Window init() {
        this.setTitle(getWindowType().toString());
        this.setSize(initSize());
        this.setPreferredSize(initSize());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        isInitial = true;
        return this;
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public void hideWindow() {
        this.setVisible(false);
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void addWindowForCloseOperation(Window w) {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                hideWindow();
                w.showWindow();
            }
        });
    }

    public void reloadStateWindow() {

    };

    public abstract WindowType getWindowType();

    protected abstract Dimension initSize();

}

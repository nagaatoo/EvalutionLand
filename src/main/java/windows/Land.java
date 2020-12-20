package windows;

import net.miginfocom.layout.Grid;
import units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Land extends Window {

    private JTable table = new JTable();
    private JButton pauseAndStart = new JButton("Старт");
    private JLabel numberOfUnit = new JLabel();
    private JLabel numberOfMan = new JLabel();
    private JLabel numberOfWoman = new JLabel();

    @Override
    public Window init() {
        super.init();
        this.setResizable(true);

//        var layout = new GridLayout(2, 1);
        var layout = new BorderLayout();
        var boardConstrain = new JPanel(layout);
        boardConstrain.add(buildFieldBar(), BorderLayout.CENTER);
        boardConstrain.add(buildMenuBar(), BorderLayout.SOUTH);

        this.add(boardConstrain);
        this.setPreferredSize(new Dimension(1000, 1000));
        pack();
        return this;
    }

    @Override
    public void reloadStateWindow() {
        this.getContentPane().removeAll();
        this.init();
    }

    @Override
    public WindowType getWindowType() {
        return WindowType.LAND;
    }

    @Override
    protected Dimension initSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        return new Dimension(1024, 768);
    }

    public void addUnits(List<Unit> units) {
        for (Unit unit : units) {
            table.add(unit);
        }
    }

    private Component buildMenuBar() {
        var panel = new JPanel(new BorderLayout());

        var buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(pauseAndStart);
        buttonPanel.add(new JButton("Выход"));
        panel.add(buttonPanel, BorderLayout.WEST);

        var statisticPanel = new JPanel(new GridLayout(3, 2));
        statisticPanel.add(new JLabel("Общее число популяции"));
        statisticPanel.add(numberOfUnit);
        statisticPanel.add(new JLabel("Мужчин"));
        statisticPanel.add(numberOfMan);
        statisticPanel.add(new JLabel("Женщин"));
        statisticPanel.add(numberOfWoman);

        numberOfMan.setText("0");
        numberOfWoman.setText("0");
        numberOfUnit.setText("0");

        panel.add(statisticPanel, BorderLayout.CENTER);
        return panel;
    }

    private Component buildFieldBar() {
        // Список компонентов формы
        var table = new JPanel(new GridLayout(1000, 1000));
        table.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        table.setPreferredSize(new Dimension(10000, 1000));
        var scroll = new JScrollPane(table);
//        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scroll.setMaximumSize(new Dimension(1024, 768));
//        scroll.setMinimumSize(new Dimension(1024, 768));
        return scroll;
    }

}

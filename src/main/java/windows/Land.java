package windows;

import common.Settings;
import units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Land extends Window {

    private final JPanel tableIn = new JPanel();
    private final JButton pauseAndStart = new JButton("Старт");
    private final JLabel numberOfUnit = new JLabel();
    private final JLabel numberOfMan = new JLabel();
    private final JLabel numberOfWoman = new JLabel();

    @Override
    public Window init() {
        super.init();
        this.setResizable(true);
//        table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.WHITE));

        var layout = new BorderLayout();
        var boardConstrain = new JPanel(layout);
        boardConstrain.add(buildFieldBar(), BorderLayout.CENTER);
        boardConstrain.add(buildMenuBar(), BorderLayout.SOUTH);

        this.add(boardConstrain);
        this.setPreferredSize(new Dimension(1000, 1000));

        this.revalidate();
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
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension(1024, 768);
    }

    public void addUnits(List<Unit> units) {
        int count = 0;
        for (Unit unit : units) {
            tableIn.add(unit);
            System.out.println(count++);
        }

        initUnits();
    }

    private void initUnits() {
//        table.revalidate();
//        table.repaint();
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
        int sizeSide = (int) Math.sqrt(Settings.getFieldSize());
        GridLayout layout = new GridLayout(sizeSide, sizeSide);
        System.out.println(layout.toString());
        tableIn.setLayout(layout);
        tableIn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        tableIn.setVisible(true);
        var scroll = new JScrollPane(tableIn);

        scroll.setVisible(true);
        return scroll;
    }

}

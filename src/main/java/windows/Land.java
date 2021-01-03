package windows;

import common.Settings;
import engine.MainEngine;
import units.EmptyUnit;
import units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Land extends Window {

    private final Random random = new Random();

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

        initButtonsListeners();
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
        Map<Integer, Unit> positions = new HashMap<>();
        for (Unit unit : units) {
            int index = getIndex(positions.keySet());
            positions.put(index, unit);
        }

        int fieldSize = Settings.getInstance().getFieldSize();
        int dimension = (int) Math.sqrt(fieldSize);
        for (var i = 0; i < fieldSize; i++) {
            Unit unit = positions.get(i);
            if (unit != null) {
                unit.setPosition(i % dimension, i / dimension);
                tableIn.add(unit, i);
            } else {
                tableIn.add(new EmptyUnit(), i);
            }
        }
    }

    public Land setNumberOfPeople(int number) {
        this.numberOfUnit.setText(String.valueOf(number));
        return this;
    }

    public Land setNumberOfMan(int number) {
        this.numberOfMan.setText(String.valueOf(number));
        return this;
    }

    public Land setNumberOfWoman(int number) {
        this.numberOfWoman.setText(String.valueOf(number));
        return this;
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
        int sizeSide = (int) Math.sqrt(Settings.getInstance().getFieldSize());
        GridLayout layout = new GridLayout(sizeSide, sizeSide);
        System.out.println(layout.toString());
        tableIn.setLayout(layout);
        tableIn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        tableIn.setVisible(true);
        var scroll = new JScrollPane(tableIn);

        scroll.setVisible(true);
        return scroll;
    }

    private void initButtonsListeners() {

        if (pauseAndStart.getActionListeners().length == 0) {
            pauseAndStart.addActionListener(l -> {
                if (!MainEngine.run) {
                    MainEngine.run = true;
                    pauseAndStart.setText("Стоп");
                    System.out.println("Стоп");
                } else {
                    MainEngine.run = false;
                    pauseAndStart.setText("Старт");
                    System.out.println("Старт");
                }
            });
        }
    }

    private int getIndex(Collection<Integer> pos) {
        int index = random.nextInt(Settings.getInstance().getFieldSize());
        if (pos.contains(index)) {
            getIndex(pos);
        }

        return index;
    }

}

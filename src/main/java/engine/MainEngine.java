package engine;

import common.Settings;
import enums.Gender;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import units.People;
import units.Unit;
import units.UnitFactory;
import windows.Land;
import windows.Menu;
import windows.Window;
import windows.WindowType;

import java.util.*;

public class MainEngine {

    private boolean isFirstRun = true;
    public static boolean run = false;
    private final static List<Window> windows = new ArrayList<>();

    private final Land land;

    {
        land = (Land) windows.stream()
                .filter(w -> w.getWindowType().equals(WindowType.LAND))
                .map(w -> !w.isInitial() ? w.init() : w)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private final List<Unit> units = new ArrayList<>();

    static {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()));

        List<Class<? extends Window>> classes = new ArrayList<>(reflections.getSubTypesOf(Window.class));
        classes.forEach(clazz -> {
            try {
                windows.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // Инициализация дефолтных настроек
        Settings.initSettings();
    }

    // Главный цикл приложения
    public void run() {

        if (isFirstRun) {
            initFirstRun();
        }

        if (windows.isEmpty()) {
            throw new NoSuchElementException();
        }

        while (true) {

            if (run) {
                updateLabels();
                gameIteration();
            }

        }
    }

    private void updateLabels() {
        int numberOfMan = (int) units.stream()
                .filter(u -> !u.isEmptyUnit())
                .filter(u -> Gender.M.equals(u.getGender()))
                .count();

        int numbberOfWoman = (int) units.stream()
                .filter(u -> !u.isEmptyUnit())
                .filter(u -> Gender.F.equals(u.getGender()))
                .count();

        int numberOfPeople = (int) units.stream()
                .filter(u -> !u.isEmptyUnit())
                .count();

        land.setNumberOfPeople(numberOfPeople)
                .setNumberOfMan(numberOfMan)
                .setNumberOfWoman(numbberOfWoman);
    }

    // Итерация мира
    private void gameIteration() {

    }

    private Window getWindow(WindowType type) {
        return windows.stream()
                .filter(w -> w.getWindowType().equals(type))
                .map(w -> !w.isInitial() ? w.init() : w)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private void initFirstRun() {
        Menu main = (Menu) getWindow(WindowType.MENU);
        main.showWindow();
        isFirstRun = false;

        main.addContinueWorldListener(a -> {
            main.hideWindow();
            land.showWindow();

            // TODO механизм загрузки последнего сейва
        });

        main.addNewWorldListener(a -> {
            units.addAll(UnitFactory.initFirstPeoples());

            land.addUnits(units);
            land.reloadStateWindow();
            main.hideWindow();
            land.showWindow();
            land.pack();
            updateLabels();
        });

        main.addLoadListener(a -> {
            Window load = getWindow(WindowType.LOAD);
            main.hideWindow();
            load.showWindow();

            // TODO загрузка
        });

        // Инициализация поведения закрытия окна
        windows.stream().forEach(w -> {
            if (!WindowType.MENU.equals(w.getWindowType())) {
                w.addWindowForCloseOperation(main);
            }
        });


    }

}

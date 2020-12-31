package engine;

import common.Settings;
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
    private final static List<Window> windows = new ArrayList<>();

    private final List<Unit> units = new ArrayList<>();

    static {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()));

        List<Class<? extends Window>> classes = new ArrayList<>(reflections.getSubTypesOf(Window.class));
        classes.forEach(clazz ->  {
            try {
                windows.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    // Главный цикл приложения
    public void run() {
        while (true) {
            if (windows.isEmpty()) {
                throw new NoSuchElementException();
            }

            if (isFirstRun) {
                initFirstRun();
            }

            gameIteration();
        }
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
            Window land = getWindow(WindowType.LAND);
            main.hideWindow();
            land.showWindow();

            // TODO механизм загрузки последнего сейва
        });

        main.addNewWorldListener(a -> {
            Land land = (Land) getWindow(WindowType.LAND);

            units.addAll(UnitFactory.initFirstPeoples());

            land.addUnits(units);
            land.reloadStateWindow();
            main.hideWindow();
            land.showWindow();
            land.pack();
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

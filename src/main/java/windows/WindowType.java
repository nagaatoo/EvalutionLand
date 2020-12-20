package windows;

public enum WindowType {

    LAND("Evaluation Land"),
    LOAD("Загрузка"),
    MENU("Меню эволюции");

    private String name;

    WindowType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

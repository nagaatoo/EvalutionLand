package common;

public final class Settings {

    private Settings() {

    }

    // Предельное количество юнитов в мире
    private static int beginNumberOfUnits = 25000;

    // Размер поля
    private static int fieldSize = 25000;

    public static void setBeginNumberOfUnits(int beginNumberOfUnits) {
        Settings.beginNumberOfUnits = beginNumberOfUnits % 2 != 0 ? beginNumberOfUnits + 1 : beginNumberOfUnits;
    }

    public static int getBeginNumberOfUnits() {
        return Settings.beginNumberOfUnits;
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public static void setFieldSize(int fieldSize) {
        Settings.fieldSize = fieldSize;
    }
}

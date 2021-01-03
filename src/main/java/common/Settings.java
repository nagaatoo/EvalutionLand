package common;

import java.io.Serializable;

public final class Settings implements Serializable {

    private Settings() {

    }

    private static Settings settings;

    // Начальное количество юнитов в мире
    private int beginNumberOfUnits = 12000;

    // Размер поля
    private int fieldSize = 62500;

    public void setBeginNumberOfUnits(int beginNumberOfUnits) {
        this.beginNumberOfUnits = beginNumberOfUnits % 2 != 0 ? beginNumberOfUnits + 1 : beginNumberOfUnits;
    }

    public int getBeginNumberOfUnits() {
        return this.beginNumberOfUnits;
    }

    public int getFieldSize() {
        return this.fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public static Settings getInstance() {
        return settings;
    }

    public static Settings initSettings() {
        settings = new Settings();
        return settings;
    }

    public static void initSettings(Settings seserSettings) {
        settings = seserSettings;
    }

}

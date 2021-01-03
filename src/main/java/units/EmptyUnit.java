package units;

import enums.Gender;
import enums.Go;
import units.disease.Disease;

import java.util.List;

public class EmptyUnit extends Unit {

    public static String EMPTY_FIELD = "Пустой юнит";

    @Override
    public boolean isEmptyUnit() {
        return true;
    }

    @Override
    public void goTo(Go go) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public String getNameUnit() {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit setNameUnit(String nameUnot) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Gender getGender() {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit setGender(Gender gender) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public int getAge() {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit setAge(int age) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit setPosition(int x, int y) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit addDisease(Disease disease) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public Unit addDisease(List<Disease> disease) {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }

    @Override
    public List<Disease> getDisease() {
        throw new UnsupportedOperationException(EMPTY_FIELD);
    }
}

package units;

import common.Position;
import enums.Gender;
import enums.Go;
import exception.EvalutionException;
import units.disease.Disease;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public abstract class Unit extends JLabel {

    // Координата в мире
    private final Position position = new Position();

    // Имя юнита
    private String nameUnot;

    // Пол
    private Gender gender;

    // Возраст юнита
    private int age;

    // Болезни юнита
    private final List<Disease> disease = new ArrayList<>();

    public Unit() {
        super();
        this.setVisible(true);
    }

    public String getNameUnit() {
        return nameUnot;
    }

    public Unit setNameUnit(String nameUnot) {
        this.nameUnot = nameUnot;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Unit setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Unit setAge(int age) {
        this.age = age;
        return this;
    }

    public Unit setPosition(int x, int y) {
        position.setPosition(x, y);
        return this;
    }

    public void goTo(Go go) {
        position.goTo(go);
    }

    public Unit addDisease(Disease disease) {
        this.disease.add(disease);
        return this;
    }

    public Unit addDisease(List<Disease> disease) {
        if (disease == null) {
            return this;
        }

        if (this.disease.isEmpty()) {
            this.disease.addAll(disease);
        } else {
            throw new EvalutionException("Нельзя перезаписать все болезни");
        }

        return this;
    }

    public List<Disease> getDisease() {
        return new ArrayList<>(this.disease);
    }
}

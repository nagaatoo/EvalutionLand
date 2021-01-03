package units;

import common.Position;
import enums.Gender;
import enums.Go;
import exception.EvalutionException;
import units.disease.Disease;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public abstract class Unit extends JLabel {

    private final UUID unitId = UUID.randomUUID();

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
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        Dimension dimension = new Dimension(30, 30);
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        addListener();
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

    public boolean isEmptyUnit() {
        return false;
    }

    private void addListener() {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setText("1");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return age == unit.age && Objects.equals(unitId, unit.unitId) && Objects.equals(nameUnot, unit.nameUnot) && gender == unit.gender && Objects.equals(disease, unit.disease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitId, nameUnot, gender, age, disease);
    }
}

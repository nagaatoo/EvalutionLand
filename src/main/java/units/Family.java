package units;

import exception.EvalutionException;

import java.util.ArrayList;
import java.util.List;

public class Family {

    private People father;
    private People mother;
    private final List<People> brotherAndSisters = new ArrayList<>();
    private People wifeOrHusband;
    private final List<People> childs = new ArrayList<>();

    public People getFather() {
        return father;
    }

    public Family setFather(People father) {
        this.father = father;
        return this;
    }

    public People getMother() {
        return mother;
    }

    public Family setMother(People mother) {
        this.mother = mother;
        return this;
    }

    public List<People> getBrotherAndSisters() {
        return new ArrayList<>(brotherAndSisters);
    }

    public Family addBrotherOrSister(People relative) {
        this.brotherAndSisters.add(relative);
        return this;
    }

    public Family addAllBrothersAndSisters(List<People> brotherAndSisters) {
        if (brotherAndSisters == null) {
            return this;
        }

        this.brotherAndSisters.addAll(brotherAndSisters);
        return this;
    }

    public People getWifeOrHusband() {
        return wifeOrHusband;
    }

    public Family setWifeOrHusband(People wifeOrHusband) {
        this.wifeOrHusband = wifeOrHusband;
        return this;
    }

    public List<People> getChilds() {
        return new ArrayList<>(childs);
    }

    public Family addChild(People child) {
        this.childs.add(child);
        return this;
    }
}

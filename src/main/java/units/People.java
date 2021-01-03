package units;

import java.awt.*;

public class People extends Unit {

    private Family family;

    public People() {
        super();
        this.setOpaque(true);
        this.setBackground(new Color(65, 148, 87));
//
    }

    public Family getFamily() {
        return family;
    }

    public People setFamily(Family family) {
        this.family = family;
        return this;
    }
}

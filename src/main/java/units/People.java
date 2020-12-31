package units;

import java.awt.*;

public class People extends Unit {

    private Family family;

    public Family getFamily() {
        return family;
    }

    public People setFamily(Family family) {
        this.family = family;
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        super.paintComponent(g);
    }
}

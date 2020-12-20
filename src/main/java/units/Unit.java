package units;

import common.Position;
import enums.Gender;
import enums.Go;

import java.awt.*;

public abstract class Unit extends Component {

    private final Position position = new Position();
    private String name;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPosition(int x, int y) {
        position.setPosition(x, y);
    }

    public void goTo(Go go) {
        position.goTo(go);
    }
}

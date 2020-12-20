package windows;

import java.awt.*;

public class Load extends Window {
    @Override
    public WindowType getWindowType() {
        return WindowType.LOAD;
    }

    @Override
    protected Dimension initSize() {
        return new Dimension(300, 500);
    }
}

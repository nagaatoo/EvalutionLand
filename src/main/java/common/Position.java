package common;

import enums.Go;

public class Position {

    private int x;
    private int y;

    public Position() {

    }

    public Position(int x, int y) {
        this.setPosition(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void goTo(Go go) {
        switch (go) {
            case UP: {
                y++;
                break;
            }
            case DOWN: {
                y--;
                break;
            }
            case LEFT: {
                x--;
                break;
            }
            case RIGHT: {
                x++;
                break;
            }
            case NORTHEAST: {
                y++;
                x++;
                break;
            }
            case NORTHWEST: {
                y++;
                x--;
                break;
            }
            case SOUTHEAST: {
                y--;
                x++;
                break;
            }
            case SOUTHWEST: {
                y--;
                x--;
                break;
            }
        }
    }
}

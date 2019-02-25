import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position = new Position(0, 0);

    public Hero(int i, int i1) {
        setX(i);
        setY(i1);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }


    public void setPosition(Position position) {
        setY(position.getY());
        setX(position.getX());
    }
}

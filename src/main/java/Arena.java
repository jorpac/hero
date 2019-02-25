import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int height, width;                  //  Generally constants(dimensions of the screen), but for usability purposes, can be changed
    Hero hero = new Hero(0, 0);
    Screen screen;
    public Arena(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public boolean processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case Character:
                if(key.getCharacter() == 'q') {
                    return false;
                }
                break;
        }
        return true;

    }

    public void draw(Screen screen) {
        screen.setCharacter(hero.getX(), hero.getY(), new TextCharacter('X'));
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
    if (position.getX()>width || position.getX() < 0)
        return false;
    if (position.getY() > height || position.getY()<0)
        return false;
    return true;
    }
}

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    Screen screen;
    private int x = 10;
    private int y = 10;
    Hero hero = new Hero(10, 10);
    com.googlecode.lanterna.input.KeyStroke key;

    public Game() {
        Terminal terminal;
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() {
        try {
            screen.clear();
            hero.draw(screen);
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {
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
                    try {
                        screen.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                break;
        }

    }

    public void run() {
        try {
            while(true) {
                draw();
                key = screen.readInput();
                processKey(key);
                if (key.getKeyType() == KeyType.EOF)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  moveHero(Position position) {
        hero.setPosition(position);
    }
}

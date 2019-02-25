public class Hero {
    private int x, y;

    public Hero(int i, int i1) {
        setX(i);
        setY(i1);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void moveUp(){
        setY(y-1);
    }
    public  void moveDown(){
        setY(y+1);
    }
    public void moveLeft(){
        setX(x-1);
    }
    public void moveRight(){
        setX(x+1);
    }
}

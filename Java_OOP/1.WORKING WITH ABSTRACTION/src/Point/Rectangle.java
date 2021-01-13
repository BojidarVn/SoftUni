package Point;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean withinX = bottomLeft.getX() <= point.getX() && topRight.getX() >= point.getX();

        boolean withinY= bottomLeft.getY() <= point.getY() && topRight.getY() >= point.getY();

        return withinX && withinY;
    }



}



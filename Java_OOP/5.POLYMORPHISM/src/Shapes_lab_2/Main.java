package Shapes_lab_2;

public class Main {
    public static void main(String[] args) {

        Shape first=new Circle(12D);

        System.out.println(first.calculateArea());
        System.out.println(first.calculatePerimeter());

        Shape second=new Rectangle(10D,5D);
        System.out.println(second.calculateArea());
        System.out.println(second.calculatePerimeter());
    }
}

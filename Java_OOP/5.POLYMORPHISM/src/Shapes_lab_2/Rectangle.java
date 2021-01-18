package Shapes_lab_2;

public class Rectangle extends Shape {
private Double height;
private Double width;

public Rectangle(Double height, Double width) {
    this.height=height;
    this.width=width;
}

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return getPerimeter();
        } else {
            Double param=2*this.height + this.width*2;
            super.setPerimeter(param);
            return param;
        }

    }

    @Override
    public Double calculateArea() {
        if (this.getArea() != null) {
            return this.getArea();
        } else {
            Double area=this.height*this.width;
            this.setArea(area);
            return area;
        }
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }
}

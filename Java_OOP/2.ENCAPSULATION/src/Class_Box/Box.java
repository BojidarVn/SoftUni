package Class_Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    //2 lw + 2 lh + 2 wh
    public double calculateSurfaceArea() {
        return 2 * this.getLength() * this.getWidth() +
                2 * this.getLength() * this.getHeight() +
                2 * this.getWidth() * this.getHeight();
    }

    // 2 lh + 2 wh
    public double calculateLateralSurfaceArea() {
        return 2 * this.getLength() * this.getHeight() +
                2 * this.getWidth() * this.getHeight();
    }
//double length, double width, double height
    public double calculateVolume() {
        return  this.getLength() *this.getWidth() * this.getHeight();
    }
}

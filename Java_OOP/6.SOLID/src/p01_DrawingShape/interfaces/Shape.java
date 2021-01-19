package p01_DrawingShape.interfaces;

public interface Shape {
    void draw(Rengerer rengerer, DrawingRepository drawingRepository);
    void print();
}

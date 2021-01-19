package p01_DrawingShape;

import p01_DrawingShape.interfaces.DrawingRepository;
import p01_DrawingShape.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeRepository implements DrawingRepository {
    private List<Shape> shapeList;

    public ShapeRepository() {
        this.shapeList =new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        shapeList.add(shape);

    }
    @Override
    public void   showAll() {
        for (Shape shape : shapeList) {
            shape.print();
        }
    }

    @Override
    public void drowBe() {

    }
}

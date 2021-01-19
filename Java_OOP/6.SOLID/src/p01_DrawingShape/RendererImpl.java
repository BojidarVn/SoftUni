package p01_DrawingShape;

import p01_DrawingShape.interfaces.DrawingRepository;
import p01_DrawingShape.interfaces.Rengerer;
import p01_DrawingShape.interfaces.Shape;

public class RendererImpl implements Rengerer {
    @Override
    public void render(Shape shape) {
     shape.print();

    }
}

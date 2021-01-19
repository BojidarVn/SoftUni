package p01_DrawingShape;

import p01_DrawingShape.interfaces.DrawingManager;
import p01_DrawingShape.interfaces.DrawingRepository;
import p01_DrawingShape.interfaces.Rengerer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DrawingRepository repository=new ShapeRepository();

        Rengerer rengerer=new RendererImpl();

     //  DrawingManager manager=new DrawingManagerImpl(repository,rengerer);
     //  manager.draw(new Rectangle(12,15));
    }
}

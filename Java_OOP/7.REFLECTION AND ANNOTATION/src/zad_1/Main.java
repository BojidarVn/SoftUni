package zad_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {



        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflection=new Reflection();

        Constructor<Reflection> ctor = clazz.getDeclaredConstructor(String.class,String.class,String.class);

        Reflection reflection1 = ctor.newInstance("First","Second", "Third");

        System.out.println(reflection1);




    }
}

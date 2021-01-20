package zad_2_lab;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Reflection reflection = new Reflection();

        Class<Reflection> clazz = Reflection.class;


        Method[] methods = clazz.getDeclaredMethods();

        // List<Method> getters = new ArrayList<>();
      //  List<Method> setters = new ArrayList<>();

        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters)
                .forEach(m ->
                        System.out.printf("%s will return  %s%n"
                                , m.getName()
                                , m.getReturnType().getName()));

        Method[] setters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters)
                .forEach(m ->
                        System.out.printf("%s will set field of %s%n"
                                , m.getName()
                                , m.getReturnType().getName()));



        //  for (Method method : methods) {
        //      if (method.getName().startsWith("get")) {
        //          getters.add(method);
        //      } else if (method.getName().startsWith("set")) {
        //          setters.add(method);
        //      }
        //  }

        //  getters.sort(Comparator.comparing(Method::getName));
        //  for (Method getter : getters) {
        //      System.out.printf("%s will return %s %s%n", getter.getName(),
        //              getter.getReturnType() == int.class ? "class" : ""
        //              , getter.getReturnType());
        //  }

        //  for (Method setter : setters) {
        //      System.out.printf("%s will set field of %s %s%n", setter.getName(),
        //              setter.getReturnType() == int.class ? "class" : ""
        //              ,setter.getParameterTypes()[0]);
        //  }


    }
}

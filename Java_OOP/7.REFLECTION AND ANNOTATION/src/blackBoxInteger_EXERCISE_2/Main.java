package blackBoxInteger_EXERCISE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line;

        BlackBoxInt blackBoxInt = null;

        try {
            Constructor<?> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Map<String,Method> methods=new HashMap<>();

        for (Method declaredMethod : blackBoxInt.getClass().getDeclaredMethods()) {
            methods.put(declaredMethod.getName(),declaredMethod);
        }

        while (!(line = bf.readLine()).equals("END")) {
            String[] tokens = line.split("_");

           Method method=methods.get(tokens[0]);
           method.setAccessible(true);
           method.invoke(blackBoxInt,Integer.parseInt(tokens[1]));

            Field declaredField = blackBoxInt.getClass().getDeclaredFields()[1];
            declaredField.setAccessible(true);

            System.out.println(declaredField.getInt(blackBoxInt));

        }


    }
}

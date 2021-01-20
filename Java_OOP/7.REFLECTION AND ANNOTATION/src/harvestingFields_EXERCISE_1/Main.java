package harvestingFields_EXERCISE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

        String line;

        while (!(line = bf.readLine()).equals("HARVEST")) {



        	// BABIshkiq na4in koito raboti

//            switch (line) {
//                case "private":
//                    for (Field declaredField : declaredFields) {
//                        int modifiers = declaredField.getModifiers();
//
//                        if (Modifier.isPrivate(modifiers)) {
//                            System.out.printf("private %s %s%n", declaredField.getType().getSimpleName(), declaredField.getName());
//                        }
//
//
//                    }
//                    break;
//
//                case "public":
//                    for (Field declaredField : declaredFields) {
//                        int modifiers = declaredField.getModifiers();
//
//                        if (Modifier.isPublic(modifiers)) {
//                            System.out.printf("public %s %s%n", declaredField.getType().getSimpleName(), declaredField.getName());
//                        }
//
//
//                    }
//                    break;
//                case "protected":
//                    for (Field declaredField : declaredFields) {
//                        int modifiers = declaredField.getModifiers();
//
//                        if (Modifier.isProtected(modifiers)) {
//                            System.out.printf("protected %s %s%n", declaredField.getType().getSimpleName(), declaredField.getName());
//                        }
//
//
//                    } 0887967682
//                    break;

			for (Field declaredField : declaredFields) {
				String modifierName = Modifier.toString(declaredField.getModifiers());
				if (line.equals(modifierName) || line.equals("all")) {
					System.out.printf("%s %s %s%n",modifierName ,declaredField.getType().getSimpleName(),declaredField.getName());
			}



            }
        }
    }


}

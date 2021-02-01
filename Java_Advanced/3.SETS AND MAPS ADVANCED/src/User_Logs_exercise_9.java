import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class User_Logs_exercise_9 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String line = "";

        TreeMap<String, LinkedHashMap<String, Integer>> usersLogs = new TreeMap<>();

        while (!(line = Scanner.nextLine()).equals("end")) {
            String[] tokens = line.split("\\s+");

            // [1] взима втората 4аст от tokens[0], защото самото tokens[0] има 0 и 1, а на нас ни трябва 1

            String ip = tokens[0].split("=")[1]; // от краината [1]
            String userName = tokens[2].split("=")[1];

            if (!usersLogs.containsKey(userName)) {
                //с долния ред може да си спестим писането на цялата логика в ИВ-а
                // usersLogs.put(userName,new LinkedHashMap<>() {{put(ip,1);}});
                LinkedHashMap<String, Integer> logs = new LinkedHashMap<>();
                logs.put(ip, 1);

                usersLogs.put(userName, logs);

            } else if (!usersLogs.get(userName).containsKey(ip)) {
                usersLogs.get(userName).put(ip, 1);

            } else {
                if (usersLogs.get(userName).containsKey(ip)) {
                    int count = usersLogs.get(userName).get(ip) + 1;
                    usersLogs.get(userName).put(ip, count);
                }


            }

        }
//        Dragon_Army_execise_14
        usersLogs.forEach((key,value) -> {
            System.out.println(key + ":");
            StringBuilder sb=new StringBuilder();
            value.forEach((innerKey,innerValue) ->{
               sb.append (String.format("%s => %d, ",innerKey,innerValue));
            });

            System.out.println((sb.substring(0,sb.length()-2) + "."));
        });
    }
}

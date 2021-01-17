package Military_Elite_EXERCISE__6;

import Military_Elite_EXERCISE__6.Interfaces.*;
import Military_Elite_EXERCISE__6.entities.*;
import Military_Elite_EXERCISE__6.eum.Corps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Private> soldiersByIds = new LinkedHashMap<>();
    private static Map<Integer, Spy> spyMap = new LinkedHashMap<>();


    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String input = Scanner.nextLine();

        while (!input.equals("End")) {

            Private soldier = createSolder(input);

            if (soldier != null) {

                soldiersByIds.put(soldier.getId(), soldier);
            }

            input = Scanner.nextLine();

            for (Soldier value : soldiersByIds.values()) {
                System.out.println(value.toString());
            }
        }
    }

    private static Private createSolder(String input) {
        String[] tokens = input.split("\\s+");

        String type = tokens[0];

        Private aPrivate;

        switch (type) {
            case "Private":
                aPrivate = new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2],
                        tokens[3],
                        Double.parseDouble(tokens[4]));
                break;
            case "LieutenantGeneral":
                aPrivate = createLieutenantGeneral(tokens);
                break;
            case "Engineer":
                aPrivate = createEngineer(tokens);


                break;
            case "Commando":
                aPrivate = createCommando(tokens);
                break;
            case "Spy":
                spyMap.put(Integer.parseInt(tokens[1]), new SpyImpl(Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[4]));

            default:
                aPrivate=null;
                break;
        }
        return aPrivate;
    }

    private static Private createCommando(String[] tokens) {
        String corps = tokens[5];
        if (corps.equals("AirForces") || corps.equals("Marines")) {
            Commando commando = new CommandoImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(corps.toUpperCase()));


            for (int i = 5; i < tokens.length; i += 2) {
                String codeName = tokens[i];
                String state = tokens[i + 1];

                if (!state.equals("inProgress") && !state.equals("finished")) {
                    continue;
                }

                Mission mission = new MissionsImpl(codeName,
                        state.equals("inProgress") ? MissionsImpl.Status.IN_PROGRESS
                                :MissionsImpl.Status.FINISHED
                );


                commando.addMission(mission);
            }
            return commando;

        }

        return null;
    }

    private static Private createEngineer(String[] tokens) {
        String corps = tokens[5];
        if (corps.equals("AirForces") || corps.equals("Marines")) {
            Engineer engineer = new EngineerImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(corps.toUpperCase()));

            for (int i = 5; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int hoursWorked = Integer.parseInt(tokens[i + 1]);
                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);
            }
            return engineer;

        }
        return null;

    }

    private static Private createLieutenantGeneral(String[] tokens) {
        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(
                Integer.parseInt(tokens[1]),
                tokens[2],
                tokens[3],
                Double.parseDouble(tokens[4]));

        for (int i = 5; i < tokens.length; i++) {
            lieutenantGeneral.addPrivate(soldiersByIds.get(Integer.parseInt(tokens[i])));
        }

        return lieutenantGeneral;

    }
}

package Calculator_EXERCISE_5;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new InputInterpreter(engine);
    }
}

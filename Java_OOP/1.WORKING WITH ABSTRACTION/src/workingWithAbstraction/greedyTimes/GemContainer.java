package workingWithAbstraction.greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class GemContainer {
    private Map<String, Long> gems;

    public GemContainer() {
        this.gems=new LinkedHashMap<>();
    }

    public long getSize() {
        return this.gems
                .values()
                .stream()
                .mapToLong(e ->e)
                .sum();
    }
}

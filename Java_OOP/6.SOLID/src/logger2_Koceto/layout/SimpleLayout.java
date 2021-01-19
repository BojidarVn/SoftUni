package logger2_Koceto.layout;

import logger2_Koceto.enums.ReportLevel;

public class SimpleLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",dateTime,reportLevel,message);
    }
}

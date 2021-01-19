package logger2_Koceto.layout;

import logger2_Koceto.enums.ReportLevel;

public interface Layout {

    String format (String dateTime, ReportLevel reportLevel, String message);
}

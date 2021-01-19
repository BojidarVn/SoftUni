package logger2_Koceto.appenders;

import logger2_Koceto.enums.ReportLevel;

public interface Appender {
    void append(String dateTime, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}

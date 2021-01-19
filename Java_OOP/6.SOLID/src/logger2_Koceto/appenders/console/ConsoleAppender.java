package logger2_Koceto.appenders.console;

import logger2_Koceto.appenders.Appender;
import logger2_Koceto.appenders.BaseAppender;
import logger2_Koceto.enums.ReportLevel;
import logger2_Koceto.layout.Layout;

public class ConsoleAppender extends BaseAppender  {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }


    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (super.checkIfReportLevelIsValid(reportLevel)) {
            System.out.println(super.getLayout().format(dateTime, reportLevel, message));
            super.setMessagesAppended(super.getMessagesAppended()+1);
        }
    }

@Override
    public String toString(){
        return super.toString();
}
}

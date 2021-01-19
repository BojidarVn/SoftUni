package logger2_Koceto.appenders.file;

import logger2_Koceto.appenders.Appender;
import logger2_Koceto.appenders.BaseAppender;
import logger2_Koceto.enums.ReportLevel;
import logger2_Koceto.layout.Layout;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (super.checkIfReportLevelIsValid(reportLevel)) {
            this.file.write(super.getLayout().format(dateTime, reportLevel, message));
            super.setMessagesAppended(super.getMessagesAppended()+1);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString(){
        return super.toString() + ", File size: " + this.file.getSize();
    }

}

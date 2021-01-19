package logger2_Koceto.appenders;

import logger2_Koceto.enums.ReportLevel;
import logger2_Koceto.layout.Layout;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    public BaseAppender(Layout layout) {
        this.layout = layout;
        messagesAppended=0;
    }

    public Layout getLayout() {
        return layout;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected boolean checkIfReportLevelIsValid(ReportLevel reportLevel) {
        return this.getReportLevel().ordinal() <= reportLevel.ordinal();

    }

    public int getMessagesAppended() {
        return this.messagesAppended;
    }

    public void setMessagesAppended(int messagesAppended) {
        this.messagesAppended = messagesAppended;
    }

    @Override
    public String toString() {
        return String.format("%nAppender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.getReportLevel(),
                this.getMessagesAppended());
    }
}

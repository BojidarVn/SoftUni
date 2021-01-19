package logger2_Koceto.layout;

import logger2_Koceto.enums.ReportLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("<log>")
                .append(System.lineSeparator())
                .append(String.format("\t<date>%s</date>", dateTime))
                .append(System.lineSeparator())
                .append(String.format("\t<level>%s</level>", reportLevel))
                .append(System.lineSeparator())
                .append(String.format("\t<message>%s</message>", message))
                .append(System.lineSeparator())
                .append("</log>");

        return sb.toString();
    }
}

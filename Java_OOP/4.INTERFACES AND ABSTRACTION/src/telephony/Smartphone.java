package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            if (isUrlValid(url)) {
                sb.append(String.format("Browsing: %s!", url));
            } else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            if (isNumberValid(number)) {
                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();

    }


    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }

        }
        return true;
    }

    private boolean isUrlValid(String url) {
        Pattern pattern = Pattern.compile("^[\\D]+$");
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

}

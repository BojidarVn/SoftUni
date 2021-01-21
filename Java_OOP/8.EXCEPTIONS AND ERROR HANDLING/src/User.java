public class User {
    private  String username;
    private  String password;

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword (password);
    }

    private void setPassword(String password) {
        boolean hasDigit=false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                break;
            }
        }

        if (!hasDigit) {
            throw new InvalidUserCreationException("Password Must contain at least one digit");
        }

        this.password=password;
    }

    private void setUsername(String username) {
        this.username=username;
    }
}

package Animal;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String asString;

    Gender(String asString) {
        this.asString=asString;
    }

    @Override
    public String toString() {
        return this.asString;
    }
}

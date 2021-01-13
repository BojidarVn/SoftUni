package StudentSystem;

public interface StudentRepository {

    /**
     * Check the repository contains a student with the given name.
     *
     * @param name of the student to look for.
     * @return true if is found, false otherwise.
     */
    boolean containsStudentWith(String name);

    /**
     * Given a student name return the student from the repository
     * @param name of the student to fetch
     * @return the student with the given name if present.
     * null if not present.
     */
    Student fetchBy(String name); // kato vtori na4in     Student fetchBy(String name);

    /**
     * Add student to the repository
     *
     * @param student to be persisted.
     */
    void save(Student student);
}

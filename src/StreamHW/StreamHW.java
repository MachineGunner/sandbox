package StreamHW;

import java.util.List;
import java.util.Objects;

public class StreamHW {
    public static void main(String[] args) {
        List<Student> list = getList();
        list.stream().
            filter(student -> student.age > 15 && Objects.equals(student.address.city, "New York")).
            flatMap(student -> student.grades.stream().map(grade -> new StudentGradeRecord(student.name, student.school, grade.subject, grade.score))).
            sorted((a, b) -> Double.compare(b.score(), a.score())).
            limit(3).
            forEach(System.out::println);
    }

    public static List<Student> getList() {
        List<Grade> listOlga = List.of(
            new Grade("Math", 99.5),
            new Grade("Physics", 85.0),
            new Grade("Chemistry", 72.0),
            new Grade("Literature", 83.2),
            new Grade("English", 86.5)
        );
        List<Grade> listZack = List.of(
                new Grade("Math", 75.2),
                new Grade("Physics", 84.0),
                new Grade("Chemistry", 68.4),
                new Grade("Literature", 92.7),
                new Grade("English", 81.0)
        );
        List<Grade> listMarkus = List.of(
                new Grade("Math", 96.7),
                new Grade("Physics", 79.4),
                new Grade("Chemistry", 89.4),
                new Grade("Literature", 75.6),
                new Grade("English", 93.0)
        );
        List<Grade> listGrace = List.of(
                new Grade("Math", 87.8),
                new Grade("Physics", 97.2),
                new Grade("Chemistry", 86.4),
                new Grade("Literature", 90.1),
                new Grade("English", 87.0)
        );
        List<Grade> listEmily = List.of(
                new Grade("Math", 95.5),
                new Grade("Physics", 96.9),
                new Grade("Chemistry", 83.0),
                new Grade("Literature", 87.5),
                new Grade("English", 95.0)
        );
        Address addressOlga = new Address("New York", "Street1");
        Address addressZack = new Address("New York", "Street2");
        Address addressMarkus = new Address("New York", "Street3");
        Address addressGrace = new Address("Los Angeles", "Street4");
        Address addressEmily = new Address("New York", "Street5");
        List<Student> list = List.of(
            new Student("Olga", 36, listOlga, "School1", addressOlga),
            new Student("Zack", 22, listZack, "School2", addressZack),
            new Student("Markus", 15, listMarkus, "School3", addressMarkus),
            new Student("Grace", 30, listGrace, "School3", addressGrace),
            new Student("Emily", 18, listEmily, "School3", addressEmily)
        );
        return list;
    }
}

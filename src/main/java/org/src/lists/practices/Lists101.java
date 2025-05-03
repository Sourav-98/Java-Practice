package org.src.lists.practices;

import org.src.lists.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lists101 - Practice ground for lists
 * <p>
 * Contains:
 * <p>
 * 1. List creation
 * 2. List sorting (with primitive types)
 * 3. List sorting (with objects)
 */
public class Lists101 {

    /**
     * Creates and returns a {@link List} containing two predefined string elements: "Hello" and "World".
     * <p>
     * Uses the `add()` method to insert new items into the list.
     *
     * @return A {@link List} of strings containing "Hello" and "World".
     */
    public static List<String> listsRunBasic() {
        // creating a new list
        List<String> myList = new ArrayList<>();
        // add new elements, one by one
        myList.add("Hello");
        myList.add("World");
        return myList;
    }

    /**
     * Creates and returns a {@link List} containing three predefined string elements:
     * "Hello", "My", and "World".
     * <p>
     * Uses the `Arrays.asList()` method to pre-initialize the list, and the `addAll()` method to add more elements.
     *
     * @return A {@link List} of strings containing "Hello", "My", and "World".
     */
    public static List<String> listsRun2() {
        List<String> myList = new ArrayList<>(Arrays.asList("Hello", "My", "World"));
        myList.addAll(Arrays.asList("Few", "more", "worlds"));
        return myList;
    }

    /**
     * Converts a variable number of string arguments into a {@link List} of strings.
     *
     * @param args Variable number of string arguments.
     * @return A {@link List} containing all the provided string arguments in the order they were passed.
     */
    public static List<String> listsRunVarArgs(String... args) {
        return new ArrayList<>(Arrays.asList(args));
    }

    /**
     * Accepts a variable number of {@link Integer} arguments, sorts them in ascending order,
     * and returns the sorted list. Demonstrates multiple sorting approaches,
     * with the final sorted list returned using Java Streams.
     *
     * @param args Variable number of integers to be sorted.
     * @return A {@link List} of integers sorted in ascending order.
     */
    public static List<Integer> listSortAsc(Integer... args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(args));
        // approach 1
        myList.sort(Comparator.comparingInt(a -> a));
        // approach 2 - old Java 1.2 utility approach (not to use with > Java 8)
        Collections.sort(myList);
        // approach 3
        myList = myList.stream().sorted().collect(Collectors.toList());
        return myList;
    }


    /**
     * Accepts a variable number of {@link Integer} arguments, sorts them in descending order,
     * and returns the sorted list. Demonstrates multiple sorting approaches,
     * with the final sorted list returned using Java Streams and {@link Comparator#reverseOrder()}.
     *
     * @param args Variable number of integers to be sorted.
     * @return A {@link List} of integers sorted in descending order.
     */
    public static List<Integer> listSortDesc(Integer... args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(args));
        // approach 1
        myList.sort((a, b) -> b - a);
        // approach 2 - old Java 1.2 utility approach (not to use with > Java 8)
        Collections.sort(myList, Comparator.reverseOrder());
        // approach 3
        myList = myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return myList;
    }

    /**
     * Accepts a variable number of {@link Student} objects, sorts them in ascending order
     * based on their date of birth, and returns the sorted list. Demonstrates multiple sorting
     * approaches, with the final sorted list returned using Java Streams and
     * {@link Comparator#comparing(java.util.function.Function)} on {@code getDateOfBirth()}.
     *
     * @param students Variable number of {@link Student} objects to be sorted.
     * @return A {@link List} of {@link Student} objects sorted by date of birth in ascending order.
     */
    public static List<Student> studentListSortAsc(Student... students) {
        List<Student> myStudents = new LinkedList<>(Arrays.asList(students));
        // approach 1
        myStudents.sort(Comparator.comparing(Student::getDateOfBirth));
        // approach 2
        myStudents.sort((Comparator.comparing((a) -> a.getDateOfBirth())));
        // approach 3
        myStudents = myStudents.stream()
                .sorted(Comparator.comparing(Student::getDateOfBirth))
                .collect(Collectors.toList());
        return myStudents;
    }

    /**
     * Accepts a variable number of {@link Student} objects, sorts them in descending order
     * based on their date of birth, and returns the sorted list. Demonstrates multiple sorting
     * approaches, with the final sorted list returned using Java Streams and
     * {@link Comparator#comparing(java.util.function.Function)} on {@code getDateOfBirth()}.
     *
     * @param students Variable number of {@link Student} objects to be sorted.
     * @return A {@link List} of {@link Student} objects sorted by date of birth in ascending order.
     */
    public static List<Student> studentListSortDesc(Student... students) {
        List<Student> myStudents = new LinkedList<>(Arrays.asList(students));
        // approach 1
        myStudents.sort(Comparator.comparing(Student::getDateOfBirth).reversed());
        // approach 2
        myStudents.sort((a, b) -> b.getDateOfBirth().compareTo(a.getDateOfBirth()));
        // approach 3
        myStudents = myStudents.stream()
                .sorted(Comparator.comparing(Student::getDateOfBirth).reversed())
                .collect(Collectors.toList());
        return myStudents;
    }


    public static void main(String[] args) {
        System.out.println("listsRunBasic ---- " + listsRunBasic());
        System.out.println("listsRun2 -------- " + listsRun2());
        System.out.println("listsRunVarArgs -- " + listsRunVarArgs("Hello", "from", "the", "multiverses"));
        System.out.println("listSortAsc ------ " + listSortAsc(3, 4, 2, 1, 6, 5, 4, 9, 8, 7, 2, 10));
        System.out.println("listSortDesc ----- " + listSortDesc(3, 4, 2, 1, 6, 5, 4, 9, 8, 7, 2, 10));
        System.out.println("studentListSortAsc ----- " + studentListSortAsc(
                new Student(100, "John", new Date((long) 1114573964 * 1000)),
                new Student(2, "Hank", new Date((long) 1481664991 * 1000)),
                new Student(54, "Jean", new Date((long) 1256763291 * 1000)),
                new Student(3, "Paul", new Date((long) 1597413169 * 1000)),
                new Student(76, "Sam", new Date((long) 1625256055 * 1000)),
                new Student(7, "Rose", new Date((long) 1625256055 * 1000))
        ));
        System.out.println("studentListSortDesc ----- " + studentListSortDesc(
                new Student(100, "John", new Date((long) 1114573964 * 1000)),
                new Student(2, "Hank", new Date((long) 1481664991 * 1000)),
                new Student(54, "Jean", new Date((long) 1256763291 * 1000)),
                new Student(3, "Paul", new Date((long) 1597413169 * 1000)),
                new Student(7, "Rose", new Date((long) 1625256055 * 1000)),
                new Student(76, "Sam", new Date((long) 1625256055 * 1000))
        ));
    }
}

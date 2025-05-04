package org.src.lists.practices;

import org.src.lists.dto.ComparableTeacher;
import org.src.lists.dto.Teacher;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java Comparable vs Comparator usage
 */
public class Comparisons101 {

    /**
     * Comparables
     * <p>
     * <p>
     * List sorting on primitive Integer type data.
     * <p>
     * This works because Integer implements Comparable.
     *
     * @param items
     * @return
     */
    static List<Integer> listSortPrimitiveInteger(Integer... items) {
        List<Integer> myList = new LinkedList<>(Arrays.asList(items));
        myList.sort(Comparator.comparingInt((a) -> a));
        return myList;
    }

    /**
     * Comparables
     * <p>
     * <p>
     * List sorting on primitive String type data.
     * <p>
     * This works because String implements Comparable.
     *
     * @param items
     * @return
     */
    static List<String> listSortPrimitiveStringReverse(String... items) {
        List<String> myList = new LinkedList<>(Arrays.asList(items));
        myList.sort(Comparator.reverseOrder());
        return myList;
    }

    /**
     * Comparables
     * <p>
     * <p>
     * This will not work as Teacher does not implement Comparable.
     *
     * @param teachers
     * @return
     * @throws ClassCastException
     */
    static List<Teacher> teachersListSort(Teacher... teachers) throws ClassCastException {
        List<Teacher> myTeachers = new ArrayList<>(Arrays.asList(teachers));
        // compilation error here -> since Teacher does not implement compareTo() from Comparable, it throws a compilation error
//        myTeachers.sort(Comparator.comparing((a) -> a));
        // run-time error here - Throws a ClassCastException
        myTeachers = myTeachers.stream().sorted().collect(Collectors.toList());
        return myTeachers;
    }

    /**
     * Comparables
     * <p>
     * <p>
     * ComparableTeacher implements Comparable. Hence, sorting using sort() works.
     *
     * @param teachers
     * @return
     */
    static List<ComparableTeacher> comparableTeachersListSort(ComparableTeacher... teachers) {
        List<ComparableTeacher> myTeachers = new ArrayList<>(Arrays.asList(teachers));
        // approach 1
        Collections.sort(myTeachers);
        // approach 2 - this by default sorts the objects, based on the dateOfBirth field, defined in compareTo()
        myTeachers = myTeachers.stream().sorted().collect(Collectors.toList());
        return myTeachers;
    }

    /**
     * Comparators
     *
     * @param teachers
     * @return
     */
    static List<Teacher> teachersListSortCustomComparator(Teacher... teachers) {
        List<Teacher> myTeachers = new ArrayList<>(Arrays.asList(teachers));
        // order only by date of birth
        myTeachers.sort(Comparator.comparing(Teacher::getDateOfBirth));
        // order by date of birth (in ascending order), then by name (in ascending order)
        myTeachers.sort(Comparator.comparing(Teacher::getDateOfBirth).thenComparing(Teacher::getName));
        // order by date of birth (in ascending order), then by name (in ascending order), then by rank (in descending order)
        myTeachers.sort(Comparator.comparing(Teacher::getDateOfBirth)
                .thenComparing(Teacher::getName)
                .thenComparing(Teacher::getRank, Comparator.reverseOrder()));
        return myTeachers;
    }

    public static void main(String[] args) {

        System.out.println("listSortPrimitiveInteger ----------- " + listSortPrimitiveInteger(12, 4, 23, 7, 5, 6, 98, 4, 2, 11, 9));
        System.out.println("listSortPrimitiveStringReverse ----- " + listSortPrimitiveStringReverse("Hello", "world", "World", "hello", "this", "Is", "a", "A", "bEautiful"));
        try {
            System.out.println("teachersListSort --------------- " + teachersListSort(
                    new Teacher(100, "John", new Date((long) 1114573964 * 1000), 65),
                    new Teacher(2, "Hank", new Date((long) 1481664991 * 1000), 4),
                    new Teacher(54, "Jean", new Date((long) 1256763291 * 1000), 23),
                    new Teacher(3, "Paul", new Date((long) 1597413169 * 1000), 54),
                    new Teacher(7, "Rose", new Date((long) 1625256055 * 1000), 10),
                    new Teacher(76, "Sam", new Date((long) 1625256055 * 1000), 88)
            ));
        } catch (Exception e) {
            System.out.println("List<Teacher> cannot be sorted via stream() as Teacher does not implement Comparable --- " + e);
        }
        System.out.println("comparableTeachersListSortReversed ---------- " + comparableTeachersListSort(
                new ComparableTeacher(100, "John", new Date((long) 1114573964 * 1000), 65),
                new ComparableTeacher(2, "Hank", new Date((long) 1481664991 * 1000), 4),
                new ComparableTeacher(54, "Jean", new Date((long) 1256763291 * 1000), 23),
                new ComparableTeacher(3, "Paul", new Date((long) 1597413169 * 1000), 54),
                new ComparableTeacher(7, "Rose", new Date((long) 1625256055 * 1000), 10),
                new ComparableTeacher(76, "Sam", new Date((long) 1625256055 * 1000), 88)
        ));
        System.out.println("teachersListSortCustomComparator ---------- " + teachersListSortCustomComparator(
                new Teacher(100, "John", new Date((long) 1114573964 * 1000), 65),
                new Teacher(2, "Hank", new Date((long) 1481664991 * 1000), 4),
                new Teacher(54, "Jean", new Date((long) 1256763291 * 1000), 23),
                new Teacher(3, "Paul", new Date((long) 1597413169 * 1000), 54),
                new Teacher(76, "Sam", new Date((long) 1625256055 * 1000), 88),
                new Teacher(23, "Rose", new Date((long) 1625256055 * 1000), 1),
                new Teacher(7, "Rose", new Date((long) 1625256055 * 1000), 10)
        ));
    }
}

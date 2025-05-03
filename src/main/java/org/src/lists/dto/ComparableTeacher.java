package org.src.lists.dto;

import java.util.Date;

/**
 * A subclass of {@link Teacher} that implements {@link Comparable} to allow comparison
 * between {@code ComparableTeacher} instances based on their date of birth.
 *
 * <p>This enables natural ordering of {@code ComparableTeacher} objects, such as when sorting
 * in a collection, using the {@code compareTo} method that compares {@code dateOfBirth} values.</p>
 */
public class ComparableTeacher extends Teacher implements Comparable<ComparableTeacher> {

    /**
     * Constructs a {@code ComparableTeacher} with the specified id, name, date of birth, and rank.
     *
     * @param id          the unique identifier of the teacher
     * @param name        the name of the teacher
     * @param dateOfBirth the date of birth of the teacher
     * @param rank        the rank of the teacher
     */
    public ComparableTeacher(Integer id, String name, Date dateOfBirth, Integer rank) {
        super(id, name, dateOfBirth, rank);
    }

    /**
     * Compares this {@code ComparableTeacher} to another based on date of birth.
     *
     * @param o the other {@code ComparableTeacher} to compare to
     * @return a negative integer, zero, or a positive integer as this object's
     * date of birth is before, equal to, or after the other object's date of birth
     */
    @Override
    public int compareTo(ComparableTeacher o) {
        return this.getDateOfBirth().compareTo(o.getDateOfBirth());
    }
}

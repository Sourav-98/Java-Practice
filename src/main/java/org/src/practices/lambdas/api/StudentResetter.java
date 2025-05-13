package org.src.practices.lambdas.api;

import org.src.practices.lambdas.dto.Student;

@FunctionalInterface
public interface StudentResetter {
    Student resetStudent(Student s);
}

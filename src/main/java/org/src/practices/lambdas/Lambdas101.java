package org.src.practices.lambdas;

import org.src.practices.lambdas.api.AreaCalculator;
import org.src.practices.lambdas.api.StudentResetter;
import org.src.practices.lambdas.api.VolumeCalculator;
import org.src.practices.lambdas.dto.Student;

public class Lambdas101 {
    static AreaCalculator ac = (x, y) -> (long)x * (long)y;
    static VolumeCalculator vc = (x, y, z) -> (long)x * (long)y * (long)z;
    static StudentResetter sReset = (x) -> { x.setId(0); x.setName("VOID"); x.setStandard(0); x.setMarks(0); return x;};

    public static void main(String[] args) {

        System.out.println(ac.getArea(4, 5));
        System.out.println(vc.getVolume(400000, 500000, 6000000));

        Student s = new Student(12, "Cain", 11);
        System.out.println(s);
        s = sReset.resetStudent(s);

        System.out.println(s);
    }

}

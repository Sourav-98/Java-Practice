package org.src.dto;

import lombok.*;

/**
 * FullCollisionEmployee always returns a hash code of 0, and .equals to true.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FullCollisionEmployee {
    private Integer id;
    private String name;
    private String department;
    private Integer salary;

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }
}

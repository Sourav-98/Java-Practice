package org.src.dto;

import lombok.*;

/**
 * HashCollisionEmployee always returns a hash code of 0, making it collision prone.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HashCollisionEmployee {
    private Integer id;
    private String name;
    private String department;
    private Integer salary;

    @Override
    public int hashCode() {
        return 0;
    }
}

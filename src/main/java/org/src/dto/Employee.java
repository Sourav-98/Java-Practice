package org.src.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    private Integer id;
    private String name;
    private String department;
    private Integer salary;
}

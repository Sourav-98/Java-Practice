package org.src.lists.dto;

import java.util.Date;
import java.util.Objects;

public class Student {
    private Integer id;
    private String name;
    private Date dateOfBirth;

    public Student(Integer id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.src.lists.dto.Student student)) return false;
        return getId().equals(student.getId()) && getName().equals(student.getName()) && getDateOfBirth().equals(student.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

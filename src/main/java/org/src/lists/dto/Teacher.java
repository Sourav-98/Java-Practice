package org.src.lists.dto;

import java.util.Date;
import java.util.Objects;

public class Teacher {
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private Integer rank;

    public Teacher(Integer id, String name, Date dateOfBirth, Integer rank) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.rank = rank;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return getId().equals(teacher.getId()) && getName().equals(teacher.getName()) && getDateOfBirth().equals(teacher.getDateOfBirth()) && getRank().equals(teacher.getRank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDateOfBirth(), getRank());
    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", rank=" + rank +
                '}';
    }
}

package pairmatching.domain;

import pairmatching.helper.Course;

import java.util.Objects;

public class Crew implements Comparable<Crew>{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(crewName, crew.crewName) && course == crew.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewName, course);
    }

    public String getCrewName() {
        return crewName;
    }

    @Override
    public String toString() {
        return crewName;
    }

    public Crew(String crewName, Course course)
    {
        this.course = course;
        this.crewName = crewName;
    }

    private final String crewName;
    private final Course course;

    @Override
    public int compareTo(Crew otherCrew) {
        if (otherCrew == null) {
            throw new NullPointerException("비교 대상이 null입니다.");
        }
        return this.crewName.compareTo(otherCrew.crewName);
    }
}

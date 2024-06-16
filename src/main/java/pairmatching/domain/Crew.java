package pairmatching.domain;

import pairmatching.helper.Course;

public class Crew implements Comparable<Crew>{

    public String getCrewName() {
        return crewName;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "crewName='" + crewName + '\'' +
                ", course=" + course +
                '}';
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

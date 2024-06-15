package pairmatching.domain;

import pairmatching.helper.Course;

public class Crew {
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
}

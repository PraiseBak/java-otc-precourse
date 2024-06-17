package pairmatching.domain;

import pairmatching.helper.Course;
import pairmatching.helper.Level;

import java.util.Objects;

public class PairMatchOption {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairMatchOption that = (PairMatchOption) o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    public PairMatchOption(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    final Course course;
    final Level level;
    final String mission;


    public static PairMatchOption of(String courseStr, String levelStr, String missionStr) {
        Course course = Course.fromString(courseStr);
        Level level = Level.fromString(levelStr);
        return new PairMatchOption(course,level,missionStr);
    }
}

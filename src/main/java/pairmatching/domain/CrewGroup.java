package pairmatching.domain;

import pairmatching.helper.Course;
import pairmatching.helper.ErrorEnum;

import java.util.ArrayList;
import java.util.List;

public class CrewGroup {
    List<Crews> crewsList = new ArrayList<>();

    public static CrewGroup from(List<Crews> initialCrewsListFromFile) {
        return new CrewGroup(initialCrewsListFromFile);
    }

    public CrewGroup(List<Crews> crewsList){
        this.crewsList = crewsList;
    }

    public Crews getCrewsByCourse(Course course){
        return this.crewsList.stream()
                .filter((crews) -> crews.getCourse() == course)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorEnum.INVALID_COURSE.getErrorText()));
    }

}

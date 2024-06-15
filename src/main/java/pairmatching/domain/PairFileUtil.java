package pairmatching.domain;

import pairmatching.helper.Course;
import pairmatching.helper.ErrorEnum;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 파일로 초기 Crews 설정하는 클래스
 */
public class PairFileUtil {
    private static final String BASE_DIR_SRC = "src/main/resources/";

    private static final String BACKEND_CREW_INPUT_SRC = "backend-crew.md";
    private static final String FRONTEND_CREW_INPUT_SRC = "frontend-crew.md";
    public static Crews getInitialCrewsFromFile() {
        File backendCrewFile = new File(BASE_DIR_SRC + BACKEND_CREW_INPUT_SRC);
        File frontendCrewFile = new File(BASE_DIR_SRC + FRONTEND_CREW_INPUT_SRC);
        String backendCrewStr = readLineFromFile(backendCrewFile);
        String frontendCrewStr = readLineFromFile(frontendCrewFile);
        Crews backendCrews = parsePairFromStr(backendCrewStr,Course.BACKEND);
        Crews frontendCrews = parsePairFromStr(frontendCrewStr,Course.FRONTEND);
        Crews combinedCrews= backendCrews.combine(frontendCrews);
        return combinedCrews;
    }

    private static Crews parsePairFromStr(String crewStr, Course course) {
        List<String> crewNameArr = Arrays.stream(crewStr.split(" ")).collect(Collectors.toList());
        return Crews.of(crewNameArr,course);
    }

    private static String readLineFromFile(File file){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = bufferedReader.readLine();
            return s;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(ErrorEnum.FILE_DOES_NOT_EXISTS.getErrorText());
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorEnum.FILE_CANNOT_READ.getErrorText());
        }
    }



}

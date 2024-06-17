package pairmatching.helper;


import pairmatching.ViewTextEnum;

public enum ErrorEnum {
    FILE_DOES_NOT_EXISTS("존재하지 않는 파일입니다."),
    FILE_CANNOT_READ("파일 내용을 읽을 수 없습니다."),
    INPUT_INVALID("유효하지 않은 입력입니다."),
    CREATE_PAIR_FAIL("페어 생성에 실패하였습니다"),
    INVALID_COURSE("존재하지 않는 코스입니다");



    ErrorEnum(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }

    String errorText;

}

package pairmatching.helper;

/**
 * 파일로 초기 Crews 설정하는 클래스
 */
public class InputValidCheck {
    public static boolean checkInputFuntionOptionValid(String s){
        try{
            int num = Integer.parseInt(s);
            if(num >= 1 && num <= 3) return true;
            return false;
        }catch (NumberFormatException e){
            if(s.equals("Q")) return true;
            throw new IllegalArgumentException(ErrorEnum.INPUT_INVALID.getErrorText());
        }
    }


}

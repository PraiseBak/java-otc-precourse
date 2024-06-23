package domain;

public enum CardType {
    CLOVER("클로버"),
    DIAMOND("다이아몬드"),
    HEART("하트"),
    SPACE("스페이스");

    CardType(String type) {
        this.type = type;
    }

    private final String type;

    public Object getCardTypeStr() {
        return type;
    }
}

package pairmatching.helper;
public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level fromString(String name) {
        for (Level course : Level.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
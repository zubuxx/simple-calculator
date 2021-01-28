package pl.rownicki.config;

public class Config {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 300;
    private static final int NUMS_LIMIT = 14;

    public static int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public static int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public static int getNUMS_LIMIT() {
        return NUMS_LIMIT;
    }
}

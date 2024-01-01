package logger.data;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(4),
    FATAL(5);

    private final int level;
    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

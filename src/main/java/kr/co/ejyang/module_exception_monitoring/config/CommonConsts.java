package kr.co.ejyang.module_exception_monitoring.config;

public interface CommonConsts {

    // Exception 레벨 상수
    public static final String DEBUG    = "DEBUG";
    public static final String INFO     = "INFO";
    public static final String WARN     = "WARN";
    public static final String ERROR    = "ERROR";
    public static final String FATAL    = "FATAL";

    // Exception 레벨 상수 그룹
    public static final String[] LEVEL_LIST    = { DEBUG, INFO, WARN, ERROR, FATAL };

}

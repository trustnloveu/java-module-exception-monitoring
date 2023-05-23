# java-module-exception-monitoring
@ControllerAdvice, @ExceptionHandler 에서 확인되는 에러 관리 모듈

## 실행환경
+ 프로그래밍 언어 : Java 17.0.7
+ 프레임워크 : Spring Boot 3.0.5
+ 저장소 관리 : Gradle 7.4


## 프로젝트 구성
```shell
module-exception-monitoring
└── src
    ├── main.java
    │   └── kr.co.ejyang
    │       ├── MainApplication.java
    │       └── module_exception_monitoring
    │           ├── config
    │           │         └── DatabaseConfiguration.java
    │           ├── dto
    │           │         └── MonitoringDto.java
    │           ├── mapper
    │           │         └── MonitoringMapper.java
    │           └── service
    │               ├── MonitoringService.java
    │               └── MonitoringServiceImpl.java
    └── resources
        ├── config
        │         └── mybatis-config.xml
        ├── resources-dev
        │         └── application.properties
        ├── resources-local
        │         └── application.properties
        ├── resources-prod
        │         └── application.properties
        └── sql
            └── monitoring_SQL.xml
```


## 호출 서비스
+ fetchAllExceptionHistory : 전체 에러 히스토리 조회 
+ insertExceptionHistory : 에러 등록
+ updateExceptionHistory : 에러 갱신 (알람 발송 시)

## 테이블 DDL
```sql
CREATE TABLE `exception_monitoring` (
    `idx` bigint AUTO_INCREMENT,
    `app_name` varchar(20) NOT NULL,
    `level` varchar(10) NOT NULL,
    `type` varchar(50) NOT NULL,
    `detail` varchar(1000) NOT NULL,
    `alarm_yn` char(1) NOT NULL DEFAULT 'Y',
    `reg_date` datetime NOT NULL,
    `alarm_date` datetime DEFAULT NULL,
    PRIMARY KEY (`idx`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
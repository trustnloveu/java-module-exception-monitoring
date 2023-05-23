package kr.co.ejyang.module_exception_monitoring.service;

import kr.co.ejyang.module_exception_monitoring.dto.MonitoringDto;

import java.util.List;

public interface MonitoringService {

    /*******************************************************************************************
     * 에러 히스토리 조회 - 전체
     *******************************************************************************************/
    List<MonitoringDto.Select> fetchAllExceptionHistory();

    /*******************************************************************************************
     * 에러 등록
     *******************************************************************************************/
    void insertExceptionHistory(String appName, String level, String type, String detail);

    /*******************************************************************************************
     * 에러 갱신 - 알람 발송
     *******************************************************************************************/
    void updateExceptionHistory(long idx, String alarmYn);

}

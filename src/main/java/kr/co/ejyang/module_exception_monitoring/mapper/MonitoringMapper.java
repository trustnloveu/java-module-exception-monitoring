package kr.co.ejyang.module_exception_monitoring.mapper;

import kr.co.ejyang.module_exception_monitoring.dto.MonitoringDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MonitoringMapper {

    /*******************************************************************************************
     * 에러 히스토리 조회 - 전체
     *******************************************************************************************/
    List<MonitoringDto.Select> fetchAllExceptionHistory();

    /*******************************************************************************************
     * 에러 히스토리 조회 - 검색
     *******************************************************************************************/
    List<MonitoringDto.Select> fetchExceptionHistoryBySearch(@Param("dto") MonitoringDto.Select dto);

    /*******************************************************************************************
     * 에러 히스토리 조회 - 알람 미발송
     *******************************************************************************************/
    List<MonitoringDto.Select> fetchAllExceptionHistoryAlarmNotSent();

    /*******************************************************************************************
     * 에러 등록
     *******************************************************************************************/
    void insertExceptionHistory(@Param("dto") MonitoringDto.Insert dto);

    /*******************************************************************************************
     * 에러 갱신 - 알람 발송 유무
     *******************************************************************************************/
    void updateExceptionHistoryByAlarmSent(@Param("idx") long idx);

    /*******************************************************************************************
     * INDEX 생성 ( alarm_yn, app_name, level )
     *******************************************************************************************/
    void createAlarmIndex();
    void createAppNameIndex();
    void createLevelIndex();

    /*******************************************************************************************
     * INDEX 삭제 ( alarm_yn, app_name, level )
     *******************************************************************************************/
    void dropAlarmIndex();
    void dropAppNameIndex();
    void dropLevelIndex();

}

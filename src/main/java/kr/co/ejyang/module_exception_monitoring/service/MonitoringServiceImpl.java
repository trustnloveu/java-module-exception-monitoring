package kr.co.ejyang.module_exception_monitoring.service;

import jakarta.validation.Valid;
import kr.co.ejyang.module_exception_monitoring.dto.MonitoringDto;
import kr.co.ejyang.module_exception_monitoring.mapper.MonitoringMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MonitoringServiceImpl implements MonitoringService {

    private final MonitoringMapper monitoringMapper;

    // 생성자
    MonitoringServiceImpl(@Autowired MonitoringMapper monitoringMapper) {
        this.monitoringMapper = monitoringMapper;
    }

    // #########################################################################################
    //                                      [ PUBLIC ]
    // #########################################################################################

    /*******************************************************************************************
     * 에러 히스토리 조회 - 전체
     *******************************************************************************************/
    @Override
    public List<MonitoringDto.Select> fetchAllExceptionHistory() {
        return monitoringMapper.fetchAllExceptionHistory();
    }

    /*******************************************************************************************
     * 에러 히스토리 조회 - 검색
     *******************************************************************************************/
    @Override
    public List<MonitoringDto.Select> fetchExceptionHistoryBySearch(@Valid MonitoringDto.Select dto) {
        return monitoringMapper.fetchExceptionHistoryBySearch(dto);
    }

    /*******************************************************************************************
     * 에러 히스토리 조회 - 알람 미발송
     *******************************************************************************************/
    @Override
    public List<MonitoringDto.Select> fetchAllExceptionHistoryAlarmNotSent() {
        return monitoringMapper.fetchAllExceptionHistoryAlarmNotSent();
    }

    /*******************************************************************************************
     * 에러 등록
     *******************************************************************************************/
    @Override
    public void insertExceptionHistory(@Valid MonitoringDto.Insert dto) {
        monitoringMapper.insertExceptionHistory(dto);
    }

    /*******************************************************************************************
     * 에러 갱신 - 알람 발송 유무
     *******************************************************************************************/
    @Override
    public void updateExceptionHistoryByAlarmSent(long idx) {
        monitoringMapper.updateExceptionHistoryByAlarmSent(idx);
    }

    /*******************************************************************************************
     * INDEX 생성 ( alarm_yn, app_name, level )
     *******************************************************************************************/
    @Override
    public void createIndex() {
        monitoringMapper.createAlarmIndex();
        monitoringMapper.createAppNameIndex();
        monitoringMapper.createLevelIndex();
    }

    /*******************************************************************************************
     * INDEX 삭제 ( alarm_yn, app_name, level )
     *******************************************************************************************/
    @Override
    public void dropIndex() {
        monitoringMapper.dropAlarmIndex();
        monitoringMapper.dropAppNameIndex();
        monitoringMapper.dropLevelIndex();
    }


    // #########################################################################################
    //                                      [ PRIVATE ]
    // #########################################################################################

}

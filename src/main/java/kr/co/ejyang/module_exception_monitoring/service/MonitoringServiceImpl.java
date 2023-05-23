package kr.co.ejyang.module_exception_monitoring.service;

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
     * 에러 등록
     *******************************************************************************************/
    @Override
    public void insertExceptionHistory(String appName, String level, String type, String detail) {
        try {
            MonitoringDto.Insert dto = MonitoringDto.Insert.builder()
                    .appName(appName)
                    .level(level)
                    .type(type)
                    .detail(detail)
                    .build();

            monitoringMapper.insertExceptionHistory(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*******************************************************************************************
     * 에러 갱신 - 알람 발송 유무
     *******************************************************************************************/
    public void updateExceptionHistory(long idx, String alarmYn) {
        try {
            MonitoringDto.Update dto = MonitoringDto.Update.builder()
                    .idx(idx)
                    .alarmYn(alarmYn)
                    .build();

            monitoringMapper.updateExceptionHistory(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
}


    // #########################################################################################
    //                                      [ PRIVATE ]
    // #########################################################################################

}

package kr.co.ejyang.module_exception_monitoring.mapper;

import jakarta.validation.Valid;
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
     * 에러 등록
     *******************************************************************************************/
    void insertExceptionHistory(
            @Param("dto")
            @Valid
            MonitoringDto.Insert dto
    );

    /*******************************************************************************************
     * 에러 갱신 - 알람 발송 유무
     *******************************************************************************************/
    void updateExceptionHistory(
            @Param("dto")
            @Valid
            MonitoringDto.Update dto
    );

}

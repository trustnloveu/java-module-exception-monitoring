package kr.co.ejyang.module_exception_monitoring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

public class MonitoringDto {

    // 조회
    @Data
    @NoArgsConstructor
    public static class Select {
        public long idx;
        public String appName;
        public String level;
        public String type;
        public String detail;
        public String alarmYn;
        public Date regDate;
        public Date alarmDate;
    }

    // 등록
    @Builder
    @AllArgsConstructor
    public static class Insert {
        @NotBlank
        public String appName;

        @NotBlank
        public String level;

        @NotBlank
        public String type;

        @NotBlank
        public String detail;

        @NotBlank
        @Pattern(regexp = "^[YN]$")
        public String alarmYn;
    }

    // 갱신
    @Builder
    @AllArgsConstructor
    public static class Update {
        @NotBlank
        @Positive
        public long idx;

        @NotBlank
        @Pattern(regexp = "^[YN]$")
        public String alarmYn;
    }

}

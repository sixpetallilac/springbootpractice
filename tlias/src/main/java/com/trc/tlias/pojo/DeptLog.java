package com.trc.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}

package com.scheduler.mock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    private Long id;
    private String beanName;
    private Integer maxLockDuration;
    private String taskName;
    private String status;
    private String pathValue;
    private Long finishTaskId;
    private List<RequestHeader> requestHeaders;
    private List<TaskCron> crons;
    private RequestBody requestBody;
}

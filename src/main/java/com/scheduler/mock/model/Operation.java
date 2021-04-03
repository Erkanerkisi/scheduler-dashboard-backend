package com.scheduler.mock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    private Long id;
    private String code;
    private String uri;
    private String method;
    private String className;
    private String callSystem;
    private Instant createdAt;
    private String createdUser;
    private Instant updatedAt;
    private String updatedUser;
}

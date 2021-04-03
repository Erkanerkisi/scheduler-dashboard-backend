package com.scheduler.mock.service;

import com.scheduler.mock.model.Operation;
import com.scheduler.mock.model.RequestHeader;
import com.scheduler.mock.model.Task;
import com.scheduler.mock.model.TaskCron;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperationService {

    private static List<Operation> operations = new ArrayList<>();

    @PostConstruct
    public void init() {
        operations = createOperations();
    }

    public void updateOperation(Long opId, Operation operation) {

        for (int i = 0; i < operations.size(); i++) {
            if(operations.get(i).getId().equals(opId)){
                operations.remove(i);
                operations.add(i, operation);
            }
        }
    }

    public void addOperation(Operation op) {
        Long a = operations.stream().map(e -> e.getId()).max(Long::compare).get();
        op.setId(a + 1L);
        operations.add(op);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public List<Operation> createOperations() {
        List<Operation> l = new ArrayList<>();

        Operation operation = Operation.builder()
                .id(1L)
                .code("mdlbackoffice:-get-worksite")
                .uri("https://askdmakj.com.tr")
                .method("GET")
                .className("simpleOperation")
                .callSystem("default")
                .createdAt(Instant.now())
                .createdUser("eko.eko")
                .updatedUser("eko.eko")
                .updatedAt(Instant.now()).build();
        l.add(operation);


        Operation operation3 = operation.builder()
                .id(2L)
                .code("mdlbackoffice:-get-worksite222222")
                .uri("https://askdmakjasdasd.com.tr")
                .method("POST")
                .className("simpleOperation")
                .callSystem("default")
                .createdAt(Instant.now())
                .createdUser("eko.eko")
                .updatedUser("eko.eko")
                .updatedAt(Instant.now()).build();
        l.add(operation3);
        return l;
    }
}

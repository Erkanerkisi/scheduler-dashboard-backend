package com.scheduler.mock.controller;

import com.scheduler.mock.model.Operation;
import com.scheduler.mock.model.Task;
import com.scheduler.mock.service.OperationService;
import com.scheduler.mock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public List<Operation> getOperations() {
        return operationService.getOperations();
    }

    @PostMapping(value = "/operation")
    public ResponseEntity<?> addOperation(@RequestBody Operation operation) {
        System.out.println("task: " + operation);
        operationService.addOperation(operation);
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @PutMapping(value = "/operation/{operationId}")
    public ResponseEntity<?> updateOperation(@NonNull @PathVariable Long operationId, @RequestBody Operation operation) {
        System.out.println("taskId: " + operationId);
        System.out.println("task: " + operation);
        operationService.updateOperation(operationId, operation);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/operation/{operationId}")
    public ResponseEntity<?> updateOperation(@NonNull @PathVariable Long operationId) {
        System.out.println("operationId: " + operationId);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

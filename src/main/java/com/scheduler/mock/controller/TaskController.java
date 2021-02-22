package com.scheduler.mock.controller;

import com.scheduler.mock.model.Task;
import com.scheduler.mock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/scheduled-tasks")
    public List<Task> getScheduledTasks() {
        return taskService.getScheduledTasks();
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping(value = "/task")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        System.out.println("task: " + task);
        taskService.addTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping(value = "/task/{taskId}")
    public ResponseEntity<?> updateTask(@NonNull @PathVariable Long taskId, @RequestBody Task task) {
        System.out.println("taskId: " + taskId);
        System.out.println("task: " + task);
        taskService.updateTask(taskId, task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping(value = "/task/{taskId}")
    public ResponseEntity<?> updateTask(@NonNull @PathVariable Long taskId) {
        System.out.println("taskId: " + taskId);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

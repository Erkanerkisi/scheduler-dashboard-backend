package com.scheduler.mock.service;

import com.scheduler.mock.model.RequestHeader;
import com.scheduler.mock.model.Task;
import com.scheduler.mock.model.TaskCron;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class TaskService {

    private static List<Task> tasks = new ArrayList<>();
    private static List<Task> scheduledTasks = new ArrayList<>();

    @PostConstruct
    public void init() {

        tasks = createTasks();
        scheduledTasks = createScheduledTasks();
    }

    public void updateTask(Long taskId, Task task) {

        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId().equals(taskId)){
                tasks.remove(i);
                tasks.add(i, task);
            }
        }
    }

    public void addTask(Task task) {
        Long a = tasks.stream().map(e -> e.getId()).max(Long::compare).get();
        task.setId(a + 1L);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getScheduledTasks() {
        return scheduledTasks;
    }

    public List<Task> createTasks() {
        List<Task> l = new ArrayList<>();
        List<RequestHeader> headers = new ArrayList<>();
        RequestHeader requestHeader = RequestHeader.builder().id(1L).key("operation-code").value("Lolo").build();
        RequestHeader requestHeader2 = RequestHeader.builder().id(2L).key("content-type").value("json").build();
        headers.add(requestHeader);
        headers.add(requestHeader2);

        List<TaskCron> crons = new ArrayList<>();
        TaskCron c1 = TaskCron.builder().id(1L).cronValue("* 5 * * * *").build();
        crons.add(c1);

        Task task = Task.builder()
                .id(1L)
                .pathValue("/api/gery/query")
                .taskName("Task ! is important!")
                .beanName("simpleScheduler")
                .maxLockDuration(50)
                .status("Active")

                .requestHeaders(headers)
                .crons(crons).build();
        l.add(task);


        List<RequestHeader> headers2 = new ArrayList<>();
        RequestHeader requestHeader3 = RequestHeader.builder().id(1L).key("operation-code").value("Lolo").build();
        RequestHeader requestHeader4 = RequestHeader.builder().id(2L).key("content-type").value("json").build();
        headers2.add(requestHeader3);
        headers2.add(requestHeader4);

        List<TaskCron> crons2 = new ArrayList<>();
        TaskCron c2 = TaskCron.builder().id(1L).cronValue("* 15 * * * *").build();
        crons2.add(c2);

        Task task2 = Task.builder()
                .id(2L)
                .pathValue("/api/gery/query2")
                .taskName("Task 123123! is important!")
                .beanName("coreScheduler")
                .maxLockDuration(150)
                .status("Passive")
                .requestHeaders(headers2)
                .crons(crons2).build();
        l.add(task2);
        return l;
    }

    public List<Task> createScheduledTasks() {
        List<Task> tasks = new ArrayList<>();
        List<RequestHeader> headers = new ArrayList<>();
        RequestHeader requestHeader = RequestHeader.builder().id(1L).key("operation-code").value("Lolo").build();
        RequestHeader requestHeader2 = RequestHeader.builder().id(2L).key("content-type").value("json").build();
        headers.add(requestHeader);
        headers.add(requestHeader2);

        List<TaskCron> crons = new ArrayList<>();
        TaskCron c1 = TaskCron.builder().id(1L).cronValue("* 5 * * * *").build();
        crons.add(c1);

        Task task = Task.builder()
                .id(1L)
                .pathValue("/api/gery/query")
                .taskName("Scheduled Task ! is important!")
                .beanName("simpleScheduler")
                .maxLockDuration(50)
                .status("Active")
                .requestHeaders(headers)
                .crons(crons).build();
        tasks.add(task);


        List<RequestHeader> headers2 = new ArrayList<>();
        RequestHeader requestHeader3 = RequestHeader.builder().id(1L).key("operation-code").value("Lolo").build();
        RequestHeader requestHeader4 = RequestHeader.builder().id(2L).key("content-type").value("json").build();
        headers2.add(requestHeader3);
        headers2.add(requestHeader4);

        List<TaskCron> crons2 = new ArrayList<>();
        TaskCron c2 = TaskCron.builder().id(1L).cronValue("* 15 * * * *").build();
        crons.add(c2);

        Task task2 = Task.builder()
                .id(2L)
                .pathValue("/api/gery/query2")
                .taskName("Scheduled Task 123123! is important!")
                .beanName("coreScheduler")
                .maxLockDuration(150)
                .status("Active")
                .requestHeaders(headers2)
                .crons(crons2).build();
        tasks.add(task2);

        return tasks;
    }
}

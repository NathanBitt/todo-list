package com.nb.dev.todo_list.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private Integer priority;
    private Boolean isReleased;

    public Todo(){}


    public Todo(String task, Integer priority, Boolean isReleased) {
        this.task = task;
        this.priority = priority;
        this.isReleased = isReleased;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getReleased() {
        return isReleased;
    }

    public void setReleased(Boolean released) {
        isReleased = released;
    }
}

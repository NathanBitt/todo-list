package com.nb.dev.todo_list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tbl_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    @NotBlank(message = "a task não pode ser nula")
    private String task;
    //@Size(min = 1, max = 3, message = "a priority deve ser entre 1 e 3, sendo 3 a mais alta")
    @Min(value = 1, message = "priority deve sentre 1-3, sendo 1 a mais alta")
    @Max(value = 3, message = "priority deve sentre 1-3, sendo 1 a mais alta")
    @NotNull(message = "a prioridade precisa ser definida")
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

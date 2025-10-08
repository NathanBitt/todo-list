package com.nb.dev.todo_list.dtos;

public class TodoDTO {

    private String task;
    private Integer priority;
    private Boolean isReleased;

    public TodoDTO(){}

    public TodoDTO(String task, Integer priority, Boolean isReleased){
        this.task = task;
        this.priority = priority;
        this.isReleased = isReleased;
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

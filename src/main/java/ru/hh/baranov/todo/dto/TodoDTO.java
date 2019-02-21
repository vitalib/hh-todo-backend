package ru.hh.baranov.todo.dto;

public class TodoDTO {

    private String title;
    private String id;
    private Boolean completed;

    public TodoDTO(String title) {

    }

    public TodoDTO(String title, String id, Boolean completed) {
        this.title = title;
        this.id = id;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

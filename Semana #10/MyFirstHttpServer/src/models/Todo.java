package models;

import java.util.UUID;

public class Todo {
    private UUID id;
    private String title;
    private boolean completed;

    public Todo(String id, String title, boolean completed) {
        this.id = id.isEmpty() ? UUID.randomUUID() : UUID.fromString(id);
        this.title = title;
        this.completed = completed;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
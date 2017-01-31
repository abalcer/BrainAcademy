package com.brainacademy.jdbc;

import java.sql.Date;

public class Task {
    private long id;
    private long categoryId;
    private Date dueDate;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
}

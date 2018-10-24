package com.nassra.aleen.aleentaskmngr2018.data;

import java.util.Date;

public class MyTask {
    private String key;
    private String title;
    private String tesk;
    private int nexessary;
    private int importent;
    private Date creatDate;
    private Date dueDate;

    public MyTask() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTesk() {
        return tesk;
    }

    public void setTesk(String tesk) {
        this.tesk = tesk;
    }

    public int getNexessary() {
        return nexessary;
    }

    public void setNexessary(int nexessary) {
        this.nexessary = nexessary;
    }

    public int getImportent() {
        return importent;
    }

    public void setImportent(int importent) {
        this.importent = importent;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

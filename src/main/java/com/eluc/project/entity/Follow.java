package com.eluc.project.entity;

public class Follow {
    private int id;
    private int uid;
    private int tid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", uid=" + uid +
                ", tid=" + tid +
                '}';
    }
}

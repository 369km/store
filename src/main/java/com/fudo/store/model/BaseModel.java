package com.fudo.store.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "create_time", updatable = false)
    protected LocalDateTime createTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", updatable = false)
    protected User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

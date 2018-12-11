package com.project.iotsite.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String info;
    private Long status;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany(mappedBy = "devices")
    private Set<User> users;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    public Device() {
    }

    public Device(String name, String info, Long status, Type type) {
        this.name = name;
        this.info = info;
        this.status = status;
        this.type = type;
    }

    public Device(String name, String info, Long status, Type type, Set<User> users, Room room) {
        this.name = name;
        this.info = info;
        this.status = status;
        this.type = type;
        this.users = users;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

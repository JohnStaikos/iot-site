package com.project.iotsite.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Device> devices;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
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

    public void addDevice(Device device) {
        if (devices == null) {
            this.devices = new ArrayList<>();
        }
        this.devices.add(device);
    }
}

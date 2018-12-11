package com.project.iotsite.service;

import com.project.iotsite.entity.Room;

import java.util.List;

public interface RoomService {

    Room findById(long id);

    List<Room> findByname(String name);

    List<Room> findAll();

    Room save(Room d);

    void delete(Long id);

    void delete(Room p);
}



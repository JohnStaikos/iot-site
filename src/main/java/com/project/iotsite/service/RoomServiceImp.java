package com.project.iotsite.service;

import com.project.iotsite.entity.Room;
import com.project.iotsite.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRep;

    @Override
    public Room findById(long id) {
        return roomRep.findById(id);
    }

    @Override
    public List<Room> findByname(String name) {
        return roomRep.findByname(name);
    }

    @Override
    public List<Room> findAll() {
        return roomRep.findAll();
    }

    @Override
    public Room save(Room d) {
        return roomRep.save(d);
    }

    @Override
    public void delete(Long id) {
        roomRep.deleteById(id);
    }

    @Override
    public void delete(Room d) {
        roomRep.delete(d);
    }

}

package com.project.iotsite.controller;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.Room;
import com.project.iotsite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public Collection<Room> getAllRooms() {

        return roomService.findAll();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoom(@PathVariable long id) {
        return roomService.findById(id);
    }


}
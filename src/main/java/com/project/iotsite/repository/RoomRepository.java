package com.project.iotsite.repository;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findById(long id);

    List<Room> findAll();

    List<Room> findByname(String name);


}


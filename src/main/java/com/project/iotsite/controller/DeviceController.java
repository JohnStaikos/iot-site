package com.project.iotsite.controller;

import com.project.iotsite.entity.Device;
import com.project.iotsite.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class DeviceController  {

    @Autowired
    private DeviceService deviceService;


    @GetMapping("/devices")
    public Collection<Device> getAllDevices() {
        return  deviceService.findAll();
    }

    @GetMapping("/devices/{id}")
    public Device getDevice(@PathVariable  long id) {
        return deviceService.findById(id);
    }

    @PutMapping("/devices/{id}")
    public ResponseEntity<Device> updateDevice(@RequestBody Device device) {
        Device updated = deviceService.save(device);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @DeleteMapping("/devices/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable long id) {
        deviceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/devices")
    public ResponseEntity<Void> addDevice(@RequestBody Device device) {

      Device saved = deviceService.save(device);

      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
      return ResponseEntity.created(uri).build();

    }

    @GetMapping("/rooms/{id}/devices")
    public  Collection<Device>  getByRoomId(@PathVariable long id) {
        return deviceService.findAllByRoomId(id);
    }


    @PutMapping("/devices/{id}/open")
    public Device OpenDevice(@PathVariable long id  ){
       return  deviceService.openDevice(id);
    }

    @PutMapping("/devices/{id}/close")
    public Device CloseDevice(@PathVariable long id  ){
        return deviceService.closeDevice(id);
    }

    @PutMapping("/rooms/{id}/open")
    public List<Device> openAllDevicesOfRoom(@PathVariable long id)
    {
        return (List<Device>) deviceService.changeRoomDevices(id,(long) 0,(long) 1);
    }

    @PutMapping("/rooms/{id}/close")
    public List<Device> closeAllDevicesOfRoom(@PathVariable long id)
    {
        return deviceService.changeRoomDevices(id,(long)1,(long)0);
    }
}
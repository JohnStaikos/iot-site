package com.project.iotsite.controller;

import com.project.iotsite.entity.Device;
import com.project.iotsite.repository.DeviceRepository;
import com.project.iotsite.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

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
    public ResponseEntity<Device> updateDevice(@PathVariable long id, @RequestBody Device device) {
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





}
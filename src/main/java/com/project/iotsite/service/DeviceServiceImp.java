package com.project.iotsite.service;

        import com.project.iotsite.entity.Device;
import com.project.iotsite.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findByname(String name) {
        return deviceRepository.findByname(name);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device save(Device d) {
        return deviceRepository.save(d);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void delete(Device d) {
        deviceRepository.delete(d);
    }

    @Override
    public Device findById(long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public List<Device> findAllByRoomId(long id) { return deviceRepository.findAllByRoomId(id); }

    @Override
    public Device closeDevice(long id) {
        Device d = deviceRepository.findById(id);
        d.setStatus((long) 0);
        deviceRepository.save(d);
        return d;
        }

    @Override
    public List<Device> changeRoomDevices(long room_id, String oldstatus, String newStatus) {
        return null;
    }


    //        probably doesn't work
    @Override
    public List<Device> changeRoomDevices(long room_id, Long oldStatus, Long newStatus) {
        List<Device> deviceList = deviceRepository.findAllByRoomIdAndStatus(room_id,oldStatus);

        for (int i=0; i< deviceList.toArray().length; i++){
            deviceList.get(i).setStatus(newStatus);
            deviceRepository.saveAll(deviceList);
        }
        return deviceRepository.findAllByRoomId(room_id);
    }

    @Override
    public Device openDevice(long id ) {
        Device d = deviceRepository.findById(id);
        d.setStatus((long) 1);
        deviceRepository.save(d);
        return d;
    }
}
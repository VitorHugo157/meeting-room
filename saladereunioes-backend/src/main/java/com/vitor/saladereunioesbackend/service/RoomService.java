package com.vitor.saladereunioesbackend.service;

import com.vitor.saladereunioesbackend.exception.ResourceNotFoundException;
import com.vitor.saladereunioesbackend.model.Room;
import com.vitor.saladereunioesbackend.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> listAll() {
        return roomRepository.findAll();
    }

    public Room findById(Long id) throws ResourceNotFoundException {
        return verifyIfExists(id);
    }

    public Room updateById(Long id, Room room) throws ResourceNotFoundException {
        Room roomToUpdate = verifyIfExists(id);
        roomToUpdate.setName(room.getName());
        roomToUpdate.setDate(room.getDate());
        roomToUpdate.setStartHour(room.getStartHour());
        roomToUpdate.setEndHour(room.getEndHour());
        return roomRepository.save(roomToUpdate);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        verifyIfExists(id);
        roomRepository.deleteById(id);
    }

    private Room verifyIfExists(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for id:: " + id));
    }
}

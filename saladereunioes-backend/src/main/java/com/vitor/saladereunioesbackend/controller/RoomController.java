package com.vitor.saladereunioesbackend.controller;

import com.vitor.saladereunioesbackend.exception.ResourceNotFoundException;
import com.vitor.saladereunioesbackend.model.Room;
import com.vitor.saladereunioesbackend.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody @Valid Room room) {
        return roomService.createRoom(room);
    }

    @GetMapping
    public List<Room> listAll() {
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable Long id) throws ResourceNotFoundException {
        return roomService.findById(id);
    }

    @PutMapping("/{id}")
    public Room updateById(@PathVariable Long id, @RequestBody @Valid Room room) throws ResourceNotFoundException {
        return roomService.updateById(id, room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        roomService.delete(id);
    }

}

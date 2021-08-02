package com.vitor.saladereunioesbackend.repository;

import com.vitor.saladereunioesbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}

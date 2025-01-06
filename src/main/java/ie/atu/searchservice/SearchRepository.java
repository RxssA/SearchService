package ie.atu.searchservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r.name FROM Room r WHERE r.dateAvailable = :date AND r.isBooked = false")
    List<String> findAvailableRoomsByDate(String date);
}
package ie.atu.searchservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends MongoRepository<Room, String> {

    List<Room> findByDateAvailableAndIsBooked(String dateAvailable, boolean isBooked);
}
package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<String> findAvailableRooms(String date) {
        List<String> availableRooms = searchRepository.findAvailableRoomsByDate(date);


        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms on this date.");
        } else {
            for (String room : availableRooms) {

                if (isRoomBooked(room)) {
                    System.out.println("Room " + room + " is not available on this date.");
                }
            }
        }

        return availableRooms;
    }


    private boolean isRoomBooked(String room) {
        // Replace this logic with actual logic to determine if the room is booked
        return room.contains("booked");
    }
}

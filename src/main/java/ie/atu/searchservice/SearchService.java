package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<String> findAvailableRooms(String date) {
        return searchRepository.findAvailableRoomsByDate(date);
    }
}
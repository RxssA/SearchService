package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {


    @Autowired
    private SearchRepository searchRepository;

    public List<String> findAvailableRooms(String date) {

        return searchRepository.findByDateAvailableAndIsBooked(date, false)
                .stream()
                .map(Room::getName)
                .collect(Collectors.toList());
    }
}
package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<SearchDetails> performSearch(String query) {
        return searchRepository.findByNameContainingIgnoreCase(query);
    }
}

package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // Endpoint to perform a search based on criteria
    @PostMapping
    public ResponseEntity<?> performSearch(@RequestBody SearchDetails searchDetails) {
        try {
            List<String> results = searchService.search(searchDetails);
            searchDetails.setResults(results);
            searchDetails.setTimestamp(String.valueOf(System.currentTimeMillis())); // Add a timestamp for the search
            return new ResponseEntity<>(searchDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error performing search", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve search details by ID
    @GetMapping("/{searchId}")
    public ResponseEntity<?> getSearchDetails(@PathVariable String searchId) {
        Optional<SearchDetails> searchDetails = searchService.getSearchDetails(searchId);
        if (searchDetails.isPresent()) {
            return new ResponseEntity<>(searchDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Search details not found", HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to retrieve all searches
    @GetMapping
    public ResponseEntity<?> getAllSearches() {
        try {
            List<SearchDetails> allSearches = searchService.getAllSearches();
            return new ResponseEntity<>(allSearches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving searches", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    private SearchDetailsRepository searchDetailsRepository;

    @Autowired
    public SearchServiceImpl(SearchDetailsRepository searchDetailsRepository) {
        this.searchDetailsRepository = searchDetailsRepository;
    }

    @Override
    public List<String> search(SearchDetails searchDetails) {

        List<String> results = new ArrayList<>();

        if ("username".equalsIgnoreCase(searchDetails.getSearchCriteria())) {
            results.add("Result 1 for username: " + searchDetails.getSearchValue());
            results.add("Result 2 for username: " + searchDetails.getSearchValue());
        } else if ("email".equalsIgnoreCase(searchDetails.getSearchCriteria())) {
            results.add("Result 1 for email: " + searchDetails.getSearchValue());
        } else {
            results.add("No results found for the given criteria.");
        }

        // Save the search details in the database
        searchDetails.setResults(results);
        searchDetailsRepository.save(searchDetails);

        return results;
    }

    @Override
    public Optional<SearchDetails> getSearchDetails(String searchId) {
        // Fetch search details by ID
        return searchDetailsRepository.findById(searchId);
    }

    @Override
    public List<SearchDetails> getAllSearches() {
        // Fetch all search records
        return searchDetailsRepository.findAll();
    }
}

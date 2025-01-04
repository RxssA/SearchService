package ie.atu.searchservice;

import java.util.List;
import java.util.Optional;

public interface SearchService {
    List<String> search(SearchDetails searchDetails);
    Optional<SearchDetails> getSearchDetails(String searchId);
    List<SearchDetails> getAllSearches();
}

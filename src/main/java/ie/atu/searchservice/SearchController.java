package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public List<SearchDetails> search(@RequestParam String query) {
        return searchService.performSearch(query);
    }

    @GetMapping("/search/{id}")
    public SearchDetails getById(@PathVariable Long id) {
        return searchService.getById(id);
    }
}


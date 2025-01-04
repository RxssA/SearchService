package ie.atu.searchservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchDetailsRepository extends MongoRepository<SearchDetails, String> {
}

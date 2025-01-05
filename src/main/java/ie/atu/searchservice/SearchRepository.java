package ie.atu.searchservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<SearchDetails, Long> {
    List<SearchDetails> findByNameContainingIgnoreCase(String query);
}

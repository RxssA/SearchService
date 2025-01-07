package ie.atu.searchservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class SearchControllerTest {

    @Mock
    private SearchService searchService;

    @InjectMocks
    private SearchController searchController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    public void testSearchRooms() {
        String date = "2025-01-01";
        List<String> mockRooms = Arrays.asList("Room101", "Room202");

        // Mock service behavior
        when(searchService.findAvailableRooms(date)).thenReturn(mockRooms);

        // Call the controller method
        List<String> response = searchController.searchRooms(date);

        // Verify results
        assertEquals(mockRooms, response);
        verify(searchService, times(1)).findAvailableRooms(date);
    }
}

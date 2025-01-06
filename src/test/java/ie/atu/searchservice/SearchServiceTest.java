package ie.atu.searchservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class SearchServiceTest {

    @Mock
    private SearchRepository searchRepository;

    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    public void testFindAvailableRooms() {
        String date = "2025-01-01";
        List<String> mockRooms = Arrays.asList("Room101", "Room202");

        // Mock repository behavior
        when(searchRepository.findAvailableRoomsByDate(date)).thenReturn(mockRooms);

        // Call the service method
        List<String> result = searchService.findAvailableRooms(date);

        // Verify results
        assertEquals(mockRooms, result);
        verify(searchRepository, times(1)).findAvailableRoomsByDate(date);
    }
}

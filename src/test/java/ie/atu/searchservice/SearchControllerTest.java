package ie.atu.searchservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
class SearchControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SearchService searchService;

    @InjectMocks
    private SearchController searchController;

    @Test
    void testSearchRooms() throws Exception {
        // Setting up MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();

        // Mocking service behavior
        when(searchService.findAvailableRooms("2025-01-06"))
                .thenReturn(Arrays.asList("Room A", "Room B"));

        // Testing the endpoint
        mockMvc.perform(get("/search")
                        .param("date", "2025-01-06")
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Room A\", \"Room B\"]"));
    }
}

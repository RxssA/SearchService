package ie.atu.searchservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    @Test
    void testSearchRooms() throws Exception {
        // Mocking service behavior
        when(searchService.findAvailableRooms("2025-01-02"))
                .thenReturn(Arrays.asList("Room A", "Room B"));

        // Verify the mock returns the correct value (debugging)
        System.out.println("Mocked rooms: " + searchService.findAvailableRooms("2025-01-02"));

        // Testing the endpoint
        mockMvc.perform(get("/search")
                        .param("date", "2025-01-06")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()) // Prints the request and response for debugging
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Room A\", \"Room B\"]"));
    }
}

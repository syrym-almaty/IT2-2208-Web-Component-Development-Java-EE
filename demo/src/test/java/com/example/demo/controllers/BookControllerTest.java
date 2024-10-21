@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBook() throws Exception {
        String bookJson = "{\"title\": \"Effective Java\", \"author\": \"Joshua Bloch\", \"isbn\": \"9780134685991\", \"available\": true}";

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testSearchBooks_byKeyword_shouldReturnMatchingBooks() throws Exception {
        mockMvc.perform(get("/api/books/search")
                        .param("keyword", "Clean"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].title").value("Clean Code"))
                .andExpect(jsonPath("$.[0].author").value("Robert C. Martin"));
    }

    @Test
    public void testSearchBooksByTitle() throws Exception {
        mockMvc.perform(get("/api/books/search?keyword=Effective"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Effective Java"));
    }

    @Test
    public void testSearchBooksByAuthor() throws Exception {
        mockMvc.perform(get("/api/books/search?keyword=Joshua"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("Joshua Bloch"));
    }

    @Test
    public void testSearchBooks_withEmptyKeyword_shouldReturnEmptyList() throws Exception {
        mockMvc.perform(get("/api/books/search")
                        .param("keyword", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    public void testDeleteNonExistentBook_shouldReturnNotFound() throws Exception {
        UUID nonExistentId = UUID.randomUUID();

        mockMvc.perform(delete("/api/books/{id}", nonExistentId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Book not found with id " + nonExistentId));
    }

    @Test
    public void testDeleteBook_referencedInAnotherEntity_shouldReturnConflict() throws Exception {
        UUID bookId = UUID.randomUUID();

        mockMvc.perform(delete("/api/books/{id}", bookId))
                .andExpect(status().isConflict())
                .andExpect(content().string("Book cannot be deleted as it is referenced by another entity"));
    }
}
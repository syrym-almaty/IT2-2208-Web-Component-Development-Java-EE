@RestController
@RequestMapping("/api/students")
@PreAuthorize("hasRole('STUDENT')")
@Tag(name = "Student Controller", description = "CRUD operations for Students")
public class StudentController {


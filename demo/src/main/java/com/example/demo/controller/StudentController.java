@RestController
@RequestMapping("/api/students")
@PreAuthorize("hasRole('STUDENT')")
@Tag(name = "Student Controller", description = "CRUD operations for Students")
public class StudentController {

    @Operation(summary = "Update Student", description = "Update an existing student's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public Student updateStudent(
            @Parameter(description = "UUID of the student to update", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Updated student object", required = true)
            @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
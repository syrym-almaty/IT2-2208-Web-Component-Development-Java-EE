private String name;
private String email;

@ManyToMany
@JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
)
private Set<Course> courses = new HashSet<>();

// GPA field
private Double gpa;

// Constructors
public Student() {}
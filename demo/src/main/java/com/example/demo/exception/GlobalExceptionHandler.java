}

// You can add more exception handlers here
@ExceptionHandler(BusinessException.class)
public ResponseEntity<String> handleBusinessException(BusinessException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
}

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleNotFoundException(ResourceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
// Inner class for error response
public static class ErrorResponse {
    private int status;
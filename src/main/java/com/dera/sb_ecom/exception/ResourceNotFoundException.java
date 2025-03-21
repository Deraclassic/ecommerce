package com.dera.sb_ecom.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String field;
    private Long fieldId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String field) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.field = field;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}

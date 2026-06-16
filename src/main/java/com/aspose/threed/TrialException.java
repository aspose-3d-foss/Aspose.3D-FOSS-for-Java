package com.aspose.threed;

/**
 * Trial exception for evaluation mode.
 */
public class TrialException extends RuntimeException {
    /**
     * Initializes a new instance of the TrialException class.
     */
    public TrialException() {
        super();
    }

    /**
     * Initializes a new instance of the TrialException class.
     * @param message The error message.
     */
    public TrialException(String message) {
        super(message);
    }

    /**
     * Initializes a new instance of the TrialException class.
     * @param message The error message.
     * @param cause The inner exception.
     */
    public TrialException(String message, Throwable cause) {
        super(message, cause);
    }
}

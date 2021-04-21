package application.history.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResponse {
    private final String status;
    private final String message;
    private final String errorMessage;
    private final String errorCode;

    public ApiResponse(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

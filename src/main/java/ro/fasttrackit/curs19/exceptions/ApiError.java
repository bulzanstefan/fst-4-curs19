package ro.fasttrackit.curs19.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ApiError {
    private final int code;
    private final String message;

    public ApiError(@JsonProperty("code") int code,
                    @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return code == apiError.code &&
                Objects.equals(message, apiError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

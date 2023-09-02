package ru.smbr.hackathon.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode
public class DeleteResponse {

    private final String message = "Entity deleted successfully";

    @JsonProperty("status")
    private final HttpStatus status = HttpStatus.OK;
}

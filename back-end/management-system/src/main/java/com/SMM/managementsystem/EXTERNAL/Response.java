package com.SMM.managementsystem.EXTERNAL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Class handles state status' of the application which holds responses targeted to for the front-end.
 */

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime localDateTime;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String response;
    protected String developerMessage;
    protected Map<?,?> data;
}

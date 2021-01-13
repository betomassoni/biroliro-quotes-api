package br.com.robertomassoni.biroliroQuotes.dto.response;

import java.util.Date;

public class ResponseError {

    private Date timestamp;
    private String message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public ResponseError setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ResponseError setDetails(String details) {
        this.details = details;
        return this;
    }        
}

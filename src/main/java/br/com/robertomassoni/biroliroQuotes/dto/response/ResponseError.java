package br.com.robertomassoni.biroliroQuotes.dto.response;

import java.util.Date;

public class ResponseError {

    private Date timestamp;
    private String message;

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
}

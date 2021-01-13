package br.com.robertomassoni.biroliroQuotes.dto.response;

import br.com.robertomassoni.biroliroQuotes.enumerator.StatusType;
import br.com.robertomassoni.biroliroQuotes.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
    
    private StatusType status;
    private T content;
    private Object errors;
    private Object pageable;
    
    public StatusType getStatus() {
        return status;
    }
    
    public void setStatus(StatusType status) {
        this.status = status;
    }
  
    public T getContent() {
        return content;
    }
        
    public Response<T> setContent(T content) {
        this.content = content;
        return this;
    }

    public Object getErrors() {
        return errors;
    }

    public Response<T> setErrors(Object errors) {
        this.errors = errors;
        return this;
    }

    public Object getPageable() {
        return pageable;
    }

    public Response<T> setPageable(Object pageable) {
        this.pageable = pageable;
        return this;
    }

    
    public static <T> Response<T> badRequest() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.BAD_REQUEST);
        return response;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.OK);
        return response;
    }

    public static <T> Response<T> unauthorized() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.UNAUTHORIZED);
        return response;
    }

    public static <T> Response<T> validationException() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> Response<T> wrongCredentials() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.WRONG_CREDENTIALS);
        return response;
    }

    public static <T> Response<T> accessDenied() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.ACCESS_DENIED);
        return response;
    }

    public static <T> Response<T> exception() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.EXCEPTION);
        return response;
    }

    public static <T> Response<T> notFound() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.NOT_FOUND);
        return response;
    }

    public static <T> Response<T> duplicateEntity() {
        Response<T> response = new Response<>();
        response.setStatus(StatusType.DUPLICATE_ENTITY);
        return response;
    }

    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        ResponseError error = new ResponseError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(DateUtil.today());
        setErrors(error);
    }
    
    
}

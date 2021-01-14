package br.com.robertomassoni.biroliroQuotes.enumerator;

public enum ExceptionType {

    ENTITY_NOT_FOUND("not.found"),
    DUPLICATE_ENTITY("duplicate"),
    ENTITY_EXCEPTION("exception"),
    ENTITY_INVALID_CODE("invalid.code"),
    ENTITY_IS_EMPTY("is.empty");

    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
 


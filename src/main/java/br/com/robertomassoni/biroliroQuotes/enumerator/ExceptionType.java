package br.com.robertomassoni.biroliroQuotes.enumerator;

public enum ExceptionType {

    ENTITY_NOT_FOUND("not found"),
    DUPLICATE_ENTITY("duplicate"),
    ENTITY_EXCEPTION("exception"),
    INVALID_CREDENTIALS("invalid credentials");

    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
 
package br.com.robertomassoni.biroliroQuotes.enumerator;


public enum EntityType {
    TAGS("Tags"),
    QUOTES("Quotes");
    
    String value;

    EntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

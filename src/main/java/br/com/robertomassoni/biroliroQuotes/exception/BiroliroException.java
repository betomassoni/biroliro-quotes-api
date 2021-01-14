package br.com.robertomassoni.biroliroQuotes.exception;

import br.com.robertomassoni.biroliroQuotes.config.PropertiesConfig;
import br.com.robertomassoni.biroliroQuotes.enumerator.EntityType;
import br.com.robertomassoni.biroliroQuotes.enumerator.ExceptionType;
import java.text.MessageFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BiroliroException {

    private static PropertiesConfig propertiesConfig;

    @Autowired
    public BiroliroException(PropertiesConfig propertiesConfig) {
        BiroliroException.propertiesConfig = propertiesConfig;
    }
    
    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType) 
                || ExceptionType.ENTITY_IS_EMPTY.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.ENTITY_EXCEPTION.equals(exceptionType) 
                || ExceptionType.ENTITY_INVALID_CODE.equals(exceptionType)) {
            return new EntityException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    private static String format(String messageTemplate, String... args) {
        Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(messageTemplate));
        if (templateContent.isPresent()) {
            return MessageFormat.format(templateContent.get(), (Object[]) args);
        }
        return String.format(messageTemplate, (Object[]) args);
    }

    public static class EntityNotFoundException extends RuntimeException {

        public EntityNotFoundException(String message) {
            super(message);
        }

        public EntityNotFoundException() {
            super();
        }
    }

    public static class EntityException extends RuntimeException {

        public EntityException(String message) {
            super(message);
        }

        public EntityException() {
            super();
        }
    }

}

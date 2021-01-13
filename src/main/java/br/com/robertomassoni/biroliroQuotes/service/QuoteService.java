package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuoteService {
    Page<QuoteDto> getQuotes(Pageable pageable);
    QuoteDto addQuote(QuoteDto quoteDto);
    QuoteDto getQuote(Integer id);
    QuoteDto getRandomQuote();
}

package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.QuoteMapper;
import br.com.robertomassoni.biroliroQuotes.dto.mapper.TagMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import br.com.robertomassoni.biroliroQuotes.enumerator.EntityType;
import br.com.robertomassoni.biroliroQuotes.enumerator.ExceptionType;
import br.com.robertomassoni.biroliroQuotes.exception.BiroliroQuotesException;
import br.com.robertomassoni.biroliroQuotes.model.Quote;
import br.com.robertomassoni.biroliroQuotes.repository.QuoteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private TagService tagService;

    @Override
    public Page<QuoteDto> getQuotes(Pageable pageable) {
        Page<Quote> pageQuotes = quoteRepository.findAll(pageable);
        if (!pageQuotes.isEmpty()) {
            List<QuoteDto> quotesDtoList = QuoteMapper.toQuoteDto(pageQuotes.getContent());
            return QuoteMapper.toPageQuoteDto(quotesDtoList, pageable, pageQuotes);
        }
        throw BiroliroQuotesException.throwException(EntityType.QUOTES, ExceptionType.ENTITY_NOT_FOUND, null);
    }

    @Override
    public QuoteDto addQuote(QuoteDto quoteDto) {
        if (quoteDto != null) {

            // Adiciona a tag se não existir
            List<TagDto> tagDtoList = new ArrayList();
            if (quoteDto.getTagList() != null) {
                for (String tag : quoteDto.getTagList()) {
                    tagDtoList.add(tagService.addIfNotExist(tag));
                }
            }

            Quote quote = new Quote();
            quote.setValue(quoteDto.getValue());
            quote.setUrl(quoteDto.getUrl());
            quote.setCreatedAt(quoteDto.getCreatedAt());
            quote.setUpdatedAt(quoteDto.getUpdatedAt());
            quote.setTagList(TagMapper.fromDtoToModel(tagDtoList));

            quote = quoteRepository.save(quote);
            
            return QuoteMapper.toQuoteDto(quote);
        }
        throw BiroliroQuotesException.throwException(EntityType.QUOTES, ExceptionType.ENTITY_NOT_FOUND, null);
    }

}

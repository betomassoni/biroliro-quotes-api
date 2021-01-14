package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.QuoteMapper;
import br.com.robertomassoni.biroliroQuotes.dto.mapper.TagMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import static br.com.robertomassoni.biroliroQuotes.enumerator.EntityType.*;
import static br.com.robertomassoni.biroliroQuotes.enumerator.ExceptionType.*;
import br.com.robertomassoni.biroliroQuotes.exception.BiroliroException;
import br.com.robertomassoni.biroliroQuotes.model.Quote;
import br.com.robertomassoni.biroliroQuotes.repository.QuoteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        try {
            Page<Quote> pageQuotes = quoteRepository.findAll(pageable);
            if (pageQuotes.isEmpty()) {
                throw new BiroliroException.EntityNotFoundException();
            }
            List<QuoteDto> quotesDtoList = QuoteMapper.toQuoteDto(pageQuotes.getContent());
            return QuoteMapper.toPageQuoteDto(quotesDtoList, pageable, pageQuotes);
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_NOT_FOUND);
        } catch (Exception ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_EXCEPTION);
        }
    }

    @Override
    public QuoteDto addQuote(QuoteDto quoteDto) {

        try {
            if (quoteDto != null) {
                throw new BiroliroException.EntityNotFoundException();
            }

            // Adiciona a tag se não existir
            List<TagDto> tagDtoList = new ArrayList();
            if (quoteDto.getTags() != null) {
                for (String tag : quoteDto.getTags()) {
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
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_IS_EMPTY);
        } catch (Exception ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_EXCEPTION);
        }
    }

    @Override
    public QuoteDto getQuote(String id) {
        try {
            Optional<Quote> quote = quoteRepository.findById(Integer.parseInt(id));
            if (quote.isPresent() == false) {
                throw new BiroliroException.EntityNotFoundException(id);
            }
            return QuoteMapper.toQuoteDto(quote.get());
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_NOT_FOUND, id);
        } catch (NumberFormatException ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_INVALID_CODE, id);
        } catch (Exception ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_EXCEPTION);
        }
    }

    @Override
    public QuoteDto getRandomQuote() {
        try {
            Optional<Quote> quote = quoteRepository.getRandom();
            if (quote.isPresent() == false) {
                throw new BiroliroException.EntityNotFoundException();
            }
            return QuoteMapper.toQuoteDto(quote.get());
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_NOT_FOUND);
        } catch (Exception ex) {
            throw BiroliroException.throwException(QUOTE, ENTITY_EXCEPTION);
        }
    }

}

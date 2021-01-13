package br.com.robertomassoni.biroliroQuotes.dto.mapper;

import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import br.com.robertomassoni.biroliroQuotes.model.Quote;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class QuoteMapper {

    public static QuoteDto toQuoteDto(Quote quote) {
        QuoteDto quoteDto = null;
        if (quote != null) {
            quoteDto = new QuoteDto();
            quoteDto.setValue(quote.getValue());
            quoteDto.setUrl(quote.getUrl());
            quoteDto.setCreatedAt(quote.getCreatedAt());
            quoteDto.setUpdatedAt(quote.getUpdatedAt());
            quoteDto.setTagList(TagMapper.toTagString(quote.getTagList()));
        }
        return quoteDto;
    }

    public static List<QuoteDto> toQuoteDto(List<Quote> quotesList) {
        ArrayList<QuoteDto> quoteDtoList = new ArrayList();

        quotesList.stream().forEach((quotes) -> {
            quoteDtoList.add(toQuoteDto(quotes));
        });

        return quoteDtoList;
    }

    public static Page<QuoteDto> toPageQuoteDto(List<QuoteDto> quoteDtoList, Pageable pageable, Page<Quote> pageQuote) {
        return new PageImpl<>(quoteDtoList, pageable, pageQuote.getTotalElements());
    }

}

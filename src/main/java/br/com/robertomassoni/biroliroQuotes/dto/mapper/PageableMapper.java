package br.com.robertomassoni.biroliroQuotes.dto.mapper;

import br.com.robertomassoni.biroliroQuotes.dto.util.PageableDto;
import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import org.springframework.data.domain.Page;


public class PageableMapper {
    public static PageableDto toPageableDto(Page<QuoteDto> pageQuotesDto) {
        PageableDto pageableDto = new PageableDto();
        if (pageQuotesDto != null) {
            pageableDto.setSize(pageQuotesDto.getSize());
            pageableDto.setTotalElements(pageQuotesDto.getTotalElements());
            pageableDto.setTotalPages(pageQuotesDto.getTotalPages());
            pageableDto.setNumber(pageQuotesDto.getNumber());            
        }
        return pageableDto;
    }
}

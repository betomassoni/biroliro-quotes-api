package br.com.robertomassoni.biroliroQuotes.controller;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.PageableMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import br.com.robertomassoni.biroliroQuotes.dto.response.Response;
import br.com.robertomassoni.biroliroQuotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuoteController {
    
    @Autowired
    private QuoteService quoteService;
    
    @GetMapping("/quote")
    public Response getAllQuotes(Pageable pageable) {
        Page<QuoteDto> pageQuotesDto = quoteService.getQuotes(pageable);                         
        return Response.ok().setContent(pageQuotesDto.getContent()).setPageable(PageableMapper.toPageableDto(pageQuotesDto));        
    }
    
  
}

package br.com.robertomassoni.biroliroQuotes.controller;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.PageableMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.QuoteDto;
import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import br.com.robertomassoni.biroliroQuotes.dto.response.Response;
import br.com.robertomassoni.biroliroQuotes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TagController {
    
    @Autowired
    private TagService tagService;
    
    @GetMapping("/tag")
    public Response getAllTags(Pageable pageable) {
        Page<TagDto> pageTagsDto = tagService.getTags(pageable);                         
        return Response.ok().setContent(pageTagsDto.getContent()).setPageable(PageableMapper.toPageableDto(pageTagsDto));        
    }
    
    @GetMapping("/tag/{value}")
    public Response getTag(@PathVariable("value") String value) {
        TagDto tagDto = tagService.getTag(value);                         
        return Response.ok().setContent(tagDto);        
    }
    
  
}

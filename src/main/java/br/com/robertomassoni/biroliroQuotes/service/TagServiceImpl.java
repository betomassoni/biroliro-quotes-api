package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.QuoteMapper;
import br.com.robertomassoni.biroliroQuotes.dto.mapper.TagMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import br.com.robertomassoni.biroliroQuotes.enumerator.EntityType;
import br.com.robertomassoni.biroliroQuotes.enumerator.ExceptionType;
import br.com.robertomassoni.biroliroQuotes.exception.BiroliroQuotesException;
import br.com.robertomassoni.biroliroQuotes.model.Quote;
import br.com.robertomassoni.biroliroQuotes.model.Tag;
import br.com.robertomassoni.biroliroQuotes.repository.TagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class TagServiceImpl implements TagService {
    
    @Autowired
    private TagRepository tagRepository;
        
    @Override
    public Page<TagDto> getTags(Pageable pageable) {
        Page<Tag> pageTag = tagRepository.findAll(pageable);  
        if (!pageTag.isEmpty()) {
            List<TagDto> tagDtoList = TagMapper.toTagDto(pageTag.getContent());
            return TagMapper.toPageTagDto(tagDtoList, pageable, pageTag);
        }
        throw BiroliroQuotesException.throwException(EntityType.TAGS, ExceptionType.ENTITY_NOT_FOUND, null);
    }

    @Override
    public TagDto addTag(TagDto tagDto) {
        if (tagDto != null) {
            Tag tag = new Tag();
            tag.setValue(tagDto.getValue());            
            tag = tagRepository.save(tag);
            return TagMapper.toTagDto(tag);
        }
        throw BiroliroQuotesException.throwException(EntityType.QUOTES, ExceptionType.ENTITY_NOT_FOUND, null);                
    }

    @Override
    public TagDto addIfNotExist(String value) {
        Tag tag = null;
        try {
            Optional<Tag> optionalTag = tagRepository.findByValue(value);
            if (optionalTag.isPresent()) {
                tag = optionalTag.get();                
            } else {
                Tag newTag = new Tag();
                newTag.setValue(value);
                tag = tagRepository.saveAndFlush(newTag);
            }
        } catch (Exception e) {
            throw BiroliroQuotesException.throwException(EntityType.TAGS, ExceptionType.ENTITY_EXCEPTION, value);
        }
        return TagMapper.toTagDto(tag);
    }

    @Override
    public TagDto getTag(String value) {
        Optional<Tag> tag = tagRepository.findByValue(value);
        if (tag.isPresent()) {
            return TagMapper.toTagDto(tag.get());
        } else {
            throw BiroliroQuotesException.throwException(EntityType.TAGS, ExceptionType.ENTITY_NOT_FOUND, value);
        }
    }
       

}

package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Page<TagDto> getTags(Pageable pageable);
    TagDto addIfNotExist(String value);
    TagDto addTag(TagDto tagDto);
    TagDto getTag(String value);
}

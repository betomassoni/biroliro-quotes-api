package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Page<TagDto> getTag(Pageable pageable);
    TagDto addIfNotExist(String value);
    TagDto addTag(TagDto tagDto);
    List<TagDto> addTag(List<TagDto> tagDtoList);
}

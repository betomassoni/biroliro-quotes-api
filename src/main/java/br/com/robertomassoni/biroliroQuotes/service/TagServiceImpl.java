package br.com.robertomassoni.biroliroQuotes.service;

import br.com.robertomassoni.biroliroQuotes.dto.mapper.TagMapper;
import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import br.com.robertomassoni.biroliroQuotes.enumerator.EntityType;
import static br.com.robertomassoni.biroliroQuotes.enumerator.ExceptionType.*;
import br.com.robertomassoni.biroliroQuotes.exception.BiroliroException;
import br.com.robertomassoni.biroliroQuotes.model.Tag;
import br.com.robertomassoni.biroliroQuotes.repository.TagRepository;
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
        try {
            Page<Tag> pageTag = tagRepository.findAll(pageable);
            if (pageTag.isEmpty() == true) {
                throw new BiroliroException.EntityNotFoundException();
            }
            List<TagDto> tagDtoList = TagMapper.toTagDto(pageTag.getContent());
            return TagMapper.toPageTagDto(tagDtoList, pageable, pageTag);
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_IS_EMPTY);
        } catch (Exception ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_EXCEPTION);
        }
    }

    @Override
    public TagDto addTag(TagDto tagDto) {
        try {
            if (tagDto == null) {
                throw new BiroliroException.EntityNotFoundException();
            }
            Tag tag = new Tag();
            tag.setValue(tagDto.getValue());
            tag = tagRepository.save(tag);
            return TagMapper.toTagDto(tag);
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_IS_EMPTY);
        } catch (Exception ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_EXCEPTION);
        }
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
            return TagMapper.toTagDto(tag);
        } catch (Exception ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_EXCEPTION);
        }
    }

    @Override
    public TagDto getTag(String value) {
        try {
            Optional<Tag> tag = tagRepository.findByValue(value);
            if (tag.isPresent() == false) {
                throw new BiroliroException.EntityNotFoundException();
            }
            return TagMapper.toTagDto(tag.get());
        } catch (BiroliroException.EntityNotFoundException ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_NOT_FOUND, value);
        } catch (Exception ex) {
            throw BiroliroException.throwException(EntityType.TAG, ENTITY_EXCEPTION);
        }
    }

}

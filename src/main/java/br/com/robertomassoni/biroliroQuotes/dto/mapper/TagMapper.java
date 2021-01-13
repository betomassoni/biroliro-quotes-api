package br.com.robertomassoni.biroliroQuotes.dto.mapper;

import br.com.robertomassoni.biroliroQuotes.dto.model.TagDto;
import br.com.robertomassoni.biroliroQuotes.model.Tag;
import br.com.robertomassoni.biroliroQuotes.model.Tag;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class TagMapper {

    public static String toTagString(Tag tag) {
        String tagString = null;
        if (tag != null) {
            tagString = tag.getValue();
        }
        return tagString;
    }

    public static List<String> toTagString(List<Tag> tagList) {
        List<String> tagStringList = new ArrayList();

        tagList.stream().forEach((tag) -> {
            tagStringList.add(toTagString(tag));
        });

        return tagStringList;
    }
    
    public static TagDto toTagDto(Tag tag) {
        TagDto tagDto = null;
        if (tag != null) {
            tagDto = new TagDto();
            tagDto.setId(tag.getId());
            tagDto.setValue(tag.getValue());
        }
        return tagDto;
    }

    public static List<TagDto> toTagDto(List<Tag> tagList) {
        ArrayList<TagDto> tagDtoList = new ArrayList();

        tagList.stream().forEach((tags) -> {
            tagDtoList.add(toTagDto(tags));
        });

        return tagDtoList;
    }
  
    
    public static Page<TagDto> toPageTagDto(List<TagDto> tagDtoList, Pageable pageable, Page<Tag> pageTag) {
        return new PageImpl<>(tagDtoList, pageable, pageTag.getTotalElements());
    }

    public static List<Tag> fromDtoToModel(List<TagDto> tagDtoList) {
        List<Tag> tagList = new ArrayList();
        tagDtoList.stream().map((tagDto) -> {
            Tag tag = new Tag(); 
            tag.setId(tagDto.getId());
            tag.setValue(tagDto.getValue());
            return tag;
        }).forEach((tag) -> {
            tagList.add(tag);
        });
        return tagList;
    }
}

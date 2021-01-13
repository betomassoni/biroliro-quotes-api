package br.com.robertomassoni.biroliroQuotes.repository;

import br.com.robertomassoni.biroliroQuotes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
        
    public Tag findByValue(String value);
}



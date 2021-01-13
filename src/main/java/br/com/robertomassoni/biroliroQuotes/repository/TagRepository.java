package br.com.robertomassoni.biroliroQuotes.repository;

import br.com.robertomassoni.biroliroQuotes.model.Tag;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
        
    public Optional<Tag> findByValue(String value);
}



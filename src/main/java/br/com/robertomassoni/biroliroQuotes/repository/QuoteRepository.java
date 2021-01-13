package br.com.robertomassoni.biroliroQuotes.repository;

import br.com.robertomassoni.biroliroQuotes.model.Quote;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    
    @Query(nativeQuery=true, value="SELECT * FROM quote ORDER BY RAND() LIMIT 1")
    public Optional<Quote> getRandom();
}



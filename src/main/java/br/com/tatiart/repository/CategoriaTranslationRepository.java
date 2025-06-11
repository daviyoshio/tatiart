package br.com.tatiart.repository;

import br.com.tatiart.model.CategoriaTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaTranslationRepository extends JpaRepository<CategoriaTranslation, Long> {
}
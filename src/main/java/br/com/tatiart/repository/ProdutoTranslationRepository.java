package br.com.tatiart.repository;

import br.com.tatiart.model.ProdutoTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoTranslationRepository extends JpaRepository<ProdutoTranslation, Long> {
}
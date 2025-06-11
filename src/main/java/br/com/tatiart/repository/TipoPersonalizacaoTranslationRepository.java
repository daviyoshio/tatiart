package br.com.tatiart.repository;

import br.com.tatiart.model.TipoPersonalizacaoTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPersonalizacaoTranslationRepository extends JpaRepository<TipoPersonalizacaoTranslation, Long> {
}
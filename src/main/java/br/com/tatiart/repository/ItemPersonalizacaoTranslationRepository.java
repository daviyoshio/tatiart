package br.com.tatiart.repository;

import br.com.tatiart.model.ItemPersonalizacaoTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPersonalizacaoTranslationRepository extends JpaRepository<ItemPersonalizacaoTranslation, Long> {
}
package br.com.tatiart.repository;

import br.com.tatiart.model.ItemPersonalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPersonalizacaoRepository extends JpaRepository<ItemPersonalizacao, Long> {
    // O Spring Data JPA criará os métodos básicos (save, findAll, etc.) automaticamente.
}
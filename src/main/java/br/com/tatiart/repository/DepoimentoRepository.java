// DepoimentoRepository.java
package br.com.tatiart.repository;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.model.Depoimento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    List<Depoimento> findByCategoria(Categoria categoria);
}
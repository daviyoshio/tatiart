package br.com.tatiart.repository;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.model.TipoPersonalizacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



// Lembre-se: esta é uma INTERFACE, não uma classe.
public interface TipoPersonalizacaoRepository extends JpaRepository<TipoPersonalizacao, Long> {

    /**
     * Este é um método "mágico" do Spring Data JPA.
     * Apenas por dar este nome ao método, o Spring entende que você quer buscar
     * no banco de dados todos os 'TipoPersonalizacao' que pertencem a uma 'Categoria' específica.
     * Ele escreve a consulta SQL para você nos bastidores.
     */
    List<TipoPersonalizacao> findByCategoria(Categoria categoria);
}
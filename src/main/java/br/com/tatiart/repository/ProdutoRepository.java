package br.com.tatiart.repository;

import br.com.tatiart.model.Categoria;
import br.com.tatiart.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



// Este repositório gerencia a entidade 'Produto', cujo ID é do tipo 'Long'.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Da mesma forma, o Spring entende que este método deve buscar
    // uma LISTA de Produtos que pertencem a uma determinada 'Categoria'.
    List<Produto> findByCategoria(Categoria categoria);
}
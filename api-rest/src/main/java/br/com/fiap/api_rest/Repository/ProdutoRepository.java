package br.com.fiap.api_rest.Repository;


import br.com.fiap.api_rest.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}

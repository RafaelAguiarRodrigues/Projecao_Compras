package br.com.projecao.repository;

import br.com.projecao.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compra, Long> {
}

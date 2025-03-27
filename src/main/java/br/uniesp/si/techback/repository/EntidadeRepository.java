package br.uniesp.si.techback.repository;

import br.uniesp.si.techback.model.EntidadeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeRepository extends JpaRepository<EntidadeBase, Integer> {
}

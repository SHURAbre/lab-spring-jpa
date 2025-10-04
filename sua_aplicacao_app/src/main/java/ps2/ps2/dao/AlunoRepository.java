package ps2.ps2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.ps2.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
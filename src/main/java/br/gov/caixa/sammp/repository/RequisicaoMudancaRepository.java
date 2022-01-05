package br.gov.caixa.sammp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.caixa.sammp.entity.RequisicaoMudanca;

public interface RequisicaoMudancaRepository extends CrudRepository<RequisicaoMudanca, Double>{

	@Query("select rm from RequisicaoMudanca rm where "
			+ "(rm.dataEntrega between :dataInicio and :dataFim) or "
			+ "(rm.dataCrq between :dataInicio and :dataFim) or "
			+ "(rm.dataPrevista between :dataInicio and :dataFim) or "
			+ "(rm.dataImplantacao between :dataInicio and :dataFim)")
	public List<RequisicaoMudanca> findByDataInicioAndDataFim(LocalDate dataInicio, LocalDate dataFim);
}

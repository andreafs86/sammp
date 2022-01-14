package br.gov.caixa.sammp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.gov.caixa.sammp.dto.RequisicaoMudancaDTO;

@Entity
public class RequisicaoMudanca {

	@Id
	private Double numeroRtc;
	private String siglaSistema;
	private String resumo;
	private LocalDate dataEntrega;
	private LocalDate dataCrq;
	private LocalDate dataPrevista;
	private LocalDate dataImplantacao;
	@Column(length = 1000)
	private String detalhe;

	public Double getNumeroRtc() {
		return numeroRtc;
	}

	public void setNumeroRtc(Double numeroRtc) {
		this.numeroRtc = numeroRtc;
	}

	public String getSiglaSistema() {
		return siglaSistema;
	}

	public void setSiglaSistema(String siglaSistema) {
		this.siglaSistema = siglaSistema;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataCrq() {
		return dataCrq;
	}

	public void setDataCrq(LocalDate dataCrq) {
		this.dataCrq = dataCrq;
	}

	public LocalDate getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public LocalDate getDataImplantacao() {
		return dataImplantacao;
	}

	public void setDataImplantacao(LocalDate dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public RequisicaoMudancaDTO getDto() {
		RequisicaoMudancaDTO rm = new RequisicaoMudancaDTO();
		rm.setNumeroRtc(numeroRtc);
		rm.setSiglaSistema(siglaSistema);
		rm.setResumo(resumo);
		rm.setDataEntrega(dataEntrega);
		rm.setDataCrq(dataCrq);
		rm.setDataPrevista(dataPrevista);
		rm.setDataImplantacao(dataImplantacao);
		rm.setDetalhe(detalhe);
		
		return rm;
	}

	public void setDto(RequisicaoMudancaDTO dto) {
		siglaSistema = dto.getSiglaSistema();
		resumo = dto.getResumo();
		dataEntrega = dto.getDataEntrega();
		dataCrq = dto.getDataCrq();
		dataPrevista = dto.getDataPrevista();
		dataImplantacao = dto.getDataImplantacao();
		detalhe = dto.getDetalhe();
	}
}

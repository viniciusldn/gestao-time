package com.trybe.gestaotime.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe Documento.
 */

@Entity
public class Documento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cpf;

  private String numeroCarteiraTrabalho;

  private String numeroCbf;

  @OneToOne(
      mappedBy = "documento",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)

  private Jogador jogador;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroCarteiraTrabalho() {
    return numeroCarteiraTrabalho;
  }

  public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
    this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
  }

  public String getNumeroCbf() {
    return numeroCbf;
  }

  public void setNumeroCbf(String numeroCbf) {
    this.numeroCbf = numeroCbf;
  }

  public Jogador getJogador() {
    return jogador;
  }

  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  }
}

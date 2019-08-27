package Exemplo04.entities;

import java.util.zip.DeflaterOutputStream;

public class Pessoa {

    private int idPessoa;
    private String nome;
    private String email;
    private Double peso;
    private int altura;

    public Pessoa(){

    }

    public Pessoa(String nome, String email, Double peso, int altura) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
        this.altura = altura;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Double getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}

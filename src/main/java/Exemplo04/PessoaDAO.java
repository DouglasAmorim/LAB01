package Exemplo04;

import Exemplo04.entities.Pessoa;
import exemplo02.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    public boolean inserir(Pessoa p){

        String query = "INSERT INTO Pessoa (Nome,Peso,Altura,Email)" +
                "VALUES (?,?,?,?)";
        int linhas = 0;

        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            stmt.setString(1,p.getNome());
            stmt.setDouble(2,p.getPeso());
            stmt.setInt(3,p.getAltura());
            stmt.setString(4,p.getEmail());

            linhas = stmt.executeUpdate(query);

        }catch (Exception e){
            System.err.println("erro: " + e.toString());
        }
        if(linhas != 0){
            return true;
        }else{
            return false;
        }

    }

    public Pessoa obterPessoa(int idPessoa){

        String query = "SELECT * FROM Pessoa WHERE idPessoa = " + idPessoa;
        Pessoa p = new Pessoa();
        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            p.setIdPessoa(idPessoa);
            p.setNome(rs.getString("nome"));
            p.setAltura(rs.getInt("Altura"));
            p.setEmail(rs.getString("email"));
            p.setPeso(rs.getDouble("peso"));

            rs.close();
        }catch (Exception e){
            System.out.println("erro: " + e.toString());
        }
        return p;
    }

    public List<Pessoa> listarTodasPessoas(){
        List<Pessoa> pessoas = new ArrayList<>();
        String query = "SELECT * FROM Pessoa";

        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while(rs.next()){
                Pessoa p = new Pessoa();

                p.setIdPessoa(i);
                p.setNome(rs.getString("nome"));
                p.setAltura(rs.getInt("Altura"));
                p.setEmail(rs.getString("email"));
                p.setPeso(rs.getDouble("peso"));

                pessoas.add(p);
                i = i + 1;
            }

            rs.close();
        }catch (Exception e) {
            System.out.println("erro: " + e.toString());
        }
        return pessoas;
    }

    public int atualizarPessoa(Pessoa p){
        String query = "UPDATE PESSOA SET nome = ?, peso = ?, altura = ?, email = ? WHERE idPessoa = ?";
        int linhas = 0;
        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            stmt.setString(1,p.getNome());
            stmt.setDouble(2,p.getPeso());
            stmt.setInt(3,p.getAltura());
            stmt.setString(4,p.getEmail());
            stmt.setInt(3,p.getIdPessoa());

            linhas = stmt.executeUpdate(query);

        }catch (Exception e) {
            System.out.println("erro: " + e.toString());
        }
        return linhas;
    }

    public int atualizarVariasPessoas(String query){
        int linhas = 0;

        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            linhas = stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("erro: " + e.toString());
        }
        return linhas;
    }

    public int apagarPessoa(int idPessoa){
        String query = "DELETE * FROM Pessoa WHERE idPessoa = " + idPessoa;
        int linhas = 0;

        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            linhas = stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("erro: " + e.toString());
        }
        return linhas;
    }
}

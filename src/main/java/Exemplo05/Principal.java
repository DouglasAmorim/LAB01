package Exemplo05;
import Exemplo05.db.ConnectionFactory;

import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Principal {
    public void listar(){

        String query = "SELECT * FROM Aluno";


        try(Connection conexao = ConnectionFactory.getConnnection();
            PreparedStatement stmt = conexao.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("idAluno: " + rs.getInt("idAluno"));
                System.out.println("Nome: " + rs.getString("Nome"));
                System.out.println("Telefone: " + rs.getInt("Telefone"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("---------------------------------");
            }

            rs.close();
        }catch (Exception e){
            System.out.println("erro: " + e.toString());
        }
    }
    public static void main(String[] args) {
        Principal p = new Principal();
        p.listar();
    }
}

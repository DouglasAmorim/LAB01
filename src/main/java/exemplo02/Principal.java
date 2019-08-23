package exemplo02;

import exemplo02.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class Principal {

    public void inserir(){
        try(Connection conexao = ConnectionFactory.getConnnection();
            Statement stmt = conexao.createStatement()){

            String nome = "Maria";
            double peso = 80;
            int altura = 195;
            String email = "maria@teste.com";

            String query = "INSERT INTO Pessoa (Nome,Peso,Altura,Email)" +
                    "VALUES ('" + nome + "'," + peso + "," + altura + "," + "'" + email + "'" + ")";

            stmt.executeUpdate(query);

        }catch (Exception e){
            System.err.println("erro: " + e.toString());
        }




        String nome = "Jose";
        double peso = 65;
        int altura = 150;
        String email = "jose@teste.com";

        String query = "INSERT INTO Pessoa (Nome,Peso,Altura,Email)" +
                "VALUES ('" + nome + "'," + peso + "," + altura + "," + "'" + email + "'" + ")";
    }

    public static void main(String[] args) {

    }
}

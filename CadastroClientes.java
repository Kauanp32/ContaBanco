package ContaBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroClientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Estabelece a conexão com o banco de dados
        Connection connection = conectarAoBanco();

        while (true) {
           
        	System.out.println("Escolha uma operação:");
           
            System.out.println("1 - Listar Clientes");
            
            System.out.println("2 - Incluir Cliente");
           
            System.out.println("3 - Atualizar Cliente");
            
            System.out.println("4 - Deletar Cliente");
           
            System.out.println("5 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: // Listar Clientes
                    listarClientes(connection);
                    break;

                case 2: // Incluir Cliente
                	System.out.print("Nome do Cliente: ");
                    int cpf = scanner.nextInt();
                   
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                   
                    System.out.print("Email do Cliente: ");
                    String email = scanner.nextLine();
                   
                    System.out.print("Telefone do Cliente: ");
                    String telefone = scanner.nextLine();
                    
                    incluirCliente(connection, nome, email, telefone);
                    
                    System.out.println("Cliente incluído com sucesso!");
                    break;

                case 3: // Atualizar Cliente
                    
                	System.out.print("ID do Cliente a ser atualizado: ");
                    int idAtualizacao = scanner.nextInt();
                   
                    scanner.nextLine();
                   
                   
                    System.out.print("Novo Nome do Cliente: ");
                    String novoNome = scanner.nextLine();
                    
                    
                    System.out.print("Novo Email do Cliente: ");
                    String novoEmail = scanner.nextLine();
                    
                   
                    System.out.print("Novo Telefone do Cliente: ");
                    String novoTelefone = scanner.nextLine();
                    
                    atualizarCliente(connection, idAtualizacao, novoNome, novoEmail, novoTelefone);
                    
                    System.out.println("Cliente atualizado com sucesso!");
                    break;

                case 4: // Deletar Cliente
                    System.out.print("ID do Cliente a ser deletado: ");
                    int idDelecao = scanner.nextInt();
                    deletarCliente(connection, idDelecao);
                    System.out.println("Cliente deletado com sucesso!");
                    break;

                case 5: // Sair
                    scanner.close();
                    fecharConexao(connection);
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Connection conectarAoBanco() {
        
    	String dbURL = "jdbc:mysql://localhost:3306/cadastro";
        
        String dbUser = "root";
        
        String dbPassword = "senai";

        try {
            return DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listarClientes(Connection connection) {
        try {
            String query = "SELECT nome, e_mail, telefone, cpf FROM cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Lista de Clientes:");

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                
                String email = resultSet.getString("e_mail");
                
                String telefone = resultSet.getString("telefone");
                
                String CPF = resultSet.getString("telefone");
               
                System.out.println(nome + ", " + email + ", " + telefone + " , " + CPF);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void incluirCliente(Connection connection, String nome, String email, String telefone) {
        try {
            
        	String query = "INSERT INTO cliente (nome, e_mail, telefone, cpf) VALUES (?, ?, ?, ?)";
            
        	PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, nome);
            
            statement.setString(2, email);
            
            statement.setString(3, telefone);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarCliente(Connection connection, int id, String novoNome, String novoEmail, String novoTelefone) {
        try {
            
        	String query = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, novoNome);
            
            statement.setString(2, novoEmail);
            
            statement.setString(3, novoTelefone);
            
            statement.setInt(4, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deletarCliente(Connection connection, int id) {
        try {
            
        	String query = "DELETE FROM cliente WHERE id = ?";
            
        	PreparedStatement statement = connection.prepareStatement(query);
            
        	statement.setInt(1, id);
            
        	statement.executeUpdate();
            
        	statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
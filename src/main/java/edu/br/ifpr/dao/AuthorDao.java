/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.dao;

import edu.br.ifpr.model.entity.Author;
import edu.br.ifpr.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class AuthorDao implements Dao<Integer, Author> {

    @Override
    public void create(Author entity) {
        String sql = "INSERT INTO authors (name) "
                + "VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setString(1, entity.getName());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys();) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    entity.setAuthor_id(id);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar, verifique o log!");
        }

        String msg = "Author cadastrado!\n"
                + "Id: " + entity.getAuthor_id() + "\n"
                + "Nome: " + entity.getName();

        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public Author retrive(Integer id) {
        String sql = "SELECT * FROM author "
                + "WHERE author_id = ?";
        Author author = null;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    author = new Author();
                    author.setAuthor_id(rs.getInt("author_id"));
                    author.setName(rs.getString("name"));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return author;
    }

    @Override
    public void update(Author entity) {
        String sql = "UPDATE authors SET name = ? "
                + "WHERE author_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, entity.getName());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM authors "
                + "WHERE author_id = ? "
                + "AND NOT EXISTS("
                + "SELECT 1 "
                + "FROM books"
                + "WHERE author_id = ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Autor deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar o autor, pois o mesmo possui livros associados!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Author> findAll() {
        String sql = "SELECT * FROM authors";
        List<Author> authors = new LinkedList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Author author = new Author();
                author.setAuthor_id(rs.getInt("author_id"));
                author.setName(rs.getString("name"));

                authors.add(author);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return authors;
    }

}

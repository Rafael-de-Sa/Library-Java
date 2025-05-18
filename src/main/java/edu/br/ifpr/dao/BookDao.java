/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.dao;

import edu.br.ifpr.model.entity.Book;
import edu.br.ifpr.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class BookDao implements Dao<Integer, Book> {

    public AuthorDao authorDao = new AuthorDao();

    @Override
    public void create(Book entity) {
        String sql = "INSERT INTO books (name, pages, author_id) "
                + "VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getPages());
            pstmt.setInt(3, entity.getAuthor().getAuthor_id());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys();) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    entity.setBook_id(id);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar, verifique o log!");
        }

        String msg = "Livro cadastrado!\n"
                + "Id: " + entity.getBook_id() + "\n"
                + "Nome: " + entity.getName() + "\n"
                + "Páginas: " + entity.getPages() + "\n"
                + "Autor: " + entity.getAuthor().getName();

        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public Book retrive(Integer id) {
        String sql = "SELECT * FROM books "
                + "WHERE book_id = ?";
        Book book = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setName(rs.getString("name"));
                book.setPages(rs.getInt("pages"));
                book.setAuthor(authorDao.retrive(rs.getInt("author_id")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }

    @Override
    public void update(Book entity) {
        String sql = "UPDATE books "
                + "SET name = ?, pages = ?, author_id = ? "
                + "WHERE = book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getPages());
            pstmt.setInt(3, entity.getAuthor().getAuthor_id());
            pstmt.setInt(4, entity.getBook_id());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM books "
                + "WHERE book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);

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
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        List<Book> books = new LinkedList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setName(rs.getString("name"));
                book.setPages(rs.getInt("pages"));

                Integer author_id = (Integer) rs.getInt("author_id");

                book.setAuthor(authorDao.retrive(author_id));

                books.add(book);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return books;
    }

}

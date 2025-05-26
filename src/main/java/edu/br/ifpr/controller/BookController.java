/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.controller;

import edu.br.ifpr.dao.BookDao;
import edu.br.ifpr.model.entity.Author;
import edu.br.ifpr.model.entity.Book;
import edu.br.ifpr.view.tablemodel.BookTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class BookController {

    private BookTableModel bookTableModel;
    private BookDao bookDao = new BookDao();

    public BookController() {
    }

    public BookController(BookTableModel bookTableModel) {
        this.bookTableModel = bookTableModel;
    }

    public void setDataTableModel() {
        bookTableModel.setData(bookDao.findAll());
    }

    public BookTableModel getBookTableModel() {
        return bookTableModel;
    }

    public void setBookTableModel(BookTableModel bookTableModel) {
        this.bookTableModel = bookTableModel;
    }

    public boolean registerBook(String name, Integer pages, Author author) {
        Book book = new Book(name, pages, author);

        if (book.isValidRegister()) {
            bookDao.create(book);
            bookTableModel.add(book);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os dados cadastrados!");
            return false;
        }

    }

    public void removeBook(Integer row) {
        Book book = bookTableModel.get(row);
        if (bookDao.delete(book.getBook_id())) {
            bookTableModel.remove(row);
        }
    }

    public Book bookRetrieve(Integer row) {
        return bookTableModel.get(row);
    }

    public boolean bookUpdate(Integer id, String name, Integer pages, Author author) {
        Book book = new Book();
        book.setBook_id(id);
        book.setName(name);
        book.setPages(pages);
        book.setAuthor(author);

        if (book.isValidRegister()) {
            bookDao.update(book);
            bookTableModel.updateRow(book);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os dados cadastrados!");
            return false;
        }

    }

}

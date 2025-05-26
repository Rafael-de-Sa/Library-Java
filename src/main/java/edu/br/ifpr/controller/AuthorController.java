/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.controller;

import edu.br.ifpr.dao.AuthorDao;
import edu.br.ifpr.model.entity.Author;
import edu.br.ifpr.view.AuthorView;
import edu.br.ifpr.view.tablemodel.AuthorTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class AuthorController {

    private AuthorTableModel authorTableModel;
    private AuthorDao authorDao = new AuthorDao();

    public AuthorController() {
    }

    public AuthorController(AuthorTableModel authorTableModel) {
        this.authorTableModel = authorTableModel;
    }

    public void setDataTableModel() {
        authorTableModel.setData(authorDao.findAll());
    }

    public List<Author> dataComboBoxModel() {
        return authorDao.findAll();
    }

    public boolean registerAuthor(String name) {
        Author author = new Author(name);

        if (author.isValidRegister()) {
            authorDao.create(author);
            authorTableModel.add(author);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os dados cadastrados!");
            return false;
        }

    }

    public void removeAuthor(Integer row) {
        Author author = authorTableModel.get(row);
        if (authorDao.delete(author.getAuthor_id())) {
            authorTableModel.remove(row);
        }
    }

    public Author authorRetrieve(Integer row) {
        return authorTableModel.get(row);
    }

    public boolean authorUpdate(Integer id, String name) {
        Author author = new Author();
        author.setAuthor_id(id);
        author.setName(name);
        if (author.isValidRegister()) {
            authorDao.update(author);
            authorTableModel.updateRow(author);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os dados cadastrados!");
            return false;
        }
    }
}

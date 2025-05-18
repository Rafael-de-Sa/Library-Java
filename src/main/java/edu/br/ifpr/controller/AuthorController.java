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

/**
 *
 * @author rafael
 */
public class AuthorController {

    private AuthorTableModel authorTableModel;
    private AuthorDao authorDao = new AuthorDao();

    public AuthorController(AuthorTableModel authorTableModel) {
        this.authorTableModel = authorTableModel;
    }

    public void setDataTableModel() {
        authorTableModel.setData(authorDao.findAll());
    }

    public void registerAuthor(String name) {
        Author author = new Author(name);
        author = authorDao.create(author);

        authorTableModel.add(author);
    }

}

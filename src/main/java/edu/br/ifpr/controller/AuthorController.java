/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.controller;

import edu.br.ifpr.dao.AuthorDao;
import edu.br.ifpr.model.entity.Author;
import java.util.List;

/**
 *
 * @author rafael
 */
public class AuthorController {

    private Author author = new Author();
    private AuthorDao authorDao = new AuthorDao();

    public List<Author> setDataTableModel() {
        return authorDao.findAll();
    }

}

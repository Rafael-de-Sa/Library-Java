/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.br.ifpr;

import edu.br.ifpr.dao.AuthorDao;
import edu.br.ifpr.model.entity.Author;

/**
 *
 * @author rafael
 */
public class LibraryProject {
    
    public static void main(String[] args) {
        
        Author author = new Author("Clarice Lispector");
        AuthorDao authorDao = new AuthorDao();
        
        authorDao.create(author);
        
    }
}

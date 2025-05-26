/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.controller;

import edu.br.ifpr.view.AuthorView;
import edu.br.ifpr.view.BookView;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class IndexController {

    private AuthorView authorView;
    private BookView bookView;

    public void openAuthorView() {
        if (authorView != null) {
            if (authorView.isVisible()) {
                authorView.toFront();
            } else if (canOpenView()) {
                authorView = new AuthorView();
                authorView.setVisible(true);
            }
        } else if (canOpenView()) {
            authorView = new AuthorView();
            authorView.setVisible(true);

        }
    }

    public void openBookView() {
        if (bookView != null) {
            if (bookView.isVisible()) {
                bookView.toFront();
            } else if (canOpenView()) {
                bookView = new BookView();
                bookView.setVisible(true);
            }
        } else if (canOpenView()) {
            bookView = new BookView();
            bookView.setVisible(true);
        }
    }

    public boolean canOpenView() {
        if ((authorView != null && authorView.isVisible())
                || (bookView != null && bookView.isVisible())) {
            JOptionPane.showMessageDialog(null, "Feche as demais telas!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}

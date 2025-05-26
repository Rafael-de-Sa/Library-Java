/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.view.tablemodel;

import edu.br.ifpr.model.entity.Author;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author rafael
 */
public class AuthorComboBoxModel extends DefaultComboBoxModel<Author> {

    public AuthorComboBoxModel(List<Author> authors) {
        super();
        if (authors != null) {
            for (Author author : authors) {
                this.addElement(author);
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return (Author) super.getSelectedItem();
    }

    @Override
    public Author getElementAt(int index) {
        return super.getElementAt(index);
    }

}

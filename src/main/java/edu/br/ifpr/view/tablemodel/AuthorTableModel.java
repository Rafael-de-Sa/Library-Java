/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.view.tablemodel;

import edu.br.ifpr.controller.AuthorController;
import edu.br.ifpr.model.entity.Author;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafael
 */
public class AuthorTableModel extends AbstractTableModel {

    private AuthorController authorController = new AuthorController();
    private List<Author> data = new LinkedList<>(authorController.setDataTableModel());

    private String[] columns = {"ID", "Nome"};

    public AuthorTableModel() {
    }

    public Author get(int row) {
        return data.get(row);
    }

    public void add(Author a) {
        this.data.add(a);
        this.fireTableDataChanged();
    }

    public void remove(int row) {
        data.remove(row);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author author = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return author.getAuthor_id();
            case 1:
                return author.getName();
            default:
                return null;
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.view.tablemodel;

import edu.br.ifpr.model.entity.Author;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafael
 */
public class AuthorTableModel extends AbstractTableModel {

    private List<Author> data = new LinkedList<Author>();

    private String[] columns = {"ID", "Nome"};

    public AuthorTableModel() {
    }

    public List<Author> getData() {
        return data;
    }

    public void setData(List<Author> data) {
        this.data = data;
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

    public int getRowIndexById(Integer authorId) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getAuthor_id() == authorId) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela!", "Erro", JOptionPane.ERROR_MESSAGE);
        return -1;
    }

    public void updateRow(Author author) {
        int row = getRowIndexById(author.getAuthor_id());
        this.data.set(row, author);
        fireTableRowsUpdated(row, row);
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

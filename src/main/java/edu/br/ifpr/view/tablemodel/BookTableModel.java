/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.view.tablemodel;

import edu.br.ifpr.model.entity.Book;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafael
 */
public class BookTableModel extends AbstractTableModel {

    private List<Book> data = new LinkedList<Book>();
    private String[] columns = {"ID", "Nome", "Páginas", "Autor"};

    public BookTableModel() {
    }

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public Book get(int row) {
        return data.get(row);
    }

    public void add(Book b) {
        this.data.add(b);
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
        Book book = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return book.getBook_id();
            case 1:
                return book.getName();
            case 2:
                return book.getPages();
            case 3:
                return book.getAuthor().getName();

            default:
                return null;
        }

    }

}

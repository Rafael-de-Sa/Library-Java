/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.model.entity;

/**
 *
 * @author rafael
 */
public class Author {

    private Integer author_id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "author_id=" + author_id + ", name=" + name + '}';
    }

    public boolean isValidRegister() {
        return this.name.matches("^[\\p{L}\\s.]+$");
    }

}

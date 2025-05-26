/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.br.ifpr.model.entity;

import java.util.Objects;

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
        return author_id + " - " + name;
    }

    public boolean isValidRegister() {
        return this.name.matches("^[\\p{L}\\s.]+$") && this.name.length() <= 100;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Author author = (Author) obj;
        return Objects.equals(author_id, author.author_id);
    }
}

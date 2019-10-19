/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dani0
 */
public class Libro {
    String nombre;
    private String autor;
    private int codigo;
    int paginas;

    public Libro() {
    }

    public Libro(String nombre, String autor, int codigo, int paginas) {
        this.nombre = nombre;
        this.autor = autor;
        this.codigo = codigo;
        this.paginas = paginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    private String nombreLibro(){
        return "pregramacion 1";
    }
    
    public int numeroPaginas(int contar){
        return paginas + contar;
    }
}

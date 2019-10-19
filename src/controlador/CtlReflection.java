/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import modelo.Libro;
import org.reflections.Reflections;
import static vista.FrmVista.nombrePaquete;

/**
 *
 * @author dani0
 */
public class CtlReflection {

    Libro libro = new Libro();
    Class<? extends Libro> objetoDeClassConInfoDeMiClase = libro.getClass();
    String nombreDeLaClase = objetoDeClassConInfoDeMiClase.getSimpleName();

    String paquete;

    public DefaultComboBoxModel cargarClase(String nombrePaquete) {
        DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        mdl.addElement("Seleccione una clase");

        paquete = nombrePaquete;
        Class c;
        try {
            c = Class.forName(this.paquete + "." + this.nombreDeLaClase);
            mdl.addElement(c.getSimpleName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtlReflection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        Reflections reflections = new Reflections(paquete); /*Por reflection 
//        obtenemos la lista de clases que se encuentran dentro de ese paquete.*/
//        Class<? extends Object> func; // Todas esas clases heredan de JIPFunction
//        Object[] funcList = ((HashSet)reflections.getSubTypesOf(Object.class)).toArray(); // Se obtiene un array con las clases.
//
//        for (int cont=0; cont<funcList.length; cont++) {
//            func = (Class<? extends Object>)funcList[cont]; // Se convierte la clase JIPFunction
//            try {
//                Object jf = func.newInstance(); // Se obtiene una nueva instancia de la clase.
//            } catch (InstantiationException ex) {
//                Logger.getLogger(CtlReflection.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(CtlReflection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println(func.getName());  // Muestra el nombre de la clase (entero, con todos los paquetes)
//            mdl.addElement(func.getSimpleName());
//        }
        return mdl;
    }

    public DefaultComboBoxModel cargarAtributos(String nombreClase) {
        DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        Class class1;

        try {
            class1 = Class.forName(this.paquete+"."+nombreClase);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CtlReflection.class.getName()).log(Level.SEVERE, null, e);
            return mdl;
        }

        Field[] todasLosAtributosDeclarados = class1.getDeclaredFields();
        for (Field atributo : todasLosAtributosDeclarados){
            mdl.addElement(atributo.getName());
        }

        return mdl;
    }

    public DefaultComboBoxModel cargarMetodosClase(String nombreClase) {
        DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        Set<String> nombresMetodos = new HashSet<>();
        Class class1;

        try {
            class1 = Class.forName(this.paquete+"."+nombreClase);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CtlReflection.class.getName()).log(Level.SEVERE, null, e);
            return mdl;
        }

        Method[] metodos = class1.getDeclaredMethods();
        for (Method metodo : metodos) {
            nombresMetodos.add(metodo.getName());
        }
        
        nombresMetodos.forEach((nombreMetodo) -> {
            mdl.addElement(nombreMetodo);
        });

        return mdl;
    }

}

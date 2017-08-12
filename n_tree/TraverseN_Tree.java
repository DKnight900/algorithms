/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.n_tree;

import java.lang.reflect.Field;

/**
 *
 * @author 904935
 */
public class TraverseN_Tree {
    public static void main(String[] args) {
                        
        for(Field fd:Movie_actor.class.getDeclaredFields())
        {                        
            printFields(fd, Movie_actor.class.getName());
        }
        
    }
    private static void printFields(Field fd, String ancestorString)
    {
        
        System.out.println(fd.getGenericType());
        if(!fd.getGenericType().toString().equals("class java.lang.String"))        
        {
            for(Field fd_2:fd.getClass().getDeclaredFields()){                                                
                //if(fd_2.getGenericType().getClass().toString().)
                //printFields(fd_2, ancestorString+"."+fd.getGenericType().getClass().getName());
            }
        }
        //else
            //System.out.print(ancestorString+"."+fd.getGenericType().getClass().getName()+"\n");
        /*if(!(fd.getClass().getName().equals("java.lang.String")))
        {
            for(Field fd_2:fd.getClass().getDeclaredFields())
                printFields(fd_2, ancestorString+"."+fd.getClass().getName());
        }
        else
            System.out.print(ancestorString+"."+fd.getClass().getName()+"\n");*/
    }
}

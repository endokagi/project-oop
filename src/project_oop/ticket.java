/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_oop;

/**
 *
 * @author Witthawad Tanoi
 */
public class ticket {
    BookSystem booksystem;
    login lg;
    user User;
    car Car;
    Station station;
    
    public ticket() {
        System.out.println("Ticket : ");
        System.out.println("");
        System.out.println("Username : "+User.getName());
        System.out.println("From : "+booksystem.from);
        System.out.println("To : "+booksystem.to);
        System.out.println("Time : "+booksystem.time);
        System.out.println(Car.o_seat);
        System.out.println("Seat : "+Car.se_seat);
        
        
    }
    
}

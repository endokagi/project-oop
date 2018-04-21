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
import java.util.ArrayList;
public class Project_oop {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        login lg=new login();
        BookSystem booking=new BookSystem();
         user userAt=null;
         String input=null;
         boolean acc_login=false;
         boolean run=true;
         
         do{
             
             while(run){
                 System.out.println("Welcome to NoneTicket"
                         + "\nSelect below :\n");
                 System.out.print("(1 Login"
                         + "\n(2) Register"
                         + "\n(3) Exit"
                         + "\n $ Enter : ");
                 input=lg.string.nextLine();
                 System.out.println("");
                 switch(input){
                        case"1":
                            if(lg.login()){
                                userAt=lg.getUser();
                                acc_login=true;
                            }
                            else
                                System.out.println("not found! try again.\n");
                        break;
                         case"2":
                             lg.regis();
                         break;
                         case"3":
                             run=false;
                 }
             
             while(acc_login){
                 System.out.println("Menu :"
                         + "\nYou have "+userAt.getMoney()+" $");
                    System.out.print("\n(1) Buy Ticket "
                            + "\n(2) TopUp Money"
                            + "\n(3) Logout"
                            + "\n $ Enter ");
                    input=lg.string.nextLine();
                    System.out.println("");
                    switch(input){
                        case"1":
                            booking.buyTicket(userAt);
                            break;
                        case"2":
                            booking.topupMoney(userAt);
                            break;
                        case"3":acc_login=false;
                    }
             }}
         }while(run);   
    }   
}
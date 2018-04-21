
package project_oop;

import java.util.Scanner;
import java.util.ArrayList;

public class login{
        private ArrayList<user> u=new ArrayList();
        public Scanner string=new Scanner(System.in);
        
        user userat;
        String input;
        void regis(){
            String id_in=null;
            String pass_in=null;
            String name=null;
            boolean uncheck_id=true;
                while(uncheck_id){
                    System.out.println("Register\n");
                    System.out.print("Enter ID: ");
                    id_in=string.nextLine();
                    if(checkId(id_in)){
                        System.out.print("Enter password: ");pass_in=string.nextLine();
                        System.out.print("Enter Name: ");name=string.nextLine();
                        System.out.println("");
                        uncheck_id=false;
                    }else
                        System.out.println("This's ID already exist in system.");
                }
                user user_new=new user(name,id_in,pass_in);
                this.u.add(user_new);
                
                
        }
        boolean checkId(String input_id){
            boolean maisum= true;
            for(user user_u : u){
                if(user_u.getId().equals(input_id))
                    maisum= false;
            }
            return maisum;
        }
        boolean login(){
              boolean check=false;
              System.out.println("Login\n");
              System.out.print("Enter ID: ");
              String id=string.nextLine();
              System.out.print("Enter password: ");
              String pass=string.nextLine();
              for(user u_at : u){
                  if(u_at.getId().equals(id)&&u_at.getPass().equals(pass)){
                      check=true;
                      this.userat=u_at;
                      System.out.println("login success");
                      System.out.println("");
                      System.out.println("Welcome "+u_at.getName());
                      System.out.println("");
                  }     
              }
              return check;
        }
        user getUser(){
            return this.userat;
        
        }
        

}

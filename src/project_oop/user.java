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
public class user {
        private String id;
        private String password;
        private String name;
        private int money = 0;
        user(String name,String id,String pass){
            this.name=name;
            this.password=pass;
            this.id=id;
        }
        public void topupMoney(int money){
              this.money +=money;
        }
        public void payMoney(int money){
              this.money-=money;
        }
        public String getName(){
            return this.name; 
        }
        public String getId(){
            return this.id;
        }
        public String getPass(){
            return this.password;
        }
        public int getMoney(){
            return this.money;
        }
        
}

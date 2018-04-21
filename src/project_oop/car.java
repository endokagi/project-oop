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
import java.util.Scanner;
public abstract class car {
    private String round;
    private int price;
    private String[] seat;
    String se_seat,o_seat;
    int z=0;
    public Scanner String = new Scanner(System.in);
    public ArrayList<String> arr_seat = new ArrayList<String>();
    public car(String round,int price) {
        this.round = round;
        this.price = price;
    }
    
    void setSeat(int seat){
        this.seat = new String[seat];
        for(int i = 0;i<seat;i++){
            this.seat[i] =""+(i+1);
        }
    }
    int getPrice(){
        return price;
    }
    
    String getRound(){
        return round;
    }
    
    String[] getSeat(){
        return seat;
    }
    
    String showSeat(){
        o_seat=round;
        for(int i = 0;i<seat.length;i+=4){
            o_seat+="\n"+seat[i]+" "+seat[(i+1)]+"\t"+seat[i+2]+" "+seat[i+3];
        }
        return o_seat;
    }
    
    String[] selectSeat(){
        do{
        System.out.print(">> ");
        se_seat = String.nextLine();
        
        for(int i = 0;i<arr_seat.size();i++){
            if((se_seat.equals(arr_seat.get(i)))){
                System.out.println("This seat is full");
                selectSeat();
            }
        }arr_seat.add(se_seat);seat[arr_seat.size()] = "Full";z=1;
        
    }while(z!=1);return seat;
        }
    
    
    
    
}


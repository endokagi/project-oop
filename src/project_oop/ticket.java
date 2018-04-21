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
    private int stationAt,stationTo,time,nameCar;
    private String name,seat;

    public ticket(String name,int stationAt,int stationTo,int time,int nameCar,String seat) {
        this.name = name;
        this.nameCar = nameCar;
        this.stationAt = stationAt;
        this.stationTo = stationTo;
        this.time = time;
        this.seat =seat;
        this.nameCar = nameCar;
    }
    
    String Ticket() {
        String toString = "Ticket : \n"+
        "Username : "+name+"\nFrom : "+stationAt+
        "\nTo : "+stationTo+"\nTime : "+time+"Round "+nameCar+
        "\nSeat : "+seat;
        
        return toString;
    }
    
}

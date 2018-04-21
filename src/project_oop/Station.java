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
public abstract class Station{
    private String name;
    private car[][] car_go;
    private car[][] car_back;
    
    public Station(String name) {
        this.name ="Station "+ name;
    }
    
    String getName(){
        return name;
    }
    
    void setCar_go(car[][] car_go){
        this.car_go = car_go;
    }
    
    void setCar_back(car[][] car_back){
        this.car_back = car_back;
    }
    
    car[][] getCar_go(){
        return car_go;
    }
    
    car[][] getCar_back(){
        return car_back;
        
    }
    
    
    
}

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
public class Small_station extends Station{

    public Small_station(String name) {
        super(name);
        super.setCar_go(car_go());
        super.setCar_back(car_back());
    }
    
    car[][] car_go(){
        car car_go[][] =new car[2][6];
        for(int i = 0;i<car_go.length;i++){
            if(i==0){
                for(int j=0;j<car_go[i].length;j++){
                car_go[i][j]=new Van("Van Round "+(j+1));
                }
             }
            else
                for(int j=0;j<car_go[i].length;j++){
                    car_go[i][j] = new Mbus("Minibus Round "+(j+1));
                }
        }
        
        return car_go;
    } 
        car[][] car_back(){
        car car_back[][] =new car[2][6];
        for(int i = 0;i<car_back.length;i++){
            if(i==0){
                for(int j=0;j<car_back[i].length;j++){
                car_back[i][j]=new Van("Van Round "+(j+1));
                }
             }
            else
                for(int j=0;j<car_back[i].length;j++)
                    car_back[i][j] = new Mbus("Minibus Round "+(j+1));
        }
        
        return car_back;
    } 
    
}

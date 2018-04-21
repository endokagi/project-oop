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
import java.util.Scanner;
public class BookSystem {
        public Scanner number=new Scanner(System.in);
        public Scanner character=new Scanner(System.in);
        Station bus_stations[];
        String seat;
        int road,time,car,price,stationAt,stationTo;
        boolean check = false;
        car Car_At;
        user User_At;
        String[] r1 = {"08.00","10.00","12.00","14.00","16.00","18.00"};
        String[] r2 = {"07.00","09.00","11.00","13.00","15.00","17.00"};
        String input;
        BookSystem(){
            Big_station station_a = new Big_station("A");
            Small_station station_b=new Small_station("B");
            Small_station station_c = new Small_station("C");
            Small_station station_d = new Small_station("D");
            Big_station station_e = new Big_station("E");
         
            Station bus_stations[]={station_a,station_b,station_c,station_d,station_e};
            this.bus_stations=bus_stations; 
        }
        void topupMoney(user user_at){
            System.out.print("\nTopup Money"
                    + "\nHow much ?\n$");
             int money=number.nextInt();
            if(!(money>0&&money<1000000000)){
                System.out.println("topup money "+money+" Fail!");
                System.out.println("Please again\n");
                topupMoney(user_at);
            }else{
            System.out.println("topup money "+money+" Success!");
            user_at.topupMoney(money);
            System.out.println("");
            }
        }
        void buyTicket(user user_at){
            boolean buying=true;
            int stationAt;
            int stationTo;
            int time;
            do{
              System.out.print("Go press ( 1 )\n"+showtoGo()
                      +"\n\nReturn press ( 2 )\n"+showtoBack()
                      +"\n\nBack to menu press (B)"
                              + "\n Select: ");
              input=character.nextLine();
              switch(input){
                    case"1":
                        System.out.println("\nSelect station From\n"+showIndexFrom(1));
                        System.out.print("\nSelect: ");
                        stationAt=number.nextInt();
                        System.out.print("\nSelect station To\n"+showIndexTo(1,(5-stationAt)));
                        System.out.print("\nSelect: ");
                        stationTo=number.nextInt();
                        System.out.print("\nSelect Time\n"+showTime(1));
                        System.out.print("\nSelect: ");
                        time = number.nextInt();
                        System.out.print("\nSelect Car\n"+showCar(1,stationAt, time));
                        System.out.print("\nSelect: ");
                        car = number.nextInt();
                        System.out.print("Select Seat :"+showSeat(1, stationAt, time, car));
                        System.out.print("\nSelect: ");
                        seat = character.nextLine();
                        Car_At.selectSeat(seat);
                        price=calulate(1, stationTo);
                        System.out.println("All price is "+price);
                        
                        if(user_at.getMoney()>=price){
                            
                        System.out.print("You need confrim : "+"\nIf confrim pass (1)"
                                + "\nIf cancel and beck to menu pass (2)"
                                + "\n>> ");road = number.nextInt();
                                if(road==1){
                               user_at.payMoney(price);
                               ticket tk = new ticket(user_at.getName(),stationAt,stationTo,time,car,seat);
                                    System.out.println(tk.Ticket());
                               
                                }
                                else {System.out.println("Back to Menu");}
                                buying = false;
                                }else{System.out.println("You need topupMoney ");
                            buying = false;
                        }        
                        break;
                        
                    case"2":
                        do{
                        System.out.print("\nSelect station From\n"+showIndexFrom(2));
                        System.out.print("Select: ");
                        stationAt=number.nextInt();}while(!(stationAt>0&&stationAt<=bus_stations.length));
                        do{
                        System.out.print("\nSelect station To\n"+showIndexTo(2,stationAt));
                        System.out.print("\nSelect: ");
                        stationTo=number.nextInt();}while(!(stationTo>0&&stationTo<=(bus_stations.length-1)));
                        do{
                        System.out.print("\nSelect Time\n"+showTime(2));
                        System.out.print("\nSelect: ");
                        time = number.nextInt();}while(!(stationTo>0&&stationTo<=(bus_stations.length+1)));
                        do{
                        System.out.print("Select Car\n"+showCar(2,stationAt, time));
                        System.out.print("Select: ");
                        car = number.nextInt();}while(!(stationTo>0&&stationTo<=(bus_stations.length-3)));
                        do{
                        System.out.print("Select Seat :"+showSeat(2, stationAt, time, car));
                        System.out.print("Select: ");
                        seat = character.nextLine();
                        Car_At.selectSeat(seat);}while(!(stationTo>0&&stationTo<=(Car_At.getSeat().length)));
                        price=calulate(1, stationTo);
                        System.out.println("All price is "+price);
                        
                        if(user_at.getMoney()>=price){
                            
                        System.out.print("You need confrim : "+"\nIf confrim pass (1)"
                                + "\nIf cancel and beck to menu pass (2)"
                                + "\n>> ");road = number.nextInt();
                                if(road==1){
                               user_at.payMoney(price);
                               ticket tk = new ticket(user_at.getName(),stationAt,stationTo,time,car,seat);
                                    System.out.println(tk.Ticket());
                               
                                }
                                else {System.out.println("Back to Menu");}
                                buying = false;
                                }else{System.out.println("You need topupMoney ");
                            buying = false;
                        }        
                        break;
                    case"b":case"B":
                        buying=false;
                        
              }
            }while(buying);
                      
        }
        private String showtoGo(){
            String toGo="";
            
            for(int i=0;i<bus_stations.length;i++){
                toGo += bus_stations[i].getName()+" => ";
            }
            return toGo;
        }
        
        private String showtoBack(){
            String toBack = "";
            for(int i = 0;i<bus_stations.length;i++){
                toBack += "<="+bus_stations[i].getName();
            }
            return toBack;
        }
        
        private String showIndexFrom(int type){
            String output="";
            String index="";
            String name="";
            for(int i=0;i<bus_stations.length;i++){
                if(type==1)
                 name+=String.format("%-10s=>",bus_stations[i].getName());
                else if(type==2)
                        name+=String.format("%-10s<=",bus_stations[i].getName());
                 index+=String.format("%-4s(%-2s)%-4s","",(i+1),"");
            }
            output=name+"\n"+index;
            return output;
        }
        private String showIndexTo(int type,int indexfrom){
            String output="";
            String index="";
            String name="";
            if(type==1)
            for(int i=0;i<indexfrom;i++){
                 name+=String.format("%-10s=>",bus_stations[i+1].getName());
                 index+=String.format("%-4s(%-2s)%-4s","",(i+1),"");
            }
            else if(type==2)
            for(int i=indexfrom-1;i>=0;i--){
                 name+=String.format("%-10s=>",bus_stations[i-1].getName());
                 index+=String.format("%-4s(%-2s)%-4s","",(i+1),"");
            }
            output=name+"\n"+index;
            return output;
        }
        
        private String showTime(int type){
            String output ="";
            String time = "";
            String index = "";
            if(type==1){
                for(int i = 0;i<r1.length;i++){
                    time += String.format("%-5s", r1[i]+"  ");
                    index += String.format("%-8s",(i+1),"%-8s");
                    }
            }
            else if(type==2){
                for(int i = 0;i<r2.length;i++){
                    time += String.format("%-5s", r2[i]+"  ");
                    index += String.format("%-5s",(i+1),"%-5s");
                    }
            }
            output=time+"\n"+index;
            return output;
        }
        
        private String showCar(int type,int stationAt,int indexTime){
            String car="";
            car[][] car_at=null;
            Station StationAt=bus_stations[stationAt-1];
            if(type==1){
            car_at=StationAt.getCar_go();
            car="(1) "+car_at[0][indexTime-1].getRound()+"\n(2) "+
                car_at[1][indexTime-1].getRound();}
            else if(type==2){
            car_at=StationAt.getCar_back();
             car="(1) "+car_at[0][indexTime-1].getRound()+"\n(2) "+
            car_at[1][indexTime-1].getRound();}
            
            return car;
        }
        
        private String showSeat(int type,int stationAt,int indextime,int indexcar){
            String seat="";
            car[][] car_at=null;
            Station StationAt=bus_stations[stationAt-1];
            if(type==1){
                car_at=StationAt.getCar_go();
                Car_At=car_at[indexcar-1][indextime-1];
                seat = Car_At.showSeat();
                
            }else if(type==2){
                car_at=StationAt.getCar_back();
                Car_At=car_at[indexcar-1][indextime-1];
                seat = Car_At.showSeat();
 
            }
            return seat;
        }
        
        private int calulate(int type,int indexto){
            int cal = 0;
            
            if(type==1){
                cal = ((5-indexto)*50)+Car_At.getPrice();
            }
            else {
                    cal =((5-indexto)*30)+Car_At.getPrice();
                    
            }
            return cal;
        }
}

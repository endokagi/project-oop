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
        int road,from,to,time,car,z=0;
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
              System.out.println("Go( 1 )\n"+showtoGo()
                      +"\nReturn ( 2 )\n"+showtoBack()
                      +"\nBack(B)");
              input=character.nextLine();
              switch(input){
                    case"1":
                        System.out.println("Select station From\n"+showIndexFrom(1));
                        stationAt=number.nextInt();
                        System.out.println("Select station To\n"+showIndexTo(1,(5-stationAt)));
                        stationTo=number.nextInt();
                        System.out.println("Select Time\n"+showTime(1));
                        time = number.nextInt();
                        System.out.println("Select Car\n"+showCar(1,stationAt, time));
                        car = number.nextInt();
                        System.out.println("Select Seat\n"+showSeat(1,stationAt,time,car));
                       Car_At.selectSeat();
                        System.out.println("This all change of you is "+calulate(1, stationAt, stationTo, car, time));
                        
                        System.out.print("You need confrim"+"\nconfrim pass (1)"
                                + "\nCancel and beck to menu pass (2)"
                                + "\n>> ");road = number.nextInt();
                                if(road ==1){
                                    if(User_At.getMoney()<0){
                                        System.out.println("Your money not enongh");
                                        check = false;
                                    }
                                    else {ticket tk = new ticket();
                                    check = false;}
                                }else {check = false;}
                        break;
                    case"2":
                        System.out.println("Select station From\n"+showIndexFrom(2));
                        stationAt=number.nextInt();
                        System.out.println("Select station To\n"+showIndexTo(2,stationAt));
                        stationTo=number.nextInt();
                        System.out.println("Select Time\n"+showTime(2));
                        time = number.nextInt();
                        System.out.println("Select Car\n"+showCar(2,stationAt, time));
                        car = number.nextInt();
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
            car="(1)"+car_at[0][indexTime-1].getRound()+"\n(2)"+
                car_at[1][indexTime-1].getRound();}
            else if(type==2){
            car_at=StationAt.getCar_back();
             car="(1)"+car_at[0][indexTime-1].getRound()+"\n(2)"+
            car_at[1][indexTime-1].getRound();}
            
            return car;
        }
        
        private String showSeat(int type,int indexfrom,int indextime,int indexcar){
            String seat="";
            car[][] car_at=null;
            Station StationAt=bus_stations[indexfrom-1];
            if(type==1){
                car_at=StationAt.getCar_go();
                Car_At=car_at[indexcar-1][indextime-1];
                seat= Car_At.showSeat();
                
                
            }else if(type==2){
                car_at=StationAt.getCar_back();
                Car_At=car_at[indexcar-1][indextime-1];
                seat=Car_At.showSeat();
            }
            return seat;
        }
        private int calulate(int type,int indexfrom,int indexto,int indexcar,int indextime){
            int cal = 0;
            int money,money2;
            int test_cal = 0,test_cal2 = 0;
            car Car
            
            if(type==1){
                cal = test_cal+200;
                money2 = User_At.getMoney();
                money = money2 - cal;
                User_At.payMoney(money);
            }
            else {
                    test_cal =(5-indexto)*20;
            
            switch(indexcar){
                case 1:switch(indextime){
                    case 1:test_cal2 = 50; break;
                    case 2:test_cal2 = 50;break;
                    case 3:test_cal2 = 50;break;
                    case 4:test_cal2 = 50;break;
                    case 5:test_cal2 = 50;break;
                    case 6:test_cal2 = 50;break;
                }
                case 2:switch(indextime){
                    case 1:test_cal2 = 120; break;
                    case 2:test_cal2 = 120;break;
                    case 3:test_cal2 = 120;break;
                    case 4:test_cal2 = 120;break;
                    case 5:test_cal2 = 120;break;
                    case 6:test_cal2 = 120;break;
                }
            }
            cal = test_cal+test_cal2;
                 money2 = User_At.getMoney();
                 money = money2-cal;
                 User_At.payMoney(money);
}
            
            
            return money;
        }
}

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Driver {
    static
    {
        System.out.println("\n*******************************\n"+" Welcome To Vehicle ShowRoom!! "+"\n*******************************\n");
    }
    
    public static void main(String[] args) 
    {
        Vehicle DVeh = new Vehicle();
        DVeh.selectVehicle();
    }
    
}


class Vehicle
{
    static int getInput;
    static double getBudget;
    static String getAns;
    String setColor;
    int ModelNO,i, OwnerPhno;
    String Name, Color, Brake, VehicleNo, OwnerName, OwnerAdd, OwnerEmailId; 
    double Price;
    private String BankName,Branch;
    private int ChqNo;

    public String getBankName() 
    {
        return BankName;
    }
    public void setBankName(String bankName) 
    {
        BankName = bankName;
    }

    public int getChqNo() 
    {
        return ChqNo;
    }
    public void setChqNo(int chqNo) 
    {
        ChqNo = chqNo;
    }

    public String getBranch() 
    {
        return Branch;
    }
    public void setBranch(String branch) 
    {
        Branch = branch;
    }


    Scanner sc = new Scanner (System.in);

    Vehicle()
    {
        //No-Argument Constructor
    }
    Vehicle(int model,String name, String color, double price)
    {
        this();
        ModelNO = model;
        Name = name;
        Color = color;
        Price = price;
    }
    Vehicle(int model,String name, String color, String brake, double price)
    {
        this(model,name,color,price);
        Brake = brake;

    }
    Vehicle(int model,String name, String color, String brake,double price,String vhno)
    {
        this(model,name,color,brake,price);
        VehicleNo = vhno;
        

    }

   
    public void setBudget()
    {
        if(getBudget==0.0)
        {
            System.out.print("\nHave you Decided any Budget? Y/N : ");
            getAns = sc.next();
        }
        while(true)
        {
        if(getAns.equals("Y")||getAns.equals("y") )
        {
            System.out.print("\n'**Please Enter Above Rs.3000**'\n\nEnter Your Budget: ");
            if(getBudget==1.0 || getBudget==0.0)
            {
                getBudget = sc.nextInt();
            }
            else
            {
                if(getBudget>2999)
                {
                    System.out.println("\nYour Budget is Rs."+getBudget);
                    return;
                }
                else 
                {
                    System.out.println("\nxxxxxxxxxxxxxxxxxxxx\n\tInvalid Budget\nxxxxxxxxxxxxxxxxxxxx");
                    getBudget = 1.0;
                    setBudget();
                    return;
                }
             }

        }
        else if(getAns.equals("N")||getAns.equals("n"))
        {
            getBudget = 0;
            System.out.print("\n*************************");
            System.out.print("\nShowing All the Varients!");
            System.out.print("\n*************************\n");
            return;
        }
        else 
        {
            System.out.println("\nxxxxxxxxxxxxxxxxxxx\nInvalid Input\n**Enter Y/N**\nxxxxxxxxxxxxxxxxxxx");
            setBudget();
            return;
        }
    }
    }


    public void setUpdatedBudget(){
        
        if(getBudget>=1){
            System.out.println("\nDo you Want To Update Your Budget? Y/N : ");
            getAns = sc.next();
            if(getAns.equals("Y")||getAns.equals("y"))
            {
                getBudget=1.0;
                setBudget();
                i = 1;
                return;
            }
            else if(getAns.equals("N")||getAns.equals("n"))
            {
                System.out.println("Your Budget is: "+getBudget);
                i = 1;
            }
        }
    }


    public void checkBudget()
    {
        if(getBudget>=Price)
        {
            System.out.print(Name+" is Within Your Budget\nDid you Liked "+Name+"? Y/N : ");
            getAns = sc.next();
            if(getAns.equals("y")||getAns.equals("Y"))
            {
                System.out.print("Would You Like To Buy? Y/N : ");
                getAns = sc.next();
            }
            if(getAns.equals("y")||getAns.equals("Y"))
            {   
                sellVehicle();
            }
        else if(getAns.equals("n")||getAns.equals("N"))
            {
                System.out.print("Would Like Explore Other Options? Y/N : ");
                getAns = sc.next();
                if(getAns.equals("y")||getAns.equals("Y"))
                {
                    return;
                }
                else
                {
                    System.out.println("\nReverting Back");
                    return;
                }
            }
        }
        else
        {
            System.out.println(Name+" is Not In Your Budget Rs."+Price);
                getBudget=1;
                setUpdatedBudget();
                return;
        }    
    }


    public void setColor()
    {
    System.out.print("Which Color Did You Liked?\n"+Color+"\nSelect Your Choice: ");
        setColor = sc.next();
        if(setColor.equals("pink")||setColor.equals("black")||setColor.equals("red")||setColor.equals("blue"))
        {
            this.Color = setColor;
            return;
        }
        else
        {
            System.out.print("Invalid Color\n");
            setColor();
        }

    }


    public void getOwnerInfo()
    { 
        System.out.print("Please Enter Your Name : ");
        OwnerName = sc.next();
        System.out.print("Please Enter Your Address : "); 
        OwnerAdd = sc.nextLine(); 
        System.out.print("Please Enter Your Email ID :  "); 
        OwnerEmailId = sc.next();
        System.out.print("Please Enter Your Phone No. : ");
        OwnerPhno = sc.nextInt();
    }


    public void sellVehicle()
    {
        if(getAns.equals("y")||getAns.equals("Y"))
        {
            System.out.print("How Would You Like To Pay Rs."+Price+"\n1.Cheque\n2.Online Transfer\n3.Cash\nSelect Your Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            switch(getInput)
            {
                case 1:System.out.println("_Check");
                        getOwnerInfo();
                        System.out.print("Enter Bank Name: ");
                        BankName = sc.next();
                        System.out.print("Enter Bank Branch: ");
                        Branch = sc.next();
                        System.out.print("Enter Bank Chq No: ");
                        ChqNo = sc.nextInt();
                        try{
                        System.out.println("Processing Your Payment");
                        TimeUnit.SECONDS.sleep(15);
                        }
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                        System.out.println("You Payment is Processed Sucessfully");
                        System.out.println("You Paid : "+Price);
                        System.out.println("Using Cheque : "+ChqNo);
                        System.out.print("Your "+Name+"\nModel No. "+ModelNO+"\nColor :"+Color);
                        System.out.println(" Will Be Dileverd Soon!!");
                        System.out.println("Thankyou you For Purchasing "+Name);
                        i = 0;
                        break;
                case 2:System.out.println("_Thankyou payement recived!!");
                        break;
                case 3:System.out.println("_Thankyou payement recived!!");
                        break;

            }            
        }
    }


    public void selectVehicle()
    {
        
        System.out.print("We Have Various Types Of Vehicles:\n1.Two Wheeler\n2.Three Wheeler\n3.Four Wheeler\n4.Six Wheeler\n5.Eight Wheeler\n0.Exit\n\nSelect Your Choice: ");
        getInput = sc.nextInt();
        System.out.print("\nYou Have Selected: " +getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_TwoWheeler");
                       ITwoWheel TWVeh = new TwoWheeler();
                        if(getBudget==0.0)
                        {
                            getBudget=0.0;
                            setBudget();
                            TWVeh.selectTwoWheeler();
                        }
                        else
                        {
                            setUpdatedBudget();
                            TWVeh.selectTwoWheeler();
                        }
                return;

                case 2:
                        return;

                case 3:
                        return;

                case 4:
                        return;

                case 5:
                        return;

                case 0:System.out.println("\n##############################\n_Thankyou Visit US Again!!_\n##############################\n");
                       return;

                default:System.out.print("_Please Select Correct Choice");
                        selectVehicle();
                return;

            }

        }

    }
}

interface ITwoWheel
{
    void selectTwoWheeler();
}

class TwoWheeler extends Vehicle implements ITwoWheel
{
    TwoWheeler(){

    }
    TwoWheeler(int model,String name, String color, String brake, double price)
    {
        super(model,name,color,brake,price);
    }
    public void selectTwoWheeler() 
    {
        if(getBudget>=3000 && getBudget<=60000)
        {
            System.out.print("\nVarints Available in TwoWheeler for your Budget Rs."+getBudget+"\n\n1.Cycle\n0.Exit from Two Wheeler\n\nSelect Your Choice : ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_Cycle");
                           ICycle TWCy = new Cycle();
                           TWCy.selectCycle();
                    return;

                    case 0:System.out.println("_Returning back to Vehicle Types");
                           selectVehicle();
                    return;

                    default:System.out.println("_Please Select Correct Choice");
                            selectTwoWheeler();
                    return;
                }

            }
        }
        else if(getBudget==0 || getBudget>=60001)
        {
            System.out.print("\nVarints Available in TwoWheeler for your Budget Rs."+getBudget+"\n\n1.Cycle\n2.Bikes\n0.Exit from Two Wheeler\n\nSelect Your Choice : ");
            getInput = sc.nextInt();
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_Cycle");
                           Cycle TWCy = new Cycle();
                           TWCy.selectCycle();
                    return;

                    case 2:System.out.println("_Bikes");
                    return;

                    case 0:System.out.println("_Returning back to Vehicle Types");
                           selectVehicle();
                    return;

                    default:System.out.println("_Please Select Correct Choice");
                            selectTwoWheeler();
                    return;
                }

            }
        }
        
    }

}

interface ICycle
{
    void selectCycle();
}

class Cycle extends TwoWheeler implements ICycle
{
    Cycle()
    {

    }
    Cycle(int model,String name, String color, String brake, double price)
    {
        super(model,name,color,brake,price);
    }
    public void selectCycle() {
        System.out.print("Brands Available for Cycles are\n\n1.Hero\n2.Atlas\n0.Exit From Cycles\n\nSelect your Choice : ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_HeroCycle");
                       IHero c1 = new Hero();
                       c1.selectHero();
                return;

                case 2:System.out.println("_AtlasCycle");
                return;

                case 0:System.out.println("_Returning Back to Variants");
                        selectTwoWheeler();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectCycle();
                return;
            }
        }
        
    }

}

interface IHero
{
    void selectHero();
}

class Hero extends Cycle implements IHero
{   
    Hero(){

    }
    Hero(int model,String name, String color, String brake, double price)
    {
        super(model,name,color,brake,price);
    }
    public void selectHero()
    {
        if(getBudget==0 || getBudget>=3000)
        {
            System.out.println("Showing Cycles in Range of (Rs.3000-Rs.10000)\nYour Budget is Rs."+getBudget+"\n");
            Hero c1 = new Hero(5268,"Hero Cyclone","1.Black,2.Blue,3.Red","Regular",3500);
            Hero c2 = new Hero(5268,"Hero LadyBird","Pink,Black,Red","Regular",5000);
            Hero c3 = new Hero(5268,"Hero Mountain","Black,Blue,Red","Disk",20000);
            Hero c4 = new Hero(5268,"Hero Lectro F6I","Black,Blue,Red","Disk",56000);

            System.out.print("\n========================");
            System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
            System.out.print("\n========================\n");
            System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
            System.out.print("\n========================\n");
            System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
            System.out.print("\n========================\n");
            System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
            System.out.print("\n========================");

            System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_Hero Cyclone");
                           this.Color = c1.Color;
                           setColor();
                           this.Name = c1.Name;
                           this.ModelNO = c1.ModelNO;
                           this.Price = c1.Price;
                           checkBudget();
                           if(i==1)
                           { 
                           selectHero(); 
                           }                                                  
                    return;
                    case 2:System.out.println("_Hero Cyclone");
                            this.Color = c2.Color;
                            setColor();
                            this.Name = c2.Name;
                            this.ModelNO = c2.ModelNO;
                            this.Price = c2.Price;
                            checkBudget(); 
                            selectHero();  
                }
            }
        }
    }
}


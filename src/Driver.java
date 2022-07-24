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
    int ModelNO,i;
    String Name, Color, Brake, VehicleNo,Engine, OwnerName, OwnerAdd, OwnerEmailId; 
    double Price;
    long OwnerPhno;
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

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
    
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    static String getAlphaString(int ch,int no)
    {
  
        // chose a Character random from this String
        String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
        // create StringBuffer size of AlphaString
        StringBuilder sbch = new StringBuilder(ch);
  
        for (int i = 0; i < ch; i++) {
  
            // generate a random number between
            // 0 to AlphaString variable length
            int index
                = (int)(AlphaString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sbch.append(AlphaString
                          .charAt(index));
        }

        String AlphaNumericString = "0123456789";

        StringBuilder sbno = new StringBuilder(no);

        for (int i = 0; i < no; i++) {
  
            // generate a random number between
            // 0 to AlphaString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sbno.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sbch.toString()+sbno.toString();
    }

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
    Vehicle(int model,String name, String color, String brake,double price,String engine,String vehno)
    {
        this(model,name,color,brake,price);
        Engine = engine;
        VehicleNo = vehno;
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
                setColor();
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
                    i=1;
                    return;
                }
                else
                {
                    System.out.println("\nReverting Back to Brands");
                    i=2;
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
    System.out.print("Which Color Did You Liked?\n"+Color+"\n\nSelect Your Choice: ");
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
        System.out.print("\n***************************************\nPlease Provide Some Basic Info\n*************************************************");
        OwnerName = sc.nextLine();
        System.out.print("\nPlease Enter Your Name : ");
        OwnerName = sc.nextLine();
        System.out.print("\nPlease Enter Your Address : "); 
        OwnerAdd = sc.nextLine(); 
        System.out.print("\nPlease Enter Your Email ID :  "); 
        OwnerEmailId = sc.nextLine();
        System.out.print("\nPlease Enter Your Phone No. : ");
        OwnerPhno = sc.nextLong();
    }


    public void sellVehicle()
    {
        if(getAns.equals("y")||getAns.equals("Y"))
        {   
            getOwnerInfo();
            System.out.print("\n"+capitalize(OwnerName)+" How Would You Like To Pay Rs."+Price+"\n1.Cheque\n2.Online Transfer\n3.Cash\n\nSelect Your Choice: ");
            getInput = sc.nextInt();
            System.out.print("\nYou Have Selected: "+getInput);
            switch(getInput)
            {
                case 1:System.out.println("_Check");
                        System.out.print("\nEnter Bank Name: ");
                        BankName = sc.next();
                        System.out.print("\nEnter Bank Branch: ");
                        Branch = sc.next();
                        System.out.print("\nEnter Bank Chq No: ");
                        ChqNo = sc.nextInt();
                        System.out.println("\nProcessing Your Payment...");
                        try{
                            TimeUnit.SECONDS.sleep(15);
                        }
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                        System.out.println("\n*******************************\nThankyou For Waiting\n*******************************");
                        System.out.println("\nYou Payment is Processed Sucessfully!!");
                        
                        System.out.println("\nBank Name : "+capitalize(BankName));
                        if(getBudget>Price)
                        {
                            System.out.println("You Budget Was Rs."+getBudget+" and You have Paid Rs."+Price);
                            System.out.println("\n*******************\nYou Saved From Your Budget Rs."+(getBudget-Price)+"\n***********************\n");
                        }
                        else
                        {
                            System.out.println("\nYou Paid : "+Price+"\nUsing Cheque : "+ChqNo);
                        }
                        System.out.print("\nYour "+Name+"\nModel No. "+ModelNO+"\nColor :"+capitalize(Color));
                        if(VehicleNo.equals("1"))
                        {   
                            int ch = 2;
                            int no = 4;
                            System.out.print("\nYour Vehicle No. Is MH04"+getAlphaString(ch,no));
                        }
                        System.out.println(" Will Be Dileverd Soon to "+OwnerAdd+" !");
                        System.out.println("\n"+capitalize(OwnerName)+" Thankyou you For Purchasing "+Name);
                        System.out.println("\n"+capitalize(OwnerName)+" Visit Us Again!! ");
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
        
        System.out.print("We Have Various Types Of Vehicles:\n1.Two Wheeler\n2.Four Wheeler\n0.Exit\n\nSelect Your Choice: ");
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
                            setBudget();
                            TWVeh.selectTwoWheeler();
                       }
                       else
                       {
                        setUpdatedBudget();
                        TWVeh.selectTwoWheeler();
                       }
                            
                return;

                case 2:System.out.println("_FouroWheeler");
                        IFourWheel FWVeh = new FourWheeler(); 
                        if(getBudget==0.0)
                       {
                            setBudget();
                            FWVeh.selectFourWheeler();
                       }
                       else
                       {
                            setUpdatedBudget();
                            FWVeh.selectFourWheeler();
                       } 
                return;

                case 0:System.out.println("\n##############################\n_Thankyou Visit US Again!!_\n##############################\n");
                       return;

                default:System.out.print("_Please Select Correct Choice\n");
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
    TwoWheeler(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    public void selectTwoWheeler() 
    {
        {
            System.out.print("\nVarints Available in TwoWheeler for your Budget Rs."+getBudget+"\n\n1.Cycle\n2.Bikes\n0.Exit from Two Wheeler\n\nSelect Your Choice : ");
            getInput = sc.nextInt();
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_Cycle");
                           ICycle TWCy = new Cycle();
                           TWCy.selectCycle();
                    return;

                    case 2:System.out.println("_Bikes");
                            IBikes TWBk = new Bikes();
                            TWBk.selectBikes();
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
                        IAtlas a1 = new Atlas();
                        a1.selectAtlas();
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
            System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
            Hero c1 = new Hero(5268,"Hero Cyclone","1.Black,2.Blue,3.Red","Regular",3500);
            Hero c2 = new Hero(3218,"Hero LadyBird","Pink,Black,Red","Regular",5000);
            Hero c3 = new Hero(6548,"Hero Mountain","Black,Blue,Red","Disk",20000);
            Hero c4 = new Hero(3215,"Hero Lectro F6I","Black,Blue,Red","Disk",56000);

            System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_"+c1.Name);
                           System.out.print("\n========================\n");
                           System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                           System.out.print("\n========================\n");
                           this.Color = c1.Color;
                           this.Name = c1.Name;
                           this.ModelNO = c1.ModelNO;
                           this.Price = c1.Price;
                           checkBudget();
                           if(i==1)
                           { 
                           selectHero(); 
                           }
                           if(i==2)
                           {
                            selectCycle();
                           }                                                  
                    return;
                    case 2:System.out.println("_"+c2.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                            System.out.print("\n========================\n");
                            this.Color = c2.Color;
                            this.Name = c2.Name;
                            this.ModelNO = c2.ModelNO;
                            this.Price = c2.Price;
                            checkBudget();
                            if(i==1)
                           { 
                           selectHero(); 
                           }
                           if(i==2)
                           {
                            selectCycle();
                           }     
                    return;
                    case 3:System.out.println("_"+c3.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                            System.out.print("\n========================\n");
                           this.Color = c3.Color;
                           this.Name = c3.Name;
                           this.ModelNO = c3.ModelNO;
                           this.Price = c3.Price;
                           checkBudget();
                           if(i==1)
                          { 
                          selectHero(); 
                          }  
                          if(i==2)
                          {
                           selectCycle();
                          }   
                    return;
                    case 4:System.out.println("_"+c4.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                            System.out.print("\n========================\n");
                          this.Color = c4.Color;
                          this.Name = c4.Name;
                          this.ModelNO = c4.ModelNO;
                          this.Price = c4.Price;
                          checkBudget();
                          if(i==1)
                         { 
                         selectHero(); 
                         }
                         if(i==2)
                         {
                          selectCycle();
                         }   
                    return;
                    case 0:System.out.println("_Returning Back to Brands");
                            selectCycle();
                    return;
 
                    default:System.out.print("_Please Select Correct Choice");
                            selectHero();
                    return;
                }
            }
        }
    }

interface IAtlas {
    void selectAtlas();
}

class Atlas extends Cycle implements IAtlas
{   
    Atlas(){

    }
    Atlas(int model,String name, String color, String brake, double price)
    {
        super(model,name,color,brake,price);
    }
    public void selectAtlas()
    {

            System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
            Atlas c1 = new Atlas(4510,"Atlas Ultimate City","1.Black,2.Blue,3.Red","Regular",7262);
            Atlas c2 = new Atlas(2156,"Atlas Rapid Plus","1.Pink,2.Black,3.Red","Regular",11730);
            Atlas c3 = new Atlas(5635,"Atlas Peak Boss","1.Black,2.Blue,3.Red","Disk",26850);
            Atlas c4 = new Atlas(9871,"Atlas Kids Mettal 20","1.Black,2.Blue,3.Red","Disk",5300);
            
            System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\n0.Return To Brands\n\nSelect Cycle Name Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_"+c1.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                            System.out.print("\n========================\n");
                           this.Color = c1.Color;
                           this.Name = c1.Name;
                           this.ModelNO = c1.ModelNO;
                           this.Price = c1.Price;
                           checkBudget();
                           if(i==1)
                           { 
                            selectAtlas();  
                           } 
                           if(i==2)
                           {
                            selectCycle();
                           }                                                    
                    return;
                    case 2:System.out.println("_"+c2.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                            System.out.print("\n========================\n");
                            this.Color = c2.Color;
                            this.Name = c2.Name;
                            this.ModelNO = c2.ModelNO;
                            this.Price = c2.Price;
                            checkBudget();
                            if(i==1)
                           { 
                            selectAtlas();  
                           } 
                           if(i==2)
                           {
                            selectCycle();
                           }    
                    case 3:System.out.println("_"+c3.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                            System.out.print("\n========================\n");
                           this.Color = c3.Color;
                           this.Name = c3.Name;
                           this.ModelNO = c3.ModelNO;
                           this.Price = c3.Price;
                           checkBudget();
                           if(i==1)
                          { 
                            selectAtlas(); 
                          } 
                          if(i==2)
                          {
                           selectCycle();
                          }    
                    case 4:System.out.println("_"+c4.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                            System.out.print("\n========================\n");
                          this.Color = c4.Color;
                          this.Name = c4.Name;
                          this.ModelNO = c4.ModelNO;
                          this.Price = c4.Price;
                          checkBudget();
                          if(i==1)
                         { 
                         selectAtlas(); 
                         }
                         if(i==2)
                         {
                          selectCycle();
                         }   
                    case 0:System.out.println("_Returning Back to Brands");
                            selectCycle();
                    return;

                    default:System.out.print("_Please Select Correct Choice");
                            selectAtlas();
                    return;  
                }
            }
        }
    }

interface IBikes
{
    void selectBikes();
}

class Bikes extends TwoWheeler implements IBikes
{
    Bikes()
    {

    }
    Bikes(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectBikes() {
        System.out.print("Brands Available for Bikes are\n\n1.Honda\n2.Royal EnField\n0.Exit From Bikes\n\nSelect your Choice : ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_Honda");
                        IHonda c1 = new Honda();
                        c1.selectHonda();
                return;

                case 2:System.out.println("_Royal EnFiled");
                        IRoyalEnFiled RE1 = new RoyalEnFiled();
                        RE1.selectRoyalEnFiled();
                return;

                case 0:System.out.println("_Returning Back to Variants");
                        selectTwoWheeler();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectBikes();
                return;
            }
        }
    }
}

interface IHonda
{
    void selectHonda();
}

class Honda extends Bikes implements IHonda
{
    Honda(){

    }
    Honda(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectHonda()
    {   
            System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
            Honda c1 = new Honda(5268,"Honda Activa","1.Black,2.Blue,3.Red","Regular",90000,"100cc","1");
            Honda c2 = new Honda(3218,"Honda Activa 125","Pink,Black,Red","Disk",110000,"120cc","1");
            Honda c3 = new Honda(6548,"Honda Shine","Black,Blue,Red","Disk",84500,"125cc","1");
            Honda c4 = new Honda(3215,"Honda CBR 250","Black,Blue,Red","Disk",180000,"250cc","1");

            System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_"+c1.Name);
                           System.out.print("\n========================\n");
                           System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                           System.out.print("\n========================\n");
                           this.Color = c1.Color;
                           this.Name = c1.Name;
                           this.ModelNO = c1.ModelNO;
                           this.Price = c1.Price;
                           this.VehicleNo = c1.VehicleNo;
                           this.Engine = c1.Engine;
                           checkBudget();
                           if(i==1)
                           { 
                           selectHonda(); 
                           }
                           if(i==2)
                           {
                            selectBikes();
                           }                                                  
                    return;
                    case 2:System.out.println("_"+c2.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                            System.out.print("\n========================\n");
                            this.Color = c2.Color;
                            this.Name = c2.Name;
                            this.ModelNO = c2.ModelNO;
                            this.Price = c2.Price;
                            this.VehicleNo = c2.VehicleNo;
                            this.Engine = c2.Engine;
                            checkBudget();
                            if(i==1)
                           { 
                           selectHonda(); 
                           }
                           if(i==2)
                           {
                            selectBikes();
                           }     
                    return;
                    case 3:System.out.println("_"+c3.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                            System.out.print("\n========================\n");
                           this.Color = c3.Color;
                           this.Name = c3.Name;
                           this.ModelNO = c3.ModelNO;
                           this.Price = c3.Price;
                           this.VehicleNo = c3.VehicleNo;
                           this.Engine = c3.Engine;
                           checkBudget();
                           if(i==1)
                          { 
                          selectHonda(); 
                          }  
                          if(i==2)
                          {
                           selectBikes();
                          }   
                    return;
                    case 4:System.out.println("_"+c4.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                            System.out.print("\n========================\n");
                          this.Color = c4.Color;
                          this.Name = c4.Name;
                          this.ModelNO = c4.ModelNO;
                          this.Price = c4.Price;
                          this.VehicleNo = c4.VehicleNo;
                           this.Engine = c4.Engine;
                          checkBudget();
                          if(i==1)
                         { 
                         selectHonda(); 
                         }
                         if(i==2)
                         {
                          selectBikes();
                         }   
                    return;
                    case 0:System.out.println("_Returning Back to Brands");
                            selectBikes();
                    return;
 
                    default:System.out.print("_Please Select Correct Choice");
                            selectHonda();
                    return;
                }
            }
        }

}

interface IRoyalEnFiled
{
    void selectRoyalEnFiled();
}

class RoyalEnFiled extends Bikes implements IRoyalEnFiled
{
    RoyalEnFiled()
    {

    }
    RoyalEnFiled(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectRoyalEnFiled()
    {   
            System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
            RoyalEnFiled c1 = new RoyalEnFiled(5268,"Royal EnFiled Himalayan","1.Black,2.Blue,3.Red","Regular",222000,"411cc","1");
            RoyalEnFiled c2 = new RoyalEnFiled(3218,"Royal EnFiled Classic","Pink,Black,Red","Regular",180000,"350cc","1");
            RoyalEnFiled c3 = new RoyalEnFiled(6548,"Royal EnFiled Bullet","Black,Blue,Red","Disk",190500,"500cc","1");
            RoyalEnFiled c4 = new RoyalEnFiled(3215,"Royal EnFiled Continental GT650","Black,Blue,Red","Disk",320000,"650cc","1");

            System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
            getInput = sc.nextInt();
            System.out.print("You Have Selected: "+getInput);
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_"+c1.Name);
                           System.out.print("\n========================\n");
                           System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                           System.out.print("\n========================\n");
                           this.Color = c1.Color;
                           this.Name = c1.Name;
                           this.ModelNO = c1.ModelNO;
                           this.Price = c1.Price;
                           this.VehicleNo = c1.VehicleNo;
                           this.Engine = c1.Engine;
                           checkBudget();
                           if(i==1)
                           { 
                           selectRoyalEnFiled();
                           }
                           if(i==2)
                           {
                            selectBikes();
                           }                                                  
                    return;
                    case 2:System.out.println("_"+c2.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                            System.out.print("\n========================\n");
                            this.Color = c2.Color;
                            this.Name = c2.Name;
                            this.ModelNO = c2.ModelNO;
                            this.Price = c2.Price;
                            this.VehicleNo = c2.VehicleNo;
                            this.Engine = c2.Engine;
                            checkBudget();
                            if(i==1)
                           { 
                           selectRoyalEnFiled(); 
                           }
                           if(i==2)
                           {
                            selectBikes();
                           }     
                    return;
                    case 3:System.out.println("_"+c3.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                            System.out.print("\n========================\n");
                           this.Color = c3.Color;
                           this.Name = c3.Name;
                           this.ModelNO = c3.ModelNO;
                           this.Price = c3.Price;
                           this.VehicleNo = c3.VehicleNo;
                           this.Engine = c3.Engine;
                           checkBudget();
                           if(i==1)
                          { 
                          selectRoyalEnFiled(); 
                          }  
                          if(i==2)
                          {
                           selectBikes();
                          }   
                    return;
                    case 4:System.out.println("_"+c4.Name);
                            System.out.print("\n========================\n");
                            System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                            System.out.print("\n========================\n");
                          this.Color = c4.Color;
                          this.Name = c4.Name;
                          this.ModelNO = c4.ModelNO;
                          this.Price = c4.Price;
                          this.VehicleNo = c4.VehicleNo;
                           this.Engine = c4.Engine;
                          checkBudget();
                          if(i==1)
                         { 
                            selectRoyalEnFiled(); 
                         }
                         if(i==2)
                         {
                          selectBikes();
                         }   
                    return;
                    case 0:System.out.println("_Returning Back to Brands");
                            selectBikes();
                    return;
 
                    default:System.out.print("_Please Select Correct Choice");
                            selectRoyalEnFiled();
                    return;
                }
            }
        }
}

interface IFourWheel
{
    void selectFourWheeler();
}

class FourWheeler extends Vehicle implements IFourWheel
{
    FourWheeler(){

    }
    FourWheeler(int model,String name, String color, String brake, double price)
    {
        super(model,name,color,brake,price);
    }
    FourWheeler(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    public void selectFourWheeler() 
    {
        {
            System.out.print("\nDisplaying Varints Available in FourWheeler And Your Budget Rs."+getBudget+"\n\n1.Automatic\n2.Manual\n0.Exit from Four Wheeler\n\nSelect Your Choice : ");
            getInput = sc.nextInt();
            while(true)
            {
                switch(getInput)
                {
                    case 1:System.out.println("_Automatic");
                           IAutomatic FWAu = new Automatic();
                           FWAu.selectAutomatic();
                    return;

                    case 2:System.out.println("_Manual");
                            IManual FWMa = new Manual();
                            FWMa.selectManual();

                    return;

                    case 0:System.out.println("_Returning back to Vehicle Types");
                           selectVehicle();
                    return;

                    default:System.out.println("_Please Select Correct Choice");
                            selectFourWheeler();
                    return;
                }

            }
        }
        
    }
}

interface IAutomatic
{
    void selectAutomatic();
}

class Automatic extends FourWheeler implements IAutomatic
{
    Automatic()
    {

    }
    Automatic(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectAutomatic() {
        System.out.print("Brands Available for Automatic Four Wheelers are\n1.Tesla\n2.Rolls Royce\n0.Exit From Automatic Four Wheeler\n\nSelect your Choice : ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_Tesla");
                        ITesla T1 = new Tesla();
                        T1.selectTesla();
                return;

                case 2:System.out.println("_Rolls Royce");
                        IRoyalEnFiled RE1 = new RoyalEnFiled();
                        RE1.selectRoyalEnFiled();
                return;

                case 0:System.out.println("_Returning Back to Variants");
                        selectFourWheeler();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectAutomatic();
                return;
            }
        }
    }
}

interface ITesla
{
    void selectTesla();
}

class Tesla extends Automatic implements ITesla
{
    Tesla(){

    }
    Tesla(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectTesla()
    {   
        System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
        Tesla c1 = new Tesla(5268,"Honda Activa","1.Black,2.Blue,3.Red","Regular",90000,"100cc","1");
        Tesla c2 = new Tesla(3218,"Honda Activa 125","Pink,Black,Red","Disk",110000,"120cc","1");
        Tesla c3 = new Tesla(6548,"Honda Shine","Black,Blue,Red","Disk",84500,"125cc","1");
        Tesla c4 = new Tesla(3215,"Honda CBR 250","Black,Blue,Red","Disk",180000,"250cc","1");

        System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_"+c1.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                        System.out.print("\n========================\n");
                        this.Color = c1.Color;
                        this.Name = c1.Name;
                        this.ModelNO = c1.ModelNO;
                        this.Price = c1.Price;
                        this.VehicleNo = c1.VehicleNo;
                        this.Engine = c1.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTesla(); 
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }                                                  
                return;
                case 2:System.out.println("_"+c2.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                        System.out.print("\n========================\n");
                        this.Color = c2.Color;
                        this.Name = c2.Name;
                        this.ModelNO = c2.ModelNO;
                        this.Price = c2.Price;
                        this.VehicleNo = c2.VehicleNo;
                        this.Engine = c2.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTesla(); 
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }     
                return;
                case 3:System.out.println("_"+c3.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                        System.out.print("\n========================\n");
                        this.Color = c3.Color;
                        this.Name = c3.Name;
                        this.ModelNO = c3.ModelNO;
                        this.Price = c3.Price;
                        this.VehicleNo = c3.VehicleNo;
                        this.Engine = c3.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTesla(); 
                        }  
                        if(i==2)
                        {
                        selectAutomatic();
                        }   
                return;
                case 4:System.out.println("_"+c4.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                        System.out.print("\n========================\n");
                        this.Color = c4.Color;
                        this.Name = c4.Name;
                        this.ModelNO = c4.ModelNO;
                        this.Price = c4.Price;
                        this.VehicleNo = c4.VehicleNo;
                        this.Engine = c4.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTesla();
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }   
                return;
                case 0:System.out.println("_Returning Back to Brands");
                        selectAutomatic();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectTesla();
                return;
            }
        }
    }
}

interface IRollsRoyce
{
    void selectRollsRoyce();
}

class RollsRoyce extends Automatic implements IRollsRoyce
{
    RollsRoyce(){

    }
    RollsRoyce(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectRollsRoyce()
    {   
        System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
        RollsRoyce c1 = new RollsRoyce(5268,"Honda Activa","1.Black,2.Blue,3.Red","Regular",90000,"100cc","1");
        RollsRoyce c2 = new RollsRoyce(3218,"Honda Activa 125","Pink,Black,Red","Disk",110000,"120cc","1");
        RollsRoyce c3 = new RollsRoyce(6548,"Honda Shine","Black,Blue,Red","Disk",84500,"125cc","1");
        RollsRoyce c4 = new RollsRoyce(3215,"Honda CBR 250","Black,Blue,Red","Disk",180000,"250cc","1");

        System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_"+c1.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                        System.out.print("\n========================\n");
                        this.Color = c1.Color;
                        this.Name = c1.Name;
                        this.ModelNO = c1.ModelNO;
                        this.Price = c1.Price;
                        this.VehicleNo = c1.VehicleNo;
                        this.Engine = c1.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectRollsRoyce(); 
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }                                                  
                return;
                case 2:System.out.println("_"+c2.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                        System.out.print("\n========================\n");
                        this.Color = c2.Color;
                        this.Name = c2.Name;
                        this.ModelNO = c2.ModelNO;
                        this.Price = c2.Price;
                        this.VehicleNo = c2.VehicleNo;
                        this.Engine = c2.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectRollsRoyce(); 
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }     
                return;
                case 3:System.out.println("_"+c3.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                        System.out.print("\n========================\n");
                        this.Color = c3.Color;
                        this.Name = c3.Name;
                        this.ModelNO = c3.ModelNO;
                        this.Price = c3.Price;
                        this.VehicleNo = c3.VehicleNo;
                        this.Engine = c3.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectRollsRoyce(); 
                        }  
                        if(i==2)
                        {
                        selectAutomatic();
                        }   
                return;
                case 4:System.out.println("_"+c4.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                        System.out.print("\n========================\n");
                        this.Color = c4.Color;
                        this.Name = c4.Name;
                        this.ModelNO = c4.ModelNO;
                        this.Price = c4.Price;
                        this.VehicleNo = c4.VehicleNo;
                        this.Engine = c4.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectRollsRoyce(); 
                        }
                        if(i==2)
                        {
                        selectAutomatic();
                        }   
                return;
                case 0:System.out.println("_Returning Back to Brands");
                        selectAutomatic();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectRollsRoyce();
                return;
            }
        }
    }
}

interface IManual 
{
    void selectManual();
}

class Manual extends FourWheeler implements IManual
{
    Manual()
    {

    }
    Manual(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectManual() {
        System.out.print("Brands Available for Manual Four Wheelers are\n1.Suzuki\n2.Tata\n0.Exit From Manual Four Wheeler\n\nSelect your Choice : ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_Suzuki");
                        ISuzuki S1 = new Suzuki();
                        S1.selectSuzuki();
                return;

                case 2:System.out.println("_Tata");
                        ITata TA1 = new Tata();
                        TA1.selectTata();
                return;

                case 0:System.out.println("_Returning Back to Variants");
                        selectFourWheeler();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectManual();
                return;
            }
        }
    }
}

interface ISuzuki 
{
    void selectSuzuki();
}

class Suzuki extends Manual implements ISuzuki
{
    Suzuki(){

    }
    Suzuki(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectSuzuki()
    {   
        System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
        Suzuki c1 = new Suzuki(5268,"Honda Activa","1.Black,2.Blue,3.Red","Regular",90000,"100cc","1");
        Suzuki c2 = new Suzuki(3218,"Honda Activa 125","Pink,Black,Red","Disk",110000,"120cc","1");
        Suzuki c3 = new Suzuki(6548,"Honda Shine","Black,Blue,Red","Disk",84500,"125cc","1");
        Suzuki c4 = new Suzuki(3215,"Honda CBR 250","Black,Blue,Red","Disk",180000,"250cc","1");

        System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_"+c1.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                        System.out.print("\n========================\n");
                        this.Color = c1.Color;
                        this.Name = c1.Name;
                        this.ModelNO = c1.ModelNO;
                        this.Price = c1.Price;
                        this.VehicleNo = c1.VehicleNo;
                        this.Engine = c1.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectSuzuki(); 
                        }
                        if(i==2)
                        {
                        selectManual();
                        }                                                  
                return;
                case 2:System.out.println("_"+c2.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                        System.out.print("\n========================\n");
                        this.Color = c2.Color;
                        this.Name = c2.Name;
                        this.ModelNO = c2.ModelNO;
                        this.Price = c2.Price;
                        this.VehicleNo = c2.VehicleNo;
                        this.Engine = c2.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectSuzuki(); 
                        }
                        if(i==2)
                        {
                        selectManual();
                        }     
                return;
                case 3:System.out.println("_"+c3.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                        System.out.print("\n========================\n");
                        this.Color = c3.Color;
                        this.Name = c3.Name;
                        this.ModelNO = c3.ModelNO;
                        this.Price = c3.Price;
                        this.VehicleNo = c3.VehicleNo;
                        this.Engine = c3.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectSuzuki(); 
                        }  
                        if(i==2)
                        {
                        selectManual();
                        }   
                return;
                case 4:System.out.println("_"+c4.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                        System.out.print("\n========================\n");
                        this.Color = c4.Color;
                        this.Name = c4.Name;
                        this.ModelNO = c4.ModelNO;
                        this.Price = c4.Price;
                        this.VehicleNo = c4.VehicleNo;
                        this.Engine = c4.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectSuzuki();
                        }
                        if(i==2)
                        {
                        selectManual();
                        }   
                return;
                case 0:System.out.println("_Returning Back to Brands");
                        selectManual();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectSuzuki();
                return;
            }
        }
    }
}

interface ITata
{
    void selectTata();
}

class Tata extends Manual implements ITata
{
    Tata(){

    }
    Tata(int model,String name, String color, String brake, double price,String engine,String vehno)
    {
        super(model,name,color,brake,price,engine,vehno);
    }

    @Override
    public void selectTata()
    {   
        System.out.println("Showing Cycles\nYour Budget is Rs."+getBudget+"\n");
        Tata c1 = new Tata(5268,"Honda Activa","1.Black,2.Blue,3.Red","Regular",90000,"100cc","1");
        Tata c2 = new Tata(3218,"Honda Activa 125","Pink,Black,Red","Disk",110000,"120cc","1");
        Tata c3 = new Tata(6548,"Honda Shine","Black,Blue,Red","Disk",84500,"125cc","1");
        Tata c4 = new Tata(3215,"Honda CBR 250","Black,Blue,Red","Disk",180000,"250cc","1");

        System.out.print("\n1."+c1.Name+"\n2."+c2.Name+"\n3."+c3.Name+"\n4."+c4.Name+"\nSelect Cycle Name Choice: ");
        getInput = sc.nextInt();
        System.out.print("You Have Selected: "+getInput);
        while(true)
        {
            switch(getInput)
            {
                case 1:System.out.println("_"+c1.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c1.ModelNO+"\nCycle Name : "+c1.Name+"\nTypes of Colors : "+c1.Color+"\nPrice : Rs."+c1.Price);
                        System.out.print("\n========================\n");
                        this.Color = c1.Color;
                        this.Name = c1.Name;
                        this.ModelNO = c1.ModelNO;
                        this.Price = c1.Price;
                        this.VehicleNo = c1.VehicleNo;
                        this.Engine = c1.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTata(); 
                        }
                        if(i==2)
                        {
                        selectManual();
                        }                                                  
                return;
                case 2:System.out.println("_"+c2.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c2.ModelNO+"\nCycle Name : "+c2.Name+"\nTypes of Colors : "+c2.Color+"\nPrice : Rs."+c2.Price);
                        System.out.print("\n========================\n");
                        this.Color = c2.Color;
                        this.Name = c2.Name;
                        this.ModelNO = c2.ModelNO;
                        this.Price = c2.Price;
                        this.VehicleNo = c2.VehicleNo;
                        this.Engine = c2.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTata(); 
                        }
                        if(i==2)
                        {
                        selectManual();
                        }     
                return;
                case 3:System.out.println("_"+c3.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c3.ModelNO+"\nCycle Name : "+c3.Name+"\nTypes of Colors : "+c3.Color+"\nPrice : Rs."+c3.Price);
                        System.out.print("\n========================\n");
                        this.Color = c3.Color;
                        this.Name = c3.Name;
                        this.ModelNO = c3.ModelNO;
                        this.Price = c3.Price;
                        this.VehicleNo = c3.VehicleNo;
                        this.Engine = c3.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTata(); 
                        }  
                        if(i==2)
                        {
                        selectManual();
                        }   
                return;
                case 4:System.out.println("_"+c4.Name);
                        System.out.print("\n========================\n");
                        System.out.print("\nModel No. : "+c4.ModelNO+"\nCycle Name : "+c4.Name+"\nTypes of Colors : "+c4.Color+"\nPrice : Rs."+c4.Price);
                        System.out.print("\n========================\n");
                        this.Color = c4.Color;
                        this.Name = c4.Name;
                        this.ModelNO = c4.ModelNO;
                        this.Price = c4.Price;
                        this.VehicleNo = c4.VehicleNo;
                        this.Engine = c4.Engine;
                        checkBudget();
                        if(i==1)
                        { 
                        selectTata();
                        }
                        if(i==2)
                        {
                        selectManual();
                        }   
                return;
                case 0:System.out.println("_Returning Back to Brands");
                        selectManual();
                return;

                default:System.out.print("_Please Select Correct Choice");
                        selectTata();
                return;
            }
        }
    }
}
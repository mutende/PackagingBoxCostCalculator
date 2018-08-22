/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagingboxcostcalculator;

/**
 *
 * @author Elvis
 */
public class Cost extends DeclareMethods {
    
    double height;
    double width;
    double length;
    int Grade;
    int colorPrint;
    String seal;
    String corners,bottoms;
    int qnty;

    public Cost(double height, double width, double length, int Grade, int colorPrint, String seal, String corners, String bottoms, int qnty) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.Grade = Grade;
        this.colorPrint = colorPrint;
        this.seal = seal;
        this.corners = corners;
        this.bottoms = bottoms;
        this.qnty=qnty;
    }
            

    
    @Override
    public double area(double length, double width, double height) {
       double area=(length*width*2)+ (length*height*2)+(width*height*2);
        
     
       return area; 
        
    }

    @Override
    public double reinforceCost( String region) {
        //throw new UnsupportedOperationException("Not supported yet.");
      double  additionalcost=0;
        if(region.equals("Bottom")){
            
             additionalcost=0.1*(this.cost());
        }else
        if(region.equals("Corners")){
            
            additionalcost=0.07*(this.cost());
        }
        
        return additionalcost;
    }

    @Override
    public double colorPrintCost() {
       // throw new UnsupportedOperationException("Not supported yet.");
       
       double additionalCost=0;
       if(this.colorPrint==1){          
           additionalCost=0.12*(this.cost());        
       }else
           if(this.colorPrint== 2){         
                additionalCost=0.15*(this.cost());
           }
       
       return  additionalCost;
    }

    @Override
    public double sealableTopCost() {
        //throw new UnsupportedOperationException("Not supported yet.");
        
        double additionalCost=0;
        if(this.seal.equals("Yes"))
       return additionalCost=0.05*(this.cost());
        
        else
            return 0.0;
        
    }

    @Override
    public double cost() {      
        double cost=this.area( this.length,this.width,this.height)*this.Grade;      
       return cost;  
    }
    
    public double Tcost(){
        
        
        double totalCost=0;
        
       
        
        if(this.Grade == 1){
            totalCost=this.cost()+sealableTopCost();
            
        }else if(this.Grade==2){   
              totalCost=this.cost()+colorPrintCost();
              if(corners !=null)
                  totalCost+=reinforceCost(corners);
              
              totalCost+=sealableTopCost();
        }else if(this.Grade==3){
             totalCost+=colorPrintCost()+this.cost();
             if(corners !=null)
                 totalCost+=reinforceCost(corners);
             if(bottoms !=null)
                 totalCost+=reinforceCost(bottoms);
            
             totalCost+=sealableTopCost();
        }else if(this.Grade==4){
             totalCost+=colorPrintCost()+this.cost();
             if(corners !=null)
                 totalCost+=reinforceCost(corners);
             if(bottoms !=null)
                 totalCost+=reinforceCost(bottoms);
            
             totalCost+=sealableTopCost();
        }else if(this.Grade==5){
             totalCost+=colorPrintCost()+this.cost();
             if(corners !=null)
                 totalCost+=reinforceCost(corners);
             if(bottoms !=null)
                 totalCost+=reinforceCost(bottoms);
            
             totalCost+=sealableTopCost();
        }
      return totalCost;
    }
    
    public double tCostandQuantity(){
        
        
        double newTCost=0;
                
                    newTCost=Tcost()*this.qnty;
                    
        return newTCost;
    }
       
}

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
public abstract  class DeclareMethods {
    
    public abstract  double area( double length,double width,double height);
    
    public abstract double reinforceCost(String region);
    
    public abstract double colorPrintCost();
    
    public abstract double sealableTopCost();
    
    public abstract double cost();
    
}

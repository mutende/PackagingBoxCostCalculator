/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagingboxcostcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Elvis
 */
public class InputInterFaceFXMLController implements Initializable  {
    
    //ObservableList<Integer> cardGrade = FXCollection.ObservableList();

    @FXML
    private TextField length,width,height,cost,qnty,showText;
    @FXML
    private ComboBox cardGrade,colorPrint;
    
    @FXML
    private CheckBox reinforceC,reinforceB;
    @FXML
    private Button btn_calc,ship;
    @FXML
    private RadioButton sealableTopno,sealableTopyes;
    
    
    int cGrade,cPrint=0,quantity;
        String sealTop,Creinforced,Breinforced;
        double l,w,h;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ToggleGroup g = new ToggleGroup();
       
       sealableTopyes.setToggleGroup(g);
       sealableTopno.setToggleGroup(g);
        
        cardGrade.getItems().addAll(1,2,3,4,5);
        colorPrint.getItems().addAll(0,1,2);
        
        cardGrade.setOnAction(e->{
             if((int)cardGrade.getSelectionModel().getSelectedItem()==1){
                 reinforceC.setDisable(true);
                 reinforceB.setDisable(true);
                 colorPrint.setDisable(true);
                 
                 Creinforced=null;
                 Breinforced=null;
                 cPrint=0;
                                  
             }else{
                 
                 cPrint=0;
                 reinforceC.setDisable(false);
                 reinforceB.setDisable(false);
                 colorPrint.setDisable(false);
             }
        });
      
        
    }    
    
    
    
    @FXML
    public void calculateCost(){
            
        try{
          
       // cost.setOnAction(e->{
                cGrade=(int)cardGrade.getSelectionModel().getSelectedItem();
                cPrint=(int)colorPrint.getSelectionModel().getSelectedItem();
                if(sealableTopyes.isSelected()){
                    
                    sealTop="Yes";
                }else{
                    sealTop="No";
                }
                                
                   
                try{
                    l=Double.parseDouble(length.getText());
                    w=Double.parseDouble(width.getText());
                    h=Double.parseDouble(height.getText());
                    quantity=Integer.parseInt(qnty.getText());
                    
                }catch( NumberFormatException ee)
                {
                   // ee.printStackTrace();
                    
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed for width height and length");
                    cost.setText(" ");
                }
                
                if(reinforceC.isSelected())
                    Creinforced="Corners";
                else
                    Creinforced=null;
                
                if(reinforceB.isSelected())
                    Breinforced="Bottom";
                else
                    Breinforced=null;
                
                
                if(h==0 || w==0 || l==0 ){
                    
                    JOptionPane.showMessageDialog(null, "Box dimentions Cannot be Zero");
                }else
                    if(cardGrade.getSelectionModel().getSelectedItem()==null){
                        
                         JOptionPane.showMessageDialog(null, "Please Select A Card Grade");
                          cost.setText(" ");
                    }else
                        if(quantity==0){
                            
                            JOptionPane.showMessageDialog(null, "cannot import 0 quantity");
                             cost.setText(" ");
                        }
                    
                    
                else{
                
                            
                Cost  mycost=new Cost(h, w, l, cGrade, cPrint, sealTop, Creinforced, Breinforced,quantity);
                 
                cost.setStyle("-fx-text-fill: black; -fx-font: normal 19px 'serif';");
                 cost.setText(" Cost is ₤."+mycost.tCostandQuantity());
                 showText.setStyle("-fx-text-fill: blue; -fx-font: normal 14px 'serif';");
                 if(quantity>1){
                     showText.setText("Requested "+quantity+" boxes of L "+l+" W "+w+" H "+h+" Grade "+cGrade+" Color Print  "+cPrint+" Reinforce "+Breinforced+" and "+Creinforced+" Sealable Top "+sealTop);

                 }else
                 showText.setText("Requested "+quantity+" box of L "+l+" W "+w+" H "+h+" Grade "+cGrade+" Color Print  "+cPrint+" Reinforce "+Breinforced+" and "+Creinforced+" Sealable Top "+sealTop);
                 
                }
        }catch(Exception m){
            
            cost.setStyle("-fx-text-fill: red; -fx-font: normal 19px 'serif';");
            
            cost.setText("ERROR IN INPUT");
        }
    }
    @FXML
    public void shipMethod(){
        
        if(cost.getText().equals("")){
            
           
        
        showText.setStyle("-fx-text-fill: red; -fx-font: normal 30px 'serif';");
         showText.setText("Calculate Cost First");
         
        }else
        {
        showText.setStyle("-fx-text-fill: Green; -fx-font: normal 30px 'serif';");
        showText.setText("Your Packacge is ready");
        
        length.clear();
        height.clear();
        width.clear();
        cost.clear();
        qnty.clear();
        }
    }
    
    
    
}

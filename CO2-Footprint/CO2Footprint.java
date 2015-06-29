package CO2Footprints;
/**
 * @purpose: To estimate the pounds of CO2 a household will emit.
 *
 * @author: Julian D. Quitian
 * @version: November 16, 2013
 */
public class CO2Footprint
{
    //Declaration of private instance variables
    private int myNumPeople;
    private boolean myPaper, myPlastic, myGlass, myCans;
    private double myGasWaste, myAnnualGas,
                   myElectricWaste, myElectricBill, myElectricPrice,
                   myWasteProduced, myWasteRecycled, 
                   myBulbsReplaced, myBulbEmissionReduction,
                   myTotalWaste, myTotalReductions,
                   myCO2Footprint;
    
    /**
    * Constructor for objects of type CO2Footprint
    * @param annualGas total gallons used
    * @param electricBill average monthly bill for electricity
    * @param electricPrice average price per KWH
    * @param numPeople household size
    * @param paper declares whether paper will be recycled
    * @param plastic declares whether plastic will be recycled
    * @param glass declares whether glass will be recycled
    * @param cans declares whether cans will be recycled
    * @param bulbsReplaced number of light bulbs that ENERGY Star light bulbs will replace
    */
    CO2Footprint(double annualGas, double electricBill, double electricPrice, int numPeople, boolean paper,
                       boolean plastic, boolean glass, boolean cans, int bulbsReplaced)
    {
        myNumPeople = numPeople;myAnnualGas = annualGas; myElectricBill = electricBill; myElectricPrice = electricPrice;
        myPaper = paper; myPlastic = plastic; myGlass = glass; myCans = cans;
        myBulbsReplaced = bulbsReplaced;
    }
    
    /**
    * Mutator method to calculate the pounds of CO2 corresponding to gallons of gas used(no parameters)
    */
    public void calcGasPoundsCO2()
    {
        myGasWaste = myAnnualGas * 8.78 * Math.pow(10, -3) * 2204.6;
    }
    
    /**
    * Getter method to obtain the pounds of CO2 corresponding to gallons of gas used(no parameters)
    */
    public double getGasPoundsCO2()
    {
        return myGasWaste;
    }
    
    /**
    * Mutator method to calculate the pounds of CO2 emitted by electricity used(no parameters)
    */
    public void calcElectricityCO2 ()
    {
       myElectricWaste = (myElectricBill/ myElectricPrice) * 1.37 * 12 * myNumPeople;
    }
    
     /**
    * Getter method to obtain the pounds of CO2 emitted by electricity used(no parameters)
    */
    public double getElectricityCO2()
    {
        return myElectricWaste;
    }
    
    /**
    * Mutator method to estimate the pounds of CO2 the household will waste(no parameters)
    */
    public void calcGrossWasteEmission()
    {
        myWasteProduced = myNumPeople * 1018;
    }
    
    /**
    * Getter method to obtain the pounds of CO2 the household will waste(no parameters)
    */
    public double getGrossWasteEmission()
    {
        return myWasteProduced;
    }
    
    /**
    * Mutator method to calculate the emission reduction from recycling (no parameters)
    */
    public void calcWasteReduction()
    {
       if(myPaper)
       {
           myWasteRecycled += (184.0 * myNumPeople);
       }

       if(myPlastic)
       {
           myWasteRecycled += (25.6 * myNumPeople);
       }
   
       if(myGlass)
       {
           myWasteRecycled += (46.6 * myNumPeople);
       }

       if(myCans)
       {
           myWasteRecycled += (165.8 * myNumPeople);
       }
    }
    
    /**
    * Getter method to obtain the emission reduction from recycling (no parameters)
    */
    public double getWasteRecycled()
    {
        return myWasteRecycled;
    }
    
    /**
    * Mutator method to calculate the reduction produced by using ENERGY STAR light bulbs (no parameters)
    */
    public void calcBulbReduction()
    {
        myBulbEmissionReduction = myBulbsReplaced * 1.37 * 73;
    }
    
    /**
    * Getter method to obtain the reduction produced by using ENERGY STAR light bulbs (no parameters)
    */
    public double getBulbReduction()
    {
        return myBulbEmissionReduction;
    }
    
    /**
    * Mutator method to calculate the total waste produced by the household (no parameters)
    */
    public void calcTotalWaste()
    {
        myTotalWaste = myGasWaste + myElectricWaste + myWasteProduced;
    }
    
    /**
    * Getter method to obtain the total waste produced by the household (no parameters)
    */
    public double getTotalWaste()
    {
        return myTotalWaste;
    }
    
    /**
    * Mutator method to calculate the total waste reductions the household has produced(no parameters)
    */
    public void calcTotalReductions()
    {
        myTotalReductions = myWasteRecycled + myBulbEmissionReduction;
    }
    
    /**
    * Getter method to obtain the total waste reductions the household has produced(no parameters)
    */
    public double getTotalReductions()
    {
        return myTotalReductions;
    }
    
    /**
    * Mutator method to calculate the estimated pounds of CO2 produced by the household (no parameters)
    */
    public void calcCO2Footprint()
    {
        myCO2Footprint = myTotalWaste - myTotalReductions;
    }
    
    /**
    * Getter method to obtain the estimated pounds of CO2 produced by the household (no parameters)
    */
    public double getCO2Footprint()
    {
        return myCO2Footprint;
    }
}

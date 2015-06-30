package CO2Footprints;
/*
 * @purpose To estimate the total pounds of CO2 a household will waste in one year and print the results.
 */

/**
 * @date August 12, 2013
 * @author Julian David Quitian
 */
import java.util.ArrayList;
public class CO2FootprintTester
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            //Initialize new array list
            ArrayList<CO2Footprint> cO2 = new ArrayList<CO2Footprint>();
            
            //Initialize new objects through array list
            cO2.add(new CO2Footprint(1500, 209.70, 209.70/2464, 2, false, false, false, false, 0));
            cO2.add(new CO2Footprint(2450, 209.70, 209.70/2464, 5, true, true, true, true, 3));
            cO2.add(new CO2Footprint(4500, 209.70, 209.70/2464, 1, false, true, false, true, 5));
            cO2.add(new CO2Footprint(3002, 209.70, 209.70/2464, 3, true, false, true, false, 1));
            cO2.add(new CO2Footprint(5000, 208.50, 208.50/2464, 4, false, true, true, false, 4));
            
            //For-each loop to call methods in each object
            for( CO2Footprint dataRecord : cO2)
            {
                dataRecord.calcBulbReduction();
                dataRecord.calcCO2Footprint();
                dataRecord.calcElectricityCO2();
                dataRecord.calcGrossWasteEmission();
                dataRecord.calcGasPoundsCO2();
                dataRecord.calcTotalReductions();
                dataRecord.calcTotalWaste();
                dataRecord.calcWasteReduction();
                dataRecord.calcCO2Footprint();
            }
            
            //Initialize recording object
            CO2Footprint dataRecord;
            
            //Print chart strucure
            System.out.println("|                 Pounds of CO2                |           Pounds of CO2           |                   |");
            System.out.println("|                 Emmitted from                |           Reduced from            |                   |");
            System.out.println("|    Gas     |     Electricity     |   Waste   |    Recycling    |    New Bulbs    |   CO2 Footprint   |");
            System.out.println("|------------|---------------------|-----------|-----------------|-----------------|-------------------|");
            
            //Print results for each object through for loop
            for( int index = 0; index < cO2.size(); index++)
            {
                dataRecord = cO2.get(index);
                System.out.printf("|  %1.2f  |%14.1f       |%8.0f   |%11.1f      |%10.1f       |%14.2f     |\n", dataRecord.getGasPoundsCO2(), dataRecord.getElectricityCO2(), dataRecord.getGrossWasteEmission(), dataRecord.getWasteRecycled(), dataRecord.getBulbReduction(), dataRecord.getCO2Footprint());
            }
    }
}

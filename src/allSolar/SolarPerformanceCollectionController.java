package allSolar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SolarPerformanceCollectionController {
	
	private static SolarPerformanceCollectionController instance;
	private ArrayList<IndividualSolarPerformance> solarSystems = new ArrayList<IndividualSolarPerformance>(); //this is our array of solar systems
	

	private SolarPerformanceCollectionController() {
		//this class is a singleton - constructor is private
	}
	
	public static synchronized SolarPerformanceCollectionController getInstance(){
		if(instance == null){
			instance = new SolarPerformanceCollectionController();
		}
		return instance;
	}

	public synchronized void add(IndividualSolarPerformance isp) {
		solarSystems.add(isp);
	}
	
	public synchronized int count() {
		return solarSystems.size();
	}

	public synchronized IndividualSolarPerformance getMax() {
		IndividualSolarPerformance max = new IndividualSolarPerformance("placeholder",0.0);
		for(IndividualSolarPerformance isp: solarSystems){
			if(isp.getLifetimePerf() >= max.getLifetimePerf()){
				max = isp;
			}
		}
		return max;
		//there is a more time efficient way of doing this - but with only 40,000 records in your system, this should be fine
	}
	
	public synchronized IndividualSolarPerformance getMin() {
		IndividualSolarPerformance min = new IndividualSolarPerformance("placeholder",1.0);
		for(IndividualSolarPerformance isp: solarSystems){
			if(isp.getLifetimePerf() <= min.getLifetimePerf()){
				min = isp;
			}
		}
		return min;
		//there is a more time efficient way of doing this - but with only 40,000 records in your system, this should be fine
	}

	
	public synchronized ArrayList<IndividualSolarPerformance> getNthPercentile(double percentile){
		sortCollectionByPerf();
		ArrayList<IndividualSolarPerformance> toReturn = new ArrayList<IndividualSolarPerformance>();
		int length = count();
		int index = 0;
		double currentPercentile = 0.0;
		for(IndividualSolarPerformance isp: solarSystems){
			index++;
			currentPercentile = ((double)index)/((double)length);
			if(currentPercentile >= percentile){
				toReturn.add(isp);
			}
		}
		return toReturn;
	}
	
	
	public synchronized HashMap<String,Double> topSystems(double percentile){
		sortCollectionByPerf();
		HashMap<String,Double> toReturn = new HashMap<String,Double>();
		ArrayList<IndividualSolarPerformance> desired = getNthPercentile(percentile);
		for(IndividualSolarPerformance isp: desired){
			toReturn.put(isp.getSystemName(), isp.getLifetimePerf());
		}
		return toReturn;
	}
	
	private synchronized void sortCollectionByPerf(){
	Collections.sort(solarSystems, new Comparator<IndividualSolarPerformance>() {
        @Override
        public int compare(IndividualSolarPerformance  one, IndividualSolarPerformance  two){

              if(one.getLifetimePerf() < two.getLifetimePerf()){
            	  return -1;
              }
              else if(one.getLifetimePerf() > two.getLifetimePerf()){
            	  return 1;
              }
              else{
            	  return 0;
              }
        }
    	//ideally this method would be generic and functional and would take an argument to specify on which field to sort, best
		//way to do this would be to pass in a specific instance the comparator object.
    });
	}
	
	
}

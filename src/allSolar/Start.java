package allSolar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Start {

	public Start() {
		
		SolarPerformanceCollectionController controller =  SolarPerformanceCollectionController.getInstance();
		
		controller.add(new IndividualSolarPerformance("rome",.49));
		controller.add(new IndividualSolarPerformance("florence",.33));
		controller.add(new IndividualSolarPerformance("milan",.64));
		controller.add(new IndividualSolarPerformance("turin",.89));
		controller.add(new IndividualSolarPerformance("bologna",.46));
		controller.add(new IndividualSolarPerformance("genoa",.39));
		controller.add(new IndividualSolarPerformance("palermo",.68));
		controller.add(new IndividualSolarPerformance("naples",.65));
		controller.add(new IndividualSolarPerformance("bari",.77));
		controller.add(new IndividualSolarPerformance("catania",.21));
		controller.add(new IndividualSolarPerformance("parma",.82));
		controller.add(new IndividualSolarPerformance("perugia",.84));
		controller.add(new IndividualSolarPerformance("verona",.25));
		controller.add(new IndividualSolarPerformance("messina",.79));
		
		System.out.println("SYSTEM COUNT: " + controller.count());
		System.out.println("");
		System.out.println("MAX: " + controller.getMax());
		System.out.println("");
		System.out.println("MIN: " + controller.getMin());
		System.out.println("");
		
		System.out.println("80th percentile and higher systems:");
		for(IndividualSolarPerformance isp: controller.getNthPercentile(.80)){
		  System.out.println(isp);	
		}
		System.out.println("");
		System.out.println("20th percentile and higher systems:");
		for(IndividualSolarPerformance isp: controller.getNthPercentile(.20)){
		  System.out.println(isp);	
		}
		System.out.println("");
		System.out.println("Hashmap of 70th percentile and higher systems:");
		HashMap<String,Double> hashmap = controller.topSystems(.70);
		printMap(hashmap);
	}

	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public static void main(String[] args) {
		new Start();
	}

}

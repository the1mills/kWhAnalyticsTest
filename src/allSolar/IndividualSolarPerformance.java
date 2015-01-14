package allSolar;

public class IndividualSolarPerformance {
	
	private String systemName;
	private double lifetimePerf;
	
	public IndividualSolarPerformance(String systemName) {
		this.systemName = systemName;
	}
	
	public IndividualSolarPerformance(String systemName, double perf) {
		this.systemName = systemName;
		this.lifetimePerf = perf;
	}

	public String getSystemName() {
		return systemName;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public double getLifetimePerf() {
		return lifetimePerf;
	}


	public void setLifetimePerf(double lifetimePerf) {
		this.lifetimePerf = lifetimePerf;
	}
	
	public String toString(){
		return "System name: " + systemName + ", Performance: " + lifetimePerf;
	}
}

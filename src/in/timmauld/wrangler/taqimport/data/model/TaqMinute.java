package in.timmauld.wrangler.taqimport.data.model;

import java.util.Date;

public class TaqMinute {
	
	private Date time;
	private String ticker;
	private String name;
	private String high;
	private String low;
	private String avg;
	private String numShares;
	private String numTrades;	

	public TaqMinute(String ticker, String name) {
		this.ticker = ticker;
		this.name = name;
	}
	
	public Date getTime() {
		return time;
	}
	
	public long getTimeInMinutesSinceEpoch() {
		long minutesSinceEpoch = time.getTime() / (60 * 1000);
		return minutesSinceEpoch;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public void setTicker(String ticker) {		
		this.ticker = ticker;
	}		
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getNumShares() {
		return numShares;
	}

	public void setNumShares(String numShares) {
		this.numShares = numShares;
	}

	public String getNumTrades() {
		return numTrades;
	}

	public void setNumTrades(String numTrades) {
		this.numTrades = numTrades;
	}
}

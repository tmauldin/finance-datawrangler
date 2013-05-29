package in.timmauld.wrangler.taqimport.data.repo;

import in.timmauld.data.util.hbase.HBaseHelper;
import in.timmauld.wrangler.taqimport.data.model.TaqMinute;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class TaqMinuteRepository {

	final String TABLE_TAQ_MINUTE = "TAQ_Minute";
	
	final String FAMILY_COMPANY = "company";
	final String QUAL_TICKER = "ticker";
	final String QUAL_COMPANY_NAME = "name";
	
	final String FAMILY_PRICE = "price";
	final String QUAL_HIGH = "high";
	final String QUAL_AVG = "avg";
	final String QUAL_LOW = "low";
	
	final String FAMILY_VOLUME = "volume";	
	final String QUAL_NUM_SHARES = "numshares";
	final String QUAL_NUM_TRADES = "numtrades";
	
	private HBaseHelper hbaseHelper;
	
	public TaqMinuteRepository() throws IOException {
	  hbaseHelper = new HBaseHelper();
	}
	
	public void addTaqMinuteRow(TaqMinute taqMinute) throws IOException {
      HTable tbl = new HTable(hbaseHelper.getConfiguration(), TABLE_TAQ_MINUTE);
      
	  try {	  
	  
	  //TODO check for exists
	  
	  Put put = new Put(Bytes.toBytes(taqMinute.getTicker() + "_" + taqMinute.getTimeInMinutesSinceEpoch()));
      //TODO finish puts 
	  
	  tbl.put(put);
	  } finally {
	    tbl.close();
	  }
	}
}

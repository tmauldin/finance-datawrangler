package in.timmauld.grabber.googletrends.data.repo;

import in.timmauld.grabber.googletrends.data.model.Company;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class CompanyRepository {
	
	private Configuration config;
	
	public CompanyRepository() {
		config = HBaseConfiguration.create();			
	}
	
	public ArrayList<Company> getAllCompanies() throws IOException {
		ArrayList<Company> companies = new ArrayList<Company>();
		HTable table = new HTable(config, "TradeData");
		Scan s = new Scan();
		s.addFamily(Bytes.toBytes("Company"));
		ResultScanner scanner = table.getScanner(s);
		try {
			for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
				byte[] companyName = rr.getValue(Bytes.toBytes("Company"), Bytes.toBytes("CompanyName"));
				byte[] ticker = rr.getValue(Bytes.toBytes("Company"), Bytes.toBytes("Ticker"));
				companies.add(new Company(Bytes.toString(ticker), Bytes.toString(companyName)));
			}
		} finally {
			scanner.close();
			table.close();
		}
		return companies;		
	}
}

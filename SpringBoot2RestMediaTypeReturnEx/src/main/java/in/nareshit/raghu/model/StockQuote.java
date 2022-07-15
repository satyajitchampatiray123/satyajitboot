package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockQuote {

	private String code;
	private String vendor;
	
	private Product pob; //HAS-A
	
}

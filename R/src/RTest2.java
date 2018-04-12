import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RConnection rconn =null;
		try {
			rconn = new RConnection();
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println("OK");
		try {
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C://rproject//day09//r1.R',encoding='UTF-8')");
			
			double datas[]= rconn.eval("r2()").asDoubles();
			JSONArray big = new JSONArray();
			JSONObject jo = new JSONObject();
			jo.put("name", "datas");
			JSONArray small = new JSONArray();
			for(double d:datas) {
				small.add(d);
			}
			jo.put("datas", small);
			big.add(jo);
			System.out.println(big.toJSONString());
		} catch (Exception e) {
			System.out.println("R Connection Error");
		}
	}
}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest3 {

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
			RList list = rconn.eval("r3()").asList();
			System.out.println(list.size());
			String time[]=list.at("time").asStrings();
			double line2[]=list.at("line2").asDoubles();
			double line3[]=list.at("line3").asDoubles();
			double line4[]=list.at("line4").asDoubles();
			System.out.println(time.length);
			
			System.out.println("time line2 line3 line4");
			for (int i = 0; i < line4.length; i++) {
				System.out.print(time[i]+"   ");
				System.out.printf("%.0f  ",line2[i]);
				System.out.printf("%.0f  ",line3[i]);
				System.out.printf("%.0f  ",line4[i]);
				System.out.println();
			}
			
			JSONArray big = new JSONArray();
			JSONObject oj = new JSONObject();
			JSONArray small_t = new JSONArray();
			JSONArray small_l2 = new JSONArray();
			JSONArray small_l3 = new JSONArray();
			JSONArray small_l4 = new JSONArray();
			for(String a:time)
				small_t.add(a);
			for(double a:line2)
				small_l2.add(a);
			for(double a:line3)
				small_l3.add(a);
			for(double a:line4)
				small_l4.add(a);
			
			oj.put("time", small_t);
			oj.put("line2", small_l2);
			oj.put("line3", small_l3);
			oj.put("line4", small_l4);
			big.add(oj);
			System.out.println(big.toJSONString());
		} catch (Exception e) {
			System.out.println("R Connection Error");
		}
	}
}

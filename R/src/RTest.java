import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

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
			
			int a = 100;
			int b = 87;
			double data= rconn.eval("r1("+a+","+b+")").asDouble();
			//for(double d:datas) {
				System.out.println(data);
			//}
		} catch (Exception e) {
			System.out.println("R Connection Error");
		}
	}
}

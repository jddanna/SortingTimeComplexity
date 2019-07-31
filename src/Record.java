import java.util.Random;

/**
 * 
 * @author Joseph D'Anna
 *@version 7/23/19
 */
public class Record {

	private int key;
	private double value;
	
	
	public Record() {
		
		Random rand = new Random();
		key = rand.nextInt(100000);
		value = rand.nextDouble();
	}
	
	public Record(int k, double v) {
		key = k;
		value = v;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public int compareTo(Record rec) {
		return this.getKey() - rec.getKey();
	}
	
}

package ������;

public class InputDataCheckNanExample2 {
	public static void main(String[] args) {
		String userInput = "Nan";
		double val = Double.valueOf(userInput);
		
		double currentBalance = 10000.0;
		
		if(Double.isNaN(val)) {
			System.out.println("Nan�� �ԷµǾ� ó���� �� ����");
			val = 0.0;
		}
		currentBalance += val;
		System.out.println(currentBalance);
	}
}

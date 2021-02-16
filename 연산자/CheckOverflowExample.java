package ������;

public class CheckOverflowExample {
	public static void main(String[] args) {
		try {
			int result = safeAdd(2000000000, 2000000000);
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.out.println("�����÷ο찡 �߻��Ͽ� ��Ȯ�ϰ� ����� �� ����.");
		}
	}
	
	public static int safeAdd(int left, int right) {
		if ((right>0)) {
			if(left>(Integer.MAX_VALUE - right)) {
				throw new ArithmeticException("�����÷ο� �߻�1");
			}
		} else {
			if(left<(Integer.MAX_VALUE-right)) {
				throw new ArithmeticException("�����÷ο� �߻�2");
			}
		}
		return left+right;
	}
}

package first;

public class Mul implements Calculator{

	@Override
	public int cal(int firstNum, int secondNum) {
		int result = 0;
		result = firstNum * secondNum;
		return result;
	}

}
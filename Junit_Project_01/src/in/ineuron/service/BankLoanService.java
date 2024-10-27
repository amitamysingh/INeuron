package in.ineuron.service;

public class BankLoanService {

	public float calculateSimpleIntrest(int pAmt, int rate, int time) {
		return pAmt*rate*time/100.0f;
	}
}

package ineuron.services;

public class BankLoanService {

    public BankLoanService(){
        System.out.println("BankLoanService : ZERO PARAM CONSTRUCTOR");
    }
    public float calculateSimpleIntrest(float pAmt, float rate, float time){
        if(pAmt <= 0 || rate <= 0 || time <=0) {
            throw new IllegalArgumentException("Invalid input");
        }else{
            float intrest = (pAmt*rate*time)/100.0f;

            try {
                Thread.sleep(10000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }

            return intrest;


        }


    }
}

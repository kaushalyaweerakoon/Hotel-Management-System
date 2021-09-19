package arrays;

public class Person {

    private String customerFirstName;
    private String  customerSurName;
    private int creditCardNum;
    private int noOfGuests;

    public Person() {

    }


    public String getFirstName() {
        return customerFirstName;
    }

    public void setFirstName(String customerFirstName) {
        //  System.out.println("add name class method ");
        this.customerFirstName = customerFirstName;
    }

    public String getSurNamw(){
        return  customerSurName;
    }

    public void setSurName(String customerSurName){
        this.customerSurName=customerSurName;
    }

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum){
        this.creditCardNum =creditCardNum;
    }

    public int getTotalGuest() {
        return noOfGuests;
    }

    public void setTotalGuest(int noOfGuests){
        this.noOfGuests =noOfGuests;
    }

}

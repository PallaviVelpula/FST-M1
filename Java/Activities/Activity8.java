package activities;

public class Activity8 {
    public void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        try {
            Activity8 newAct = new Activity8();
            newAct.exceptionTest("Print the string");
            newAct.exceptionTest(null);
        } catch (CustomException custExp) {
            System.out.println("Exception occured: " + custExp.getMessage());
        }

    }
}

package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr1 = {10, 77, 10, 54, -11, 10};
        int temp=0;
        for( int value: arr1){
            if(value==10)
                temp++;
        }
        System.out.println("Number of 10's in the array is "+temp);
        if((temp*10)==30)
            System.out.println("Value is equal to 30");
        else
            System.out.println("Value is not equal to 30");
    }
}

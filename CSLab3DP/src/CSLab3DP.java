
public class CSLab3DP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.print(reverse(00303));
		
	}
	
	public static void letters(String letter){
		
		char firstChar = letter.charAt(0);
		int nextInt = firstChar - 1;
		char nextChar = (char) nextInt;
		
		
		
	if(firstChar != 'a'){
		letter = Character.toString(nextChar) + letter;
		letters(letter);
	}else{
		System.out.print(letter);
	}
	}
	
	public static int twos(int num){
		if(num % 2 == 1){
			return 0;
		}else{
			return 1 + twos(num / 2);
		}
	}
	
	public static boolean powerOf3(int num){
		if(num == 3){
			return true;
		}else if(num < 3){
			return false;
		}else if(num % 3 != 0){
			return false;
		}else{
			return powerOf3(num/3);
		}
	}
	
	public static void base5(int num) {
        if ((num / 5) < 1)
           System.out.print(num);
        else {
            base5(num/5);
            System.out.print(num % 5);
        }
    }
	
	public static int reverse(int num){
		if(num > 0){
		if(num < 10){
			return num;
		}else{
			return ((num % 10) * power(num)) + reverse(num / 10);
			
		}
		}else{
			if(num < -10){
				return num;
			}else{
				return -1*((num % 10) * power(num)) + reverse(num / 10);
				
			}
			
		}
		
	}
	
	public static int power(int num) {
		int count = 0;
		int ret = 1;
       for(int i = num; i > 10; i /= 10){
    	   count++;
       }
       for(int n = 0; n < count; n++){
    	   ret *= 10;
       }
       
       return ret;
}
	
	public static void printWithCommas(int num) {
        if (num < 1000)
            System.out.print(num);
        else if(num % 1000 < 100){
        	printWithCommas(num / 1000);
            System.out.print("," + 0 + num % 1000);
        }else if(num % 1000 < 10){
        	printWithCommas(num / 1000);
            System.out.print("," + 00 + num % 1000);
        }else if(num % 1000 == 0){
        	printWithCommas(num / 1000);
            System.out.print("," + 000 + num % 1000);
        }else{
        	printWithCommas(num / 1000);
            System.out.print("," + num % 1000);
        }
    }

}

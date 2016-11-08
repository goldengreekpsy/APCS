import java.util.Scanner;


public class CSLab5DP {
	static Scanner cin = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		int size = 0; // TEst git 2
		System.out.print("array size: ");
		size = cin.nextInt();
		int array[] = new int[size];
		System.out.print("enter elements of array: ");
		
		for(int n = 0; n < size; n++){
			array[n] = cin.nextInt();
		}
		
		System.out.print("\n");
		int choice = 0;
		int num = 0;
		do{
			System.out.println("1. display\n2. search\n3. min swap\n4. rotate\n5. zero\n6. quit");
			choice = cin.nextInt();
			
			switch(choice){
			case 1: display(array);
			break;
			case 2:find(array);
			break;
			case 3:minSwitch(array);
			break;
			case 4: rotate(array);
			break;
			case 5: array = zero(array);
					display(array);
			break;
			}
			
		}while(choice!=6);
		

	}
	
	
	public static void display(int[] array){
		System.out.println("size of array: " + array.length);
		System.out.print("array positions: ");
		
        for(int n = 0; n < array.length; n++){
         //   System.out.printf("%5s", n);
        	
        	System.out.print( n+ "    ");
        }
        System.out.print("\n");
        
        System.out.print("array entries:   ");
        for(int i = 0; i < array.length; i++){
        	//System.out.printf("%5s", array[i]);
        	System.out.print(array[i] + "    ");
        }
        
        System.out.print("\n");
	} 
	
	public static void rotate(int[] array){
		int temp = 0;
		int r =0;
		System.out.print("how far do you want to rotate? ");
		r = cin.nextInt();
		
		if(r > 0){
		for(int n = 0; n < r; n++){
			//System.out.println("2gottem");
			temp = array[array.length-1];
			for(int m = array.length-1; m > 0; m--){
				//System.out.println("gottem");
				array[m] = array[m-1];
			}
			array[0] = temp;
				
			}
		
		}else{
			for(int n = 0; n > r; n--){
				temp = array[0];
				for(int m = 0; m < array.length-1; m++){
					array[m] = array[m+1];
				}
				array[array.length-1] = temp;
				
				
				
				
				
			}
			}
		
		
		display(array);
		
	}
	
	public static void find(int[] array){
		int num = 0;
		boolean is = false;
		String choice = "n";
		
		do{
			is = false;
		System.out.print("what entry: ");
		num = cin.nextInt();
		System.out.print("status: ");
		for(int m = 0; m < array.length; m++){
			if(array[m] == num){
				System.out.print("found at " + m + ", ");
				is = true;
			}
			
		}
		if(!is){
			System.out.print("not found ");
		}
		
		System.out.print("\nanother one? (yes/no): ");
		choice = cin.next();
		
		}while(!choice.equals("no"));
		
	}

	
	public static void minSwitch(int[] array){
		int min = 0;
		min = 0;
		for(int m = 0; m < array.length; m++){
			if(array[m] < array[min]){
				min = m;
			}
		}
		
		int temp = 0;
		temp = array[0];
		array[0] = array[min];
		array[min] = temp;
		display(array);
	}
	
	public static int[] zero(int[] array){
		
		int zero = 0;
		
		for(int m = 0; m < array.length; m++){
			if(array[m]==0){
			
				zero++;
			}
		}
		
		int ret[] = new int[array.length-zero];
		int done = 0;
		for(int m = 0; m < array.length; m++){
			if(array[m]!=0){
				
			ret[done] = array[m];
			done++;
			}
		}
		
		
		return ret;
	}
	
}

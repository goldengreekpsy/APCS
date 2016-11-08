import java.util.Random;
import java.util.Scanner;


public class Muskrat {

	static Scanner cin = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		
		
		char[][] box = makeArray();
		//box[3][4] = 'd';
		printArray(box);
		int x = 0;
		int y = 0;
		int m = 0;
		
		int incorrect = 0;
		int correct = 0;
		int shot = 0;
		
		do{
		m = menu();
		switch(m){
		case 1:
		fire(box);
		shot++;
		break;
		case 2:
			 System.out.println("enter a guess ");
			   
			   y = cin.nextInt();
			   x = cin.nextInt();
			   
			   if((box[convert(x)][convert(y)] == 'b') || (box[convert(x)][convert(y)] == 'c')){
				   System.out.println("wow, you got one right. ");
				   correct++;
				   if(box[convert(x)][convert(y)] == 'b'){
					   box[convert(x)][convert(y)] = 'd';
						   
				   }else{
					   box[convert(x)][convert(y)] = 'e';{
						   
				   }
				   
				  
				   
				   }
				   
				   printArray(box);
				   
			   }else if((box[convert(x)][convert(y)] == 'd') || (box[convert(x)][convert(y)] == 'e')){
				   System.out.println("you already guessed that one, you silly goose. ");
				  
			   }else{
				   System.out.println("you missed. ");
				   incorrect++;
			   }
			   break;
		case 3: cheatArray(box);
		}
		
		System.out.println(shot + " shots, " + correct + " correct guesses, " + incorrect + " incorrect guesses.");
		
		}while((m != 0)&&(correct!=10));
		
		
		System.out.println("live long and prosper ");
	
		
	}

	//-------------------------------------------	
	 public static char[][] makeArray() {
	        char box[][] = new char[12][12];

	        for (int i = 0; i < 12; i++) {
	            for (int m = 0; m < 12; m++) {
	                box[m][i] = 'a';
	            }
	        }
	        
	        
	        
	            mirror(box);
	        
	        
	        return box;
	    }
	 
	 public static char[][] mirror(char[][] box) {
			
		 Random rand = new Random();
		 
		 int n = 0;
		 int x = 0;
		 int y = 0;
		 int c = 0;
		 
		 do{
			 x = rand.nextInt(10)+1;
			 y = rand.nextInt(10)+1;
			 c = rand.nextInt(2);
			 
			 if(box[x][y] == 'a'){
				 
				 if(c == 1){
				 box[x][y] = 'b';
				 }else{
					 box[x][y] = 'c';
				 }
				 
				 
				 n++;
			 }
			 
			
			 
		 }while(n < 10);
		 
		 return box;
	 }
	 
	 
	 public static void printArray(char[][] box) {


         System.out.print("   ");
         for (int i = 20; i < 30; i++)
             System.out.print(i);
         System.out.print("\n");



         for (int i = 1; i < 11; i++) {
             System.out.print(20 - i + " ");
             for (int j = 1; j < 11; j++) {
                 switch(box[i][j]){
                     case('a'):
                         System.out.print('.' + " ");
                         break;
                     case('b'):
                         System.out.print('.' + " ");
                         break;
                     case('c'):
                         System.out.print('.' + " ");
                         break;
                     case('d'):
                         System.out.print('/' + " ");
                         break;
                     case('e'):
                         System.out.print('\\' + " ");
                         break;
                     
                 }
             }
             System.out.print(29 + i + " ");
             System.out.print("\n");
         }

         System.out.print("   ");
         for (int i = 0; i < 10; i++)
             System.out.print(i + " ");
         System.out.print("\n");
     }
	 
	 public static int menu() {
	        System.out.println("(1) Shoot a laser" + "\n" +
	                          "(2) Guess at a mirror location" + "\n" +
	                          "(0) Quit the game" + "\n");
	        System.out.println("Enter choice: ");
	        return cin.nextInt();
	    }
	 
	 
	 //-------------------------------------------------------------
	 public static int shoot(int x, int y, int direction, char[][] array){
			if((x == 12)||(x == 0)||(y == 12)||(y == 0)){
				
				
					
					
				if(x == 0){
					return (y+19);
				}else if(y == 0){
					return (20 - x);
				}else if(y == 12){
					return (29 + x);
				}else if(x == 12){
					return (y- 1);
				}
				
			//	System.out.println("whatduh");
				
			}else{
				
				//System.out.println(x+ " " + y + " " + direction);
				
				if (array[x][y] == 'a'){
					switch(direction){
					case 1: return shoot(x+1, y, direction, array);
							
					case 2: return shoot(x, y+1, direction, array);
							
					case 3: return shoot(x-1, y, direction, array);
						
					case 4: return shoot(x, y-1, direction, array);
							
					}}else if((array[x][y] == 'b') || (array[x][y] == 'd')){
						switch(direction){
						case 1: return shoot(x, y-1, 4, array);
								
						case 2: return shoot(x-1, y, 3, array);
							
						case 3: return shoot(x, y+1, 2, array);
								
						case 4: return shoot(x+1, y, 1, array);
							
						
						}
						}else if((array[x][y] == 'c') || (array[x][y] == 'e')){
						switch(direction){
						case 1: return shoot(x, y+1, 2, array);
								
						case 2: return shoot(x+1, y, 1, array);
								
						case 3: return shoot(x, y-1, 4, array);
							
						case 4: return shoot(x-1, y, 3, array);
								
						
					
				}
			}else{
				System.out.println("Error;");
				return 0;
			}
			}
			System.out.println("Error 0;");
			return 0;
	}
	 
	//----------------------------------------------------------------------------
	   
	   public static void fire(char[][] box){
		   System.out.println("enter a laser to fire ");
		   int num = 0;
		   num = cin.nextInt();
		   
		   if((num >= 10) && (num <= 19)){
			 
				 System.out.println("laser hit " + shoot((20-num), 1 , 2 , box ));
			 
		   }else if((num >= 0) && (num <= 9)){
			  
					 System.out.println("laser hit " + shoot(10, num+1, 3 , box ));
				
		   }else if((num >= 30) && (num <=39) ){
		
					 System.out.println("laser hit " + shoot(((num-29)), 10, 4 , box ));
				
			   
		   }else if((num >= 20) && (num <=29) ){
		
					 System.out.println("laser hit " + shoot(1, (num - 20 + 1), 1 , box ));
				 
			   
		   }
		   
		   
	
	   }
	   
	   public static int convert(int num){
		  
		   if((num >= 10) && (num <= 19)){
				 
				 num = (20-num);
				 //System.out.print("test" + num);
			 
		   }else if((num >= 0) && (num <= 9)){
			  
					 num = num+1;
				
		   }else if((num >= 30) && (num <=39) ){
		
					num = num -29;
				
			   
		   }else if((num >= 20) && (num <=29) ){
		
					 num = num - 19;
				 
			   
		   }
		   
		   
		   return num;
	   }
	
	   public static void cheatArray(char[][] box) {


	         System.out.print("   ");
	         for (int i = 20; i < 30; i++)
	             System.out.print(i);
	         System.out.print("\n");



	         for (int i = 1; i < 11; i++) {
	             System.out.print(20 - i + " ");
	             for (int j = 1; j < 11; j++) {
	                 switch(box[i][j]){
	                     case('a'):
	                         System.out.print('.' + " ");
	                         break;
	                     case('b'):
	                         System.out.print('/' + " ");
	                         break;
	                     case('c'):
	                         System.out.print('\\' + " ");
	                         break;
	                     case('d'):
	                         System.out.print('/' + " ");
	                         break;
	                     case('e'):
	                         System.out.print('\\' + " ");
	                         break;
	                     
	                 }
	             }
	             System.out.print(29 + i + " ");
	             System.out.print("\n");
	         }

	         System.out.print("   ");
	         for (int i = 0; i < 10; i++)
	             System.out.print(i + " ");
	         System.out.print("\n");
	     }
	   
}

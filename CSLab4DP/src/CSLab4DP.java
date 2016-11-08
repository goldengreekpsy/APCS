import java.util.Scanner;
import java.util.Random;


public class CSLab4DP {
	static Scanner cin = new Scanner(System.in);

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
			   
			   x = cin.nextInt();
			   y = cin.nextInt();
			   
			   if((box[x][y] == 'b') || (box[x][y] == 'c')){
				   System.out.println("wow, you got one right. ");
				   correct++;
				   if(box[x][y] == 'b'){
					   box[x][y] = 'd';
						   
				   }else{
					   box[x][y] = 'e';{
						   
				   }
				   
				  
				   
				   }
				   
				   printArray(box);
				   
			   }else if((box[x][y] == 'd') || (box[x][y] == 'e')){
				   System.out.println("you already guessed that one, you silly goose. ");
				  
			   }else{
				   System.out.println("you missed. ");
				   incorrect++;
			   }
			   break;
		case 3: System.out.println("live long and prosper ");
		}
		
		System.out.println(shot + " shots, " + correct + " correct guesses, " + incorrect + " incorrect guesses.");
		
		}while(m != 3);
		
		
		}

	
	
	
	//-----------------------------------------------------------------------
	public static int shoot(int x, int y, int direction, char[][] array){
		if((((x == 12)&& (direction == 1) )|| ((x == 0) && (direction == 3) ) || ((y == 12) && (direction == 2)) || ((y == 0) && (direction == 4)) )){
			
			
				
				
			if((x == 0) && (direction == 3)){
				return (y+20);
			}else if((y == 0) && (direction == 4)){
				return (19 - x);
			}else if((y == 12) && (direction == 2)){
				return (30 + x);
			}else if((x == 12) && (direction == 1)){
				return (y);
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
	
	//-------------------------------------------------------------------------
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
	 
	 //-------------------------------------------------------------------------
	 
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
	 
	 //-----------------------------------------------------------------------------
	 
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
		             System.out.print(30 + i + " ");
		             System.out.print("\n");
		         }

		         System.out.print("   ");
		         for (int i = 0; i < 10; i++)
		             System.out.print(i + " ");
		         System.out.print("\n");
		     }
	 //-------------------------------------------------------------------
	   
	   public static int menu() {
	        System.out.println("(1) Shoot a laser" + "\n" +
	                          "(2) fire at a mirror location" + "\n" +
	                          "(0) Quit the game" + "\n");
	        System.out.println("Enter choice: ");
	        return cin.nextInt();
	    }
	   
	   //----------------------------------------------------------------------------
	   
	   public static void fire(char[][] box){
		   System.out.println("enter a laser to fire ");
		   int num = 0;
		   num = cin.nextInt();
		   
		   if((num >= 10) && (num <= 19)){
			 if(shoot(((num-20)*-1), 0, 2 , box ) != -1){
				 System.out.println("laser hit " + shoot(((num-19)*-1), 0 , 2 , box ));
			 }
		   }else if((num >= 0) && (num <= 9)){
			   if(shoot(0, num, 3 , box ) != -1){
					 System.out.println("laser hit " + shoot(0, num, 3 , box ));
				 }
		   }else if((num >= 30) && (num <=39) ){
			   if(shoot(((num-30)), 12, 4 , box ) != -1){
					 System.out.println("laser hit " + shoot(((num-30)), 12, 4 , box ));
				 }
			   
		   }else if((num >= 20) && (num <=29) ){
			   if(shoot(0, ((num-20)*-1), 1 , box ) != -1){
					 System.out.println("laser hit " + shoot(0, ((num-20)*-1), 1 , box ));
				 }
			   
		   }
		   
		   
	
	   }
	 
	   public static char[][] guess(char[][] box){
		   int x = 0;
		   int y = 0;
		   System.out.println("enter a guess ");
		   
		   x = cin.nextInt();
		   y = cin.nextInt();
		   
		   if((box[x][y] == 'b') || (box[x][y] == 'd')){
			   System.out.println("wow, you got one right. ");
			   if(box[x][y] == 'b'){
				   box[x][y] = 'd';
					   
			   }else{
				   box[x][y] = 'e';{
					   
			   }
			   
			   printArray(box);
			   
			   }
		   }else if((box[x][y] == 'd') || (box[x][y] == 'e')){
			   System.out.println("you already guessed that one, you silly goose. ");
			  
		   }else{
			   System.out.println("you missed. ");
		   }
		   
		   
		   return box;
	   }
	 
	
}
	   
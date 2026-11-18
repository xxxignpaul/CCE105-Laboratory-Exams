import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class LabExam {
	
	static Scanner input = new Scanner(System.in);
	static Queue<String> queue = new LinkedList<>();
	
	public static void main(String[]args) {
		
		int choice;
		do {
			System.out.println("-----PERMUTATION AND QUEUE----");
			System.out.println("1.) Enter Elements");
			System.out.println("2.) Display Elements");
			System.out.println("3.) Generate Permutations");
			System.out.println("4.) Exit the Program");
			System.out.println("------------------------------");
			System.out.print("Enter your course of action: ");
			choice = input.nextInt();
			
			switch(choice) {
			
			case 1:
				Add_Elements();
				break;
			case 2:
				Display_Elements();
				break;
			case 3:
				Generate_Permutations();
				break;
			case 4:
				System.out.println("Program Terminated");
				break;
				
			default:
				System.out.println("Invalid Choice!");
				
			}
		}while(choice !=4);
	}

	static void Add_Elements() {
		System.out.print("Enter how many elements to add: ");
		int n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Element " + (i +  1) + ": ");
			String element = input.next();
			queue.add(element);
		}
		
		System.out.println("Queue: " + queue);
		System.out.println("Dequeueing the 2 Elements");
		int remove_Count = 2;

		for (int i = 0; i < remove_Count; i++) {
			if (!queue.isEmpty()) {
				queue.poll();
				
			}
		}
		System.out.println("Queue: " + queue);
	}
	
	static void Display_Elements() {
		
		if (queue.isEmpty()) {
		System.out.println("The Queue is Empty");
		}else{
		System.out.println("Queue: " + queue);
		}
	}
	
	static void Generate_Permutations() {
		if (queue.isEmpty()) {
			System.out.println("The Queue is Empty");
			return;
		}
		System.out.println("Queue: " + queue);
		System.out.println("Enter the Number of Elements to Arrange: ");
		int r = input.nextInt();
		if (r <= 0 || r > queue.size()) {
			System.out.print("Invalid Number of Elements");
			return;
		}
		
		int n = queue.size();
		String[] elements = new String[n];
		for (int i = 0; i < n; i++) {
		elements[i] = queue.peek();
		queue.add(queue.poll());
	}
	
	Queue<String> permQueue = new LinkedList<>();
	
	for (int i = 0; i < n; i++) {
		permQueue.add(elements[i]);
	}
		for (int step = 1; step < r; step++) {
			int levelSize = permQueue.size();
			for (int i = 0; i < levelSize; i++) {
				String current = permQueue.poll();
				for (int j = 0; j < n; j++) {
					if (!current.contains(elements[j])) {
						permQueue.add(current + elements[j]);
				}
			}
		}
	}
	
	int totalPermutations = 0;
	while (!permQueue.isEmpty()) {
		System.out.println(permQueue.peek());
		permQueue.poll();
		totalPermutations++;
	}
	System.out.print("Total Permutations: " + totalPermutations + "\n" );
	}
}

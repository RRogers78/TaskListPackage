package TaskListPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainArea {
	static Scanner userInput;
	static ArrayList<TaskProperties> tasks;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//task manager
			//display menu
		tasks = new ArrayList<TaskProperties>();
		userInput = new Scanner(System.in);
		
		
		boolean running = true;
		
		do {
			displayMenu();
			int menuChoice = readUserInput();
			
			switch(menuChoice) {
				case 1:
					System.out.println("What do you want to add: ");
					//add task method
					String taskName = userInput.nextLine();
					addTask(taskName);
					break;
				case 2:
					System.out.print("Task to be removed: ");
					listTasks();
					int removeId = readUserInput();
					removeTask(removeId);
					//remove method
					break;
				case 3:
					System.out.print("Item to complete: ");
					listTasks();
					int completeId = readUserInput();
					completeTask(completeId);
					break;
				case 4:
					//list method
					listTasks();
					break;
				case 0:
					break;
				default:
					System.out.println("UNKNOWN");
			}
		}
		while(running);
		
 
	}
	
	public static void displayMenu() {
		System.out.println("==Task Master--");
		System.out.println("1. Add to the list");
		System.out.println("2. Remove from the list");
		System.out.println("3. Complete that item");
		System.out.println("4. List the list");
		System.out.println("0. End of line---");
		System.out.println("Your choice:");

	}
	
	public static int readUserInput() {
		int result = userInput.nextInt();
		
		userInput.nextLine();
		return result;
	}
	
	//add task
	public static void addTask(String name) {
		tasks.add(new TaskProperties(name));
		
	}
	
	//remove task
	
	public static void removeTask(int id) {
		tasks.remove(id - 1);
	}
	
	//complete
	public static void completeTask(int id) {
		tasks.get(id - 1).setComplete(true);
	}
	
	//list tasks
	public static void listTasks() {
		System.out.println("--toDo list--");
		for(int i = 0; i < tasks.size(); i++) {
			System.out.println(i+1 + ". " + tasks.get(i).toString());
		}
		System.out.println("===========================\n");
	}

}

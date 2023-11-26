import java.util.Scanner;
import java.util.ArrayList;
public class TodoList{
    static ArrayList<String> tasks = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        
        int choice;

        while(true){
            System.out.println("**********To-Do List Menu**********");
            System.out.println("1. Add a Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. Display the list of Tasks");
            System.out.println("4. Mark a Task as Complete");
            System.out.println("0. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    markTaskAsComplete();
                    break;
                case 0:
                    System.out.println("Exiting To-Do List.....!"+"\n"+"Thank You...!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice...");
                    break;
            }
        }   
    }

    public static void addTask(){
        System.out.println("Please Enter the Task to Add:");
        scanner.nextLine();
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Your Task has been Added Successfully...!");
    }

    public static void deleteTask(){
        displayTasks();
        if(!tasks.isEmpty()){
            System.out.println("Please enter the Index of the Task you want to Delete: ");
            int index = scanner.nextInt() - 1;
            if(index >= 0 && index < tasks.size()){
                String deletedTask = tasks.remove(index);
                System.out.println("The Task "+deletedTask +" has been Deleted Successfully...!");
            }
            else{
                System.out.println("Invalid index. Please Enter a Valid index...!");
            }
        }
    }

    public static void displayTasks(){
        if(!tasks.isEmpty()){
            for(int i = 0;i < tasks.size();i++){
                System.out.println((i+1)+". "+tasks.get(i));
            }
        }
        else{
            System.out.println("No Tasks Found in the list..!");
        }
    }

    public static void markTaskAsComplete(){
        displayTasks();
        if(!tasks.isEmpty()){
            System.out.println("Please Enter the index of the Task to Mark as complete...!");
            int index = scanner.nextInt() - 1;
            if(index >= 0 && index < tasks.size()){
                String markedTask = tasks.get(index);
                System.out.println("The Task "+markedTask+" is Marked as Complete...!");
                tasks.set(index, markedTask+" (Task Complete)");
                System.out.println("Would you like to remove the Completed Task from the List? (yes/no)");
                scanner.nextLine();
                String decision = scanner.nextLine().toLowerCase();
                if(decision.equals("yes")){
                    tasks.remove(index);
                }
            }
        }
        
    }
}
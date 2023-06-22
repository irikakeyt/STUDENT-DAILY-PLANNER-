import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class StudentPlanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = scanner.nextLine();

        System.out.print("Enter today's date (mm/dd/yyyy): ");

        String date = scanner.nextLine();

        Queue<String> tasks = new LinkedList<String>();

        // Get the number of initial tasks for the day

        System.out.print("How many tasks do you have for today? ");

        int numTasks = scanner.nextInt();

        scanner.nextLine();

        // Get the details of each initial task

        for (int i = 0; i < numTasks; i++) {

            System.out.print("Enter task #" + (i + 1) + ": ");

            tasks.add(scanner.nextLine());

        }

        Queue<String> completedTasks = new LinkedList<String>();

        // Display menu options

        boolean quit = false;

        while (!quit) {

            System.out.println("\nMenu:");

            System.out.println("1. List tasks");

            System.out.println("2. Mark task as completed");

            System.out.println("3. Add task");

            System.out.println("4. Quit");

            // Get user's choice

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            // Perform the chosen action

            switch (choice) {

                case 1:

                    System.out.println("\nTask list for " + name + " (" + date + "):");

                    int taskIndex = 1;

                    for (String task : tasks) {

                        System.out.println(taskIndex + ". " + task);

                        taskIndex++;

                    }

                    System.out.println("\nCompleted tasks for " + name + " (" + date + "):");

                    int completedTaskIndex = 1;

                    for (String completedTask : completedTasks) {

                        System.out.println(completedTaskIndex + ". " + completedTask);

                        completedTaskIndex++;

                    }

                    break;           

                case 2:

                    System.out.print("Enter the task number to mark as completed: ");

                    int taskCompleted = scanner.nextInt();

                    scanner.nextLine();

                    if (taskCompleted > 0 && taskCompleted <= tasks.size()) {

                        String[] taskArray = tasks.toArray(new String[0]);

                        String completedTask = taskArray[taskCompleted - 1];

                        tasks.remove(completedTask);

                        completedTasks.add(completedTask);

                        System.out.println("Task \"" + completedTask + "\" marked as completed.");

                    } else {

                        System.out.println("Invalid task number. Please try again.");

                    }

                    break;

                case 3:

                    System.out.print("Enter the task to add: ");

                    String newTask = scanner.nextLine();

                    tasks.add(newTask);

                    System.out.println("Task added.");

                    break;

                case 4:

                    quit = true;

                    break;

                default:

                    System.out.println("\nInvalid choice. Please try again.");

                    break;

            }

        }

    }

}

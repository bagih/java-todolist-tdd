package com.bagih.todolist.view;

import com.bagih.todolist.service.TodoService;

import java.util.Scanner;

public class TodoView {
    Scanner scanner = new Scanner(System.in);
    private TodoService todoService;

    public TodoView(TodoService todoService) {
        this.todoService = todoService;
    }

    void bannerMenu(){
        System.out.println("\n==============PILIH MENU BERIKUT==================");
        System.out.println("1. masukkan todo");
        System.out.println("2. hapus todo");
        System.out.println("3. tampilkan semua todolist");
        System.out.println("4. tampilkan todolist dengan nomor index tertentu");
        System.out.println("5. Keluar");
        System.out.println("===================================================\n");
    }

    public void mainMenu(){
        bannerMenu();
        System.out.print("pilihan: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.print("masukkan todo: ");
                String todo = scanner.next();
                todoService.addTodo(todo);
                break;
            case 2:
                System.out.print("masukkan index todo yang ingin dihapus: ");
                int indexTodo = scanner.nextInt();
                todoService.removeTodo(indexTodo);
                break;
            case 3:
                todoService.getAllTodos();
                break;
            case 4:
                System.out.print("masukkan index todo: ");
                int todoIndex = scanner.nextInt();
                todoService.getTodoById(todoIndex);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("pilihan salah");
                break;
        }
    }
}

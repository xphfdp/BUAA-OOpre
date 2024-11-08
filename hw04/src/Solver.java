//import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

public class Solver {
    private final Scanner scanner;
    //private final ArrayList<Book> books = new ArrayList<>();
    private final HashMap<String, Book> books = new HashMap<>();
    private final HashMap<Integer, BookShelf> bookShelves = new HashMap<>();

    public Solver(Scanner scanner) {
        this.scanner = scanner;
    }

    public void solve() {
        int t = scanner.nextInt();
        while (t != 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                addBook();
            } else if (op == 2) {
                addBook2Shelf();
            } else if (op == 3) {
                cloneBookShelf();
            } else if (op == 4) {
                filter();
            } else if (op == 5) {
                join();
            } else if (op == 6) {
                addMagic();
            } else if (op == 7) {
                subMagic();
            } else if (op == 8) {
                checkNum1();
            } else if (op == 9) {
                checkNum2();
            } else {
                checkNum3();
            }
            t--;
        }
    }

    private void addBook() {
        String name = scanner.next();
        String magic = scanner.next();
        Book book = new Book(name, magic);
        //books.add(book);
        books.put(name, book);
    }

    private void addBook2Shelf() {
        int id = scanner.nextInt();
        int num = scanner.nextInt();
        BookShelf bookShelf = new BookShelf(id);
        //bookShelves.put(id, new BookShelf(id));
        for (int i = 0; i < num; i++) {
            String name = scanner.next();
            Book book = books.get(name);
            bookShelf.addBook(book);
            books.remove(name);
            //bookShelves.get(id).addBook(book);
        }
        bookShelves.put(id, bookShelf);
    }

    /*private Book getBook(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }*/

    private void cloneBookShelf() {
        int id1 = scanner.nextInt();
        int id2 = scanner.nextInt();
        BookShelf bookShelf = bookShelves.get(id1);
        BookShelf newBookShelf = bookShelf.cloneBookshelf();
        bookShelves.put(id2, newBookShelf);
    }

    private void filter() {
        int id = scanner.nextInt();
        int num = scanner.nextInt();
        bookShelves.get(id).filter(num);
    }

    private void join() {
        int id1 = scanner.nextInt();
        int id2 = scanner.nextInt();
        BookShelf bookShelves1 = bookShelves.get(id1);
        BookShelf bookShelves2 = bookShelves.get(id2);
        bookShelves1.join(bookShelves2);
        //bookShelves.get(id1).join(bookShelves.get(id2));
        bookShelves.remove(id2);
    }

    private void addMagic() {
        int id = scanner.nextInt();
        String magic = scanner.next();
        bookShelves.get(id).addMagic(magic);
    }

    private void subMagic() {
        int id = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        bookShelves.get(id).subMagic(a, b);
    }

    private void checkNum1() {
        int id = scanner.nextInt();
        System.out.println(bookShelves.get(id).getNum1());
    }

    private void checkNum2() {
        int id = scanner.nextInt();
        String s = scanner.next();
        System.out.println(bookShelves.get(id).getNum2(s));
    }

    private void checkNum3() {
        System.out.println(books.size());
    }

}

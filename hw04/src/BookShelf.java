import java.util.ArrayList;

public class BookShelf {
    private final int id;
    private final ArrayList<Book> books;

    public BookShelf(int id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public BookShelf cloneBookshelf() {
        BookShelf clone = new BookShelf(id);
        for (Book book : books) {
            clone.addBook(book.cloneBook());
        }
        return clone;
    }

    public void filter(int num) {
        /*ArrayList<Book> removeBooks = new ArrayList<>();

        for (Book book : books) {
            if(book.getScore()<num) {
                books.remove(book);
            }
        }*/
        books.removeIf(book -> book.getScore2(num));
    }

    public void join(BookShelf bookShelf) {
        for (Book book : bookShelf.books) {
            boolean hasBook = false;
            for (Book book1 : this.books) {
                if (book1.equal(book)) {
                    hasBook = true;
                    break;
                }
            }
            if (!hasBook) {
                this.books.add(book);
            }
        }
    }

    public void addMagic(String magic) {
        for (Book book : books) {
            book.addMagic(magic);
        }
    }

    public void subMagic(int a, int b) {
        for (Book book : books) {
            book.subMagic(a, b);
        }
    }

    public int getNum1() {
        return this.books.size();
    }

    public int getNum2(String s) {
        int res = 0;
        for (Book book : books) {
            if (book.contains(s)) {
                res++;
            }
        }
        return res;
    }
}
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private int copies;

    public Book(String title, String author, String ISBN, int copies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Название: " + title + ", Автор: " + author + ", ISBN: " + ISBN + ", Количество: " + copies;
    }
}

class Reader {
    private String name;
    private int readerId;

    public Reader(String name, int readerId) {
        this.name = name;
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public int getReaderId() {
        return readerId;
    }

    @Override
    public String toString() {
        return "Читатель: " + name + ", ID: " + readerId;
    }
}

class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга добавлена: " + book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
        System.out.println("Книга с ISBN " + ISBN + " удалена.");
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
        System.out.println("Читатель зарегистрирован: " + reader);
    }

    public void removeReader(int readerId) {
        readers.removeIf(reader -> reader.getReaderId() == readerId);
        System.out.println("Читатель с ID " + readerId + " удалён.");
    }

    public void lendBook(String ISBN, int readerId) {
        Book book = books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
        if (book != null && book.getCopies() > 0) {
            book.setCopies(book.getCopies() - 1);
            System.out.println("Книга " + book.getTitle() + " выдана читателю с ID " + readerId);
        } else {
            System.out.println("Книга не доступна.");
        }
    }

    public void returnBook(String ISBN) {
        Book book = books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
        if (book != null) {
            book.setCopies(book.getCopies() + 1);
            System.out.println("Книга " + book.getTitle() + " возвращена.");
        } else {
            System.out.println("Книга с ISBN " + ISBN + " не найдена.");
        }
    }

    public void listBooks() {
        System.out.println("Список книг в библиотеке:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Лев Толстой", "12345", 3);
        Book book2 = new Book("Мастер и Маргарита", "Михаил Булгаков", "67890", 2);

        library.addBook(book1);
        library.addBook(book2);

        Reader reader1 = new Reader("Иван Иванов", 1);
        Reader reader2 = new Reader("Мария Петрова", 2);

        library.registerReader(reader1);
        library.registerReader(reader2);

        library.lendBook("12345", 1);
        library.lendBook("12345", 1);
        library.lendBook("12345", 1);

        library.returnBook("12345");

        library.removeBook("67890");

        library.removeReader(2);

        library.listBooks();
    }
}

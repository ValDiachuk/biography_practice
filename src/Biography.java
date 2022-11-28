import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biography {
    public static void main(String[] args) {

        /**
         * WORK ON BOOK AND AUTHOR CLASSES FIRST
         This will be our actual program that we define author and his books
         In this program we will write the biography of Stefan Zweig, an Austrian novelist.


         Write a program that will get information from user and
         -Print information for the favorite author
         -Print information of the books of favorite author

         Full name = Stefan Zweig
         County = Austria
         Is still alive: No (28 November 1881 – 22 February 1942)
         Some of his books as listed below:

         BookName                            Genre           TotalPage
         Amok                                tale            189
         The Royal Game                      novella         53
         24 Hours in the Life of a Woman     novella         80
         */

        /*
        Expected result:
        Author's information = Author{firstName='Stefan', lastName='Zweig', country='Austria', isAlive=false}
        Author's books are as listed below:
        Book{name='Amok', genre:'tale', page=189}
        Book{name='The Royal Game', tale='novella', page=53}
        Book{name='24 Hours in the Life of a Woman', tale='novella', page=80}
         */

        //YOUR CODE HERE

        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        Author author;

        do {
            System.out.println(Author.askNameOfAuthor);
            String firstName = scanner.next();

            System.out.println(Author.askLastNameOfAuthor);
            String lastName = scanner.next();

            System.out.println(Author.askCountry);
            String country = scanner.next();

            System.out.println(Author.askIsAlive);
            boolean isAliveAnswer = scanner.next().toLowerCase().startsWith("y");

            int age = 0;
            if (isAliveAnswer) {
                System.out.println(Author.askHowOld);
                age = scanner.nextInt();
            }

            do {
                System.out.println(Book.askIfContinueWithBookInfo);
                if (scanner.next().toUpperCase().equals("Y")) {
                    System.out.println(Book.askBookName);
                    scanner.nextLine();
                    String name = scanner.next();
                    System.out.println(Book.askGenreBook);
                    String genre = scanner.next();
                    System.out.println(Book.askHowManyPages);
                    int totalPage = scanner.nextInt();

                    Book book = new Book(name, genre, totalPage);
                    books.add(book);
                } else {
                    break;
                }
            } while (true);

            author = new Author(firstName, lastName, country, isAliveAnswer, age, books);
            break;
        } while (true);

        System.out.println(author);
        if(!author.listOfBooks.isEmpty()){
            books.forEach(System.out::println);
        }

    }

}


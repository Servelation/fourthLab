package com.example.fourthlab.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class BookRepository {
    private static final BookRepository ourInstance = new BookRepository();

    public static BookRepository getInstance() {return ourInstance;}

    private BookRepository() {}

    private final List<Book> mBooks = new ArrayList<Book>() {{
        add(new Book("Коллекционер",
            "Роман рассказывает историю безумного клерка Фредерика Клегга, попытавшегося добавить"
                + " в свою коллекцию живого человека.", 250.0));
        add(new Book("Идиот",
            "26-летний князь Мышкин возвращается из Швейцарии, где провёл несколько лет, лечась от недуга."
                + " Размышление Достоевского о добре и красоте в мире наживы, безбожия, разгула эгоистических "
                + "страстей не оставят вас равнодушными.", 499.0));
        add(new Book("Пролетая над гнездом кукушки",
            "Огромный индеец по кличке Вождь Бромден притворяется глухонемым в психиатрической больнице."
                + " Приход нового пациента постепенно меняет его жизнь и побуждает на совершение побега.", 350.0));
    }};

    public Book getBook(int id) {return mBooks.get(id);}

    public List<Book> getBooks() {return mBooks;}
}
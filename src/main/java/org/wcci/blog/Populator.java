package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;
    PostStorage postStorage;
    AuthorStorage authorStorage;
    HashtagStorage hashtagStorage;

    public Populator(CategoryStorage categoryStorage, PostStorage postStorage, AuthorStorage authorStorage, HashtagStorage hashtagStorage){
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.authorStorage = authorStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args) throws Exception {

        Category sedan = new Category("Sedan");
        categoryStorage.storeCategory(sedan);
        Category coupe = new Category("Coupe");
        categoryStorage.storeCategory(coupe);
        Category hatchback = new Category("Hatchback");
        categoryStorage.storeCategory(hatchback);
        Category crossover = new Category("Crossover");
        categoryStorage.storeCategory(crossover);
        Category wagon = new Category("Wagon");
        categoryStorage.storeCategory(wagon);
        Category convertible = new Category("Convertible");
        categoryStorage.storeCategory(convertible);
        Category suv = new Category("SUV");
        categoryStorage.storeCategory(suv);
        Category truck = new Category("Truck");
        categoryStorage.storeCategory(truck);
        Category van = new Category("Van");
        categoryStorage.storeCategory(van);
        Category luxury = new Category("Luxury");
        categoryStorage.storeCategory(luxury);
        Category sport = new Category("Sport");
        categoryStorage.storeCategory(sport);
        Category diesel = new Category("Diesel");
        categoryStorage.storeCategory(diesel);
        Category electricHybrid = new Category("Electric/Hybrid");
        categoryStorage.storeCategory(electricHybrid);

        Author stanMarsh = new Author("Stan Marsh");
        authorStorage.store(stanMarsh);
        Author ericCartman = new Author("Eric Cartman");
        authorStorage.store(ericCartman);
        Author wendyTestaburger = new Author("Wendy Testaburger");
        authorStorage.store(wendyTestaburger);
        Author kennyMccormick = new Author("Kenny McCormick");
        authorStorage.store(kennyMccormick);
        Author kyleBravlaski = new Author("Kyle Bravlaski");
        authorStorage.store(kyleBravlaski);

        Hashtag speedy = new Hashtag("speedy");
        hashtagStorage.store(speedy);

        Post postOne = new Post("Title", "This is the body of the post. This is the body of the post. This is the body of the post. " +
                "This is the body of the post. This is the body of the post. This is the body of the post.", sedan);
        postOne.addAuthor(stanMarsh);
        postOne.addHashtag(speedy);
        postStorage.storePost(postOne);

        Post postTwo = new Post("Another Title", "This is the body of the post. This is the body of the post. This is the body of the post. " +
                "This is the body of the post. This is the body of the post. This is the body of the post. This is the body of the post. ", truck);
        postTwo.addAuthor(ericCartman);
        postStorage.storePost(postTwo);

        Post postThree = new Post("This is Also a Title", "This is the body of the post. This is the body of the post. This is the body of the post. " +
                "This is the body of the post. This is the body of the post. This is the body of the post.  ", convertible);
        postThree.addAuthor(wendyTestaburger);
        postStorage.storePost(postThree);

        Post postFour = new Post("This iS NOt a titLe", "This is the body of the post. This is the body of the post. This is the body of the post. This is the body of the post. " +
                "This is the body of the post. This is the body of the post. This is the body of the post.  ", sport);
        postFour.addAuthor(kennyMccormick);
        postStorage.storePost(postFour);

        Post postFive = new Post("OK It's A Title Again", "This is the body of the post. This is the body of the post. This is the body of the post. " +
                "This is the body of the post. This is the body of the post. This is the body of the post. This is the body of the post.", coupe);
        postFive.addAuthor(kyleBravlaski);
        postStorage.storePost(postFive);
    }
}

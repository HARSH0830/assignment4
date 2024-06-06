import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PostTest {

    @Test
    public void testValidTitle() {
        //here we have added for posttags the post tags are 2 because easy post should not have more than 3 tags, and post should have minimum of 2 character and maximum of 5 character.
        String[] postTags = {"rich", "richest"};
        //here we have added post title it should have minimum od 10 character and maximum of 250 character.
        String postTitle = "wealthy and opulent";
        //the post type is set to easy so it should be ordinary only 
        String postType = "Easy";
        //post emergency is set to ordinary based on the type of post
        String postEmergency = "Ordinary";

        //post body should have atleast of 250 characters.
        Post post = new Post(1, postTitle, "Rich Dad Poor Dad is a 1997 book written by Robert T. Kiyosaki and Sharon Lechter. It advocates the importance of financial literacy (financial education), financial independence and building wealth through investing in assets, real estate investing, starting and owning businesses, as well as increasing one's financial intelligence (financial IQ).", postTags, postType, postEmergency);
        
        //if above requirement is correct then the post will be added successfully, in post.txt file
        String[] Tags = {"java", "python"};
        //here we have added post title it should have minimum od 10 character and maximum of 250 character.
        String Title = "programming data";
        //the post type is set to easy so it should be ordinary only 
        String Type = "Easy";
        //post emergency is set to ordinary based on the type of post
        String Emergency = "Ordinary";

        //post body should have atleast of 250 characters.
        Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium loreuim.", Tags, Type, Emergency);
        
       assertTrue(post.addPost());
       assertTrue(post2.addPost());
       
       
    }

    @Test
    public void testInvalidTitle() {
        //here we have added for posttags the post tags are 2 because easy post should not have more than 3 tags, and post should have minimum of 2 character and maximum of 5 character.
        String[] postTags = {"rich", "richest"};
        //here we have added post title it should have minimum of 10 character and maximum of 250 character,here the title is wrong becausefirst five character should not be uppercase or special characters.
        String postTitle = "123!Invalid";
        //the post type is set to easy so it should be ordinary only 
        String postType = "Easy";
         //post emergency is set to ordinary based on the type of post.
        String postEmergency = "Ordinary";
        Post post = new Post(1, postTitle, "The story begins with the author as a young boy, observing the contrasting financial mindsets and behaviors of his two dads. His poor dad, who held a high position in education, emphasized the importance of academic success, job security, and living .", postTags, postType, postEmergency);
        
       
        String[] Tags = {"artificial intelligience", "Machiene learning"};
        //here we have added post title it should have minimum of 10 character and maximum of 250 character,here the title is wrong becausefirst five character should not be uppercase or special characters.
        String Title = "123@artificial intelligience";
        //the post type is set to easy so it should be ordinary only 
        String Type = "Easy";
         //post emergency is set to ordinary based on the type of post.
        String Emergency = "Ordinary";
        Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium loreuim.", Tags, Type, Emergency);
        assertFalse(post.addPost());
        assertFalse(post2.addPost());
       
    }
    
    @Test 
    public void validTag()
    {
       String[] postTags = {"rich", "richest","mindset"};//Here there are only three tags given , which is correct if you have easy as a type of post.
       String postTitle = "rich dad poor dad";
       String postType = "Easy";
       String postEmergency = "Ordinary";
       Post post = new Post(1, postTitle, "The story begins with the author as a young boy, observing the contrasting financial mindsets and behaviors of his two dads. His poor dad, who held a high position in education, emphasized the importance of academic success, job security, and living within one's means.", postTags, postType, postEmergency);
       
       String[] Tags = {"studies", "maths","science"};
       String Title = "schools studies";
       String Type = "Easy";
       String Emergency = "Ordinary";
       Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium loreuim.", Tags, Type, Emergency);
      
       assertTrue(post.addPost());
       assertTrue(post2.addPost());


    }
    @Test
    public void invalidtag()
    {
       String[] postTags = {"rich", "richest","mindset","bussines","rich thinking"};//So in this post we have used EASY as a posttype but as when easy is a post type we can not add more than 3 tags . 
       String postTitle = "rich dad poor dad";
       String postType = "Easy";//post type to easy which conflict with tags 
       String postEmergency = "Ordinary";
       Post post = new Post(1, postTitle, "The story begins with the author as a young boy, observing the contrasting financial mindsets and behaviors of his two dads. His poor dad, who held a high position in education, emphasized the importance of academic success, job security, and living within one's means.", postTags, postType, postEmergency);
       
       String[] Tags = {"web-dev", "web-developer","javascript","html","css"};// here is an another data which shows that the post type is incorrect ehrn we use more than 3 comments
       String Title = "Developer";
       String Type = "Easy";
       String Emergency = "Ordinary";
       Post post2= new Post(2, Title, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis. ", Tags, Type, Emergency);
       
       
       assertFalse(post.addPost());
       assertFalse(post2.addPost());

    }
    @Test    
     public void invalidposttype() 
     {
        String[] postTags = {"fruits","strawberry","mangoes"};// title is valid , post body is also valid, tags are valid but while using the post type to very difficult we cannot add ordinary as emergency level.
        String postTitle = "fruits are healthy";
        String postType = "Very Difficult";
        String postEmergency = "Ordinary";
        Post post = new Post(1, postTitle,"In common language usage, fruit normally means the seed-associated fleshy structures (or produce) of plants that typically are sweet or sour and edible in the raw state, such as apples, bananas, grapes, lemons, oranges, and strawberries In botanical usage, the term fruit also includes many structures that are not commonly called 'fruits' in everyday language, such as nuts, bean pods, corn kernels, tomatoes, and wheat grains", postTags, postType, postEmergency);
       
       
        String[] Tags = {"blogs","bloggers","new ideas"};// title is valid , post body is also valid, tags are valid but while using the post type to Easy we cannot add Immediately Needed as emergency level.
        String Title = "blogs are good";
        String Type = "Easy";
        String Emergency = "Immediately Needed";
        Post post2 = new Post(2, Title,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede.", Tags, Type, Emergency);
        
        assertFalse(post.addPost());
        assertFalse(post2.addPost());
       

    }
    
    @Test 
    public void invalidpostbody(){
        String[] postTags = {"sports", "cricket", "football", "rugby" }; //tags are valid here as very difficult post can have more than 3 tags, title is also valid, emergency level is also correct, but post body is not correct , as postbidy should have minimum of 300 characters.
        String postTitle = "sports keeps you physically fit";
        String postType = "Very Difficult";
        String postEmergency = "Immediately Needed";
        Post post = new Post(1, postTitle, "Sport is a form of physical activity or game.Often competitive and organized, sports use, maintain, or improve physical ability and skills. They also provide enjoyment to participants and, in some cases, entertainment to spectators.", postTags, postType, postEmergency);
        
        
        String[] Tags = {"car", "bmw", "skoda", "jaguar" };//tags are valid here as very difficult post can have more than 3 tags, title is also valid, emergency level is also correct, but post body is not correct , as postbidy should have minimum of 300 characters.
        String Title = "cars are good";
        String Type = "Very Difficult";
        String Emergency = "Immediately Needed";
        Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium loreuim.", Tags, Type, Emergency);
        
        assertFalse(post.addPost());    
        assertFalse(post2.addPost());    
    }
    



     @Test 
    public void validcomment() 
    {
        String[] postTags = {"fruits","strawberry","mangoes"};
        String postTitle = "fruits are healthy";
        String postType = "Very Difficult";
        String postEmergency = "Immediately Needed";
        Post post = new Post(1, postTitle,"Fruits are best", postTags, postType, postEmergency);
        assertTrue(post.addComment("Fruits are good for body 1"));//all comments will be printed as it  meets the criteria.
        assertTrue(post.addComment("Fruits are good for body 2"));//all comments will be printed as it  meets the criteria.
        assertTrue(post.addComment("Fruits are good for body 3"));//all comments will be printed as it  meets the criteria.
        assertTrue(post.addComment("Fruits are good for body 4 "));//all comments will be printed as it  meets the criteria.
        assertTrue(post.addComment("Fruits are good for body 5"));//all comments will be printed as it  meets the criteria.
         
        String[] Tags = {"sandwich","burgers","pizza"};
        String Title = "these are so tasty";
        String Type = "Very Difficult";
        String Emergency = "Immediately Needed";
        Post post2 = new Post(2, Title,"Lorem ipsum dolor sit amet", Tags, Type, Emergency);

       assertTrue(post2.addComment("It is really tasty 1"));//all comments will be printed as it  meets the criteria.
       assertTrue(post2.addComment("It is really tasty 2"));//all comments will be printed as it  meets the criteria.
       assertTrue(post2.addComment("It is really tasty 3"));//all comments will be printed as it  meets the criteria.
       assertTrue(post2.addComment("It is really tasty 4"));//all comments will be printed as it  meets the criteria.
       assertTrue(post2.addComment("It is really tasty 5"));//all comments will be printed as it  meets the criteria.
    }

    @Test
    public void invalidcomment(){
        String[] postTags = {"sports", "cricket", "football", "rugby" };
        String postTitle = "sports keeps you physically fit";
        String postType = "Very Difficult";
        String postEmergency = "Immediately Needed";
        Post post = new Post(1, postTitle, "Sport is a form of physical activity or game.", postTags, postType, postEmergency);
        assertFalse(post.addComment("Sports is good"));// The comment is shorter than its actuall length
        
        String[] Tags = {"car", "bmw", "skoda", "jaguar" };
        String Title = "cars are good";
        String Type = "Very Difficult";
        String Emergency = "Immediately Needed";
        Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet.", Tags, Type, Emergency);
        assertFalse(post2.addComment("I drive car"));// The comment is shorter than its actuall length
    }

    @Test
    public void invalidcommentuppercase(){
       String[] postTags = {"rich", "richest","mindset"};
       String postTitle = "rich dad poor dad";
       String postType = "Easy";
       String postEmergency = "Ordinary";
       Post post = new Post(1, postTitle, "The story begins with the author as a young boy.", postTags, postType, postEmergency);
       
       String[] Tags = {"web-dev", "web-developer","javascript"};
       String Title = "Developer";
       String Type = "Easy";
       String Emergency = "Ordinary";
       Post post2= new Post(2, Title, "Lorem ipsum dolor sit amet. ", Tags, Type, Emergency);
       
       assertFalse(post.addComment("this is the comment "));// so this comment will not be printed because it has uppercase letter which is not acceptable
       assertFalse(post2.addComment("learn programming languages to programm"));// so this comment will not be printed because it has uppercase letter which is not acceptable

    }
     @Test
    public void invalidCommentsize(){
        String[] postTags = {"sports", "cricket", "football", "rugby" };
        String postTitle = "sports keeps you physically fit";
        String postType = "Easy ";
        String postEmergency = "Ordinary";
        Post post = new Post(1, postTitle, "Sport is a form of physical activity or game.", postTags, postType, postEmergency);
        
        
        String[] Tags = {"car", "bmw", "skoda", "jaguar" };
        String Title = "cars are good";
        String Type = "Easy";
        String Emergency = "Ordinary";
        Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet.", Tags, Type, Emergency);
        assertTrue(post.addComment("We should play sports 1"));//This comment will be printed
        assertTrue(post.addComment("We should play sports 2"));//This comment will be printed
        assertTrue(post.addComment("We should play sports 3"));//This comment will be printed
        assertFalse(post.addComment("We should play sports 4"));//This comment will be not  printed because easy type cannot have more than 3 comments
        assertFalse(post.addComment("We should play sports 5"));//This comment will be not  printed because easy type cannot have more than 3 comments

        
        assertTrue(post2.addComment("Cars are the best to drive 1"));//This comment will be printed
        assertTrue(post2.addComment("Cars are the best to drive 2"));//This comment will be printed
        assertTrue(post2.addComment("Cars are the best to drive 3"));//This comment will be printed
        assertFalse(post2.addComment("Cars are the best to drive 4"));//This comment will be not  printed because easy type cannot have more than 3 comments
        assertFalse(post2.addComment("Cars are the best to drive 5"));//This comment will be not  printed because easy type cannot have more than 3 comments
        
    }

     @Test
     public void validcommentlength(){

         String[] postTags = {"rich", "richest"};
         String postTitle = "wealthy and opulent";
         String postType = "Easy";
         String postEmergency = "Ordinary";
         Post post = new Post(1, postTitle, "Rich Dad Poor Dad is a 1997 book written by Robert T.", postTags, postType, postEmergency);
         
         
         String[] Tags = {"java", "python"};
         String Title = "programming data"; 
         String Type = "Easy"; 
         String Emergency = "Ordinary";
         Post post2 = new Post(2, Title, "Lorem ipsum dolor sit amet.", Tags, Type, Emergency);
         
        assertTrue(post.addComment("This is the first comment."));//checking the length of comment  first comment has 5 words
        assertTrue(post.addComment("This is the second comment"));//checking the length of comment  Second comment has 5 words
        assertTrue(post.addComment("This is the third comment."));//checking the length of comment  third comment has 5 words
        
        
        assertTrue(post2.addComment("It matches all the requirements."));
     }
     @Test 
      public void invalidcommentlength(){
        String[] postTags = {"fruits","strawberry","mangoes"};
        String postTitle = "fruits are healthy";
        String postType = "Very Difficult";
        String postEmergency = "Immediately Needed";
        Post post = new Post(1, postTitle,"Fruits are best", postTags, postType, postEmergency);
        
         
        String[] Tags = {"sandwich","burgers","pizza"};
        String Title = "these are so tasty";
        String Type = "Very Difficult";
        String Emergency = "Immediately Needed";
        Post post2 = new Post(1, Title,"Lorem ipsum dolor sit amet.", Tags, Type, Emergency);

        assertFalse(post.addComment("No post added"));//lees than 4 words will not be printed
        assertFalse(post.addComment("comment not printed"));// it has  less than 4 words and there is no upper case 
        assertFalse(post2.addComment("Check the requirements"));//lees than 4 words will not be printed
        assertFalse(post2.addComment("comment  not printed"));//it has  less than 4 words and there is no upper case

     } 
}




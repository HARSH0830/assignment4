import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private ArrayList<String> postComments = new ArrayList<>();

    public Post(int postID, String postTitle, String postBody, String[] postTags, String postType, String postEmergency) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postType = postType;
        this.postEmergency = postEmergency;
    }

    public boolean addPost() {
        // Condition 1: Post title length check , where post title should have minimum of 10 characters qnd maximum 250 characters.
        if (postTitle.length() < 10 || postTitle.length() > 250) {
            return false;
        }
        //Condition 1: checlking that the first 5 character are not the numbers or the special characters .
        for (int i = 0; i < 4; i++) {
            char specialChar = postTitle.charAt(i);
            if (!Character.isLetter(specialChar)) {
                return false;
            }
        }

        // Condition 2: Post body length check , where the post body should not have less than 250 words.
        if (postBody.length() < 250) {
            return false;
        }

        // Condition 3: Checking that each post should have minimum of 2 tags and 5 tags maximum.
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        //condition 3; checking that tags should have minimum of 2 characters anf maximum of 10 characters as well there should not be any uppercase letter.
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || tag.matches(".*[A-Z].*")) {
                return false;
            }
        }

        // Condition 4: checking the post type , if it is easy type then body length should be minimum of 250 and easy post should not have more than 3 tags.
        if (postType.equals("Easy") && postBody.length() < 250) {
            return false;
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
            return false;
        }

        // Condition 5: checking the Post type and the emergency level of post, where easy post cannot use immediately needed and highly needed , as well as very difficult and difficult post can not have ordinary 
        if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            return false;
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            return false;
        }

        // here we are trying to write the post in new file call post.txt
        //below is the implementation of post.txt file 
        try (FileWriter writer = new FileWriter("post.txt", true))  {
            writer.write("Post ID: " + postID + "\n");
            writer.write("Post Title: " + postTitle + "\n");
            writer.write("Post Body: " + postBody + "\n");
            writer.write("Post Tags: " + String.join(", ", postTags) + "\n");
            writer.write("Post Type: " + postType + "\n");
            writer.write("Post Emergency: " + postEmergency + "\n");
            writer.write("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false; //if the criteria does not match then it will return false and nothing will be displayed in post.txt
        }
    }

    public boolean addComment(String commentText) {
        // Condition 1: checking that Comment length which should not exceed the limit of 4 words and 10 words
        String[] words = commentText.split(" ");
        if (words.length < 4 || words.length > 10) {
            return false;
        }
        //Moreover to add comment first word should be uppercase letter.
        if (!Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }

        // Condition 2:checking that the each post should have 5 comments more than 5 will be not acceptable.
        if (postComments.size() >= 5) {
            return false;
        }
        //condition 2: checking that the easy post cannot add more than 3 comments, whereas very dificult and difficult can .
        if ((postType.equals("Easy") || postEmergency.equals("Ordinary")) && postComments.size() >= 3) {
            return false;
        }

        // adding the comment in the comment .txt file 
        postComments.add(commentText);
        try (FileWriter writer = new FileWriter("comment.txt", true)) {
            writer.write("Comment: " + commentText + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false; //if the criteria to add comment does not match it will return false.
        }
    }

    public static void main(String[] args)
    {
}
}

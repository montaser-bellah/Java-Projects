
package baraaa;

public class Auther extends Person   {
    private int noOfBooks;
    private String email;
    private String workplace;

    public Auther() {
    }

    
    public Auther(String authorID, String authorName,int noOfBooks, String email, String workplace) {
       
        super();
        this.noOfBooks = noOfBooks;
        this.email = email;
        this.workplace = workplace;
    }



    
    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

public void printPersonDetails() {
        
        System.out.println("Number of Books: " + noOfBooks);
        System.out.println("Email: " + email);
        System.out.println("Workplace: " + workplace);
    }    
    
    @Override
    public String toString() {
          return super.toString() +"Author{" + "noOfBooks=" + noOfBooks + ", email=" + email + ", workplace=" + workplace + '}';
    }

    
    

   
    
    
    
    
}

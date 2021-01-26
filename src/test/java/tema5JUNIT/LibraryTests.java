package tema5JUNIT;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import tema3.Book;

public class LibraryTests {

    @InjectMocks
    Book book = new Book();



    @Test
    public void testBookEquals(){

        boolean test = book.equals(new Book()) ;
        Assert.assertEquals("Test equal method",true,test );

    }


}

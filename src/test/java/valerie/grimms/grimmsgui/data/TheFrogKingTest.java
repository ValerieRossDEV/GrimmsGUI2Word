package valerie.grimms.grimmsgui.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheFrogKingTest {



    @Test
    void getTitle() {
        assertEquals("The Frog King", TheFrogKing.title);
    }

    @Test
    void getAuthor() {
        assertEquals("Grimm Brothers", TheFrogKing.author);
    }
}
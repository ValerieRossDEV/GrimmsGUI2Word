package valerie.grimms.grimmsgui.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HanselAndGretelTest {




    @Test
    void getTitle() {
        assertEquals("Hansel and Gretel", HanselAndGretel.title);
    }

    @Test
    void getAuthor() {
        assertEquals("Grimm Brothers", HanselAndGretel.author);
    }
}
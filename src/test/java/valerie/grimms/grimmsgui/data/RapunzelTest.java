package valerie.grimms.grimmsgui.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RapunzelTest {


    @Test
    void getTitle() {
        assertEquals("Rapunzel", Rapunzel.title);
    }

    @Test
    void getAuthor() {
        assertEquals("Grimm Brothers", Rapunzel.author);
    }
}
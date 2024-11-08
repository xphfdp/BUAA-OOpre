import org.junit.Test;

import static org.junit.Assert.*;

public class FragmentTest {

    @Test
    public void getIdFrag() {
        Fragment fragment = new Fragment(123,"fragment");
        assertEquals(fragment.getIdFrag(),123);
    }

    @Test
    public void getNameFrag() {
        Fragment fragment = new Fragment(123,"fragment");
        assertEquals(fragment.getNameFrag(),"fragment");
    }
}
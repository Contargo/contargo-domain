import model.Entry;

import parse.Parser;

import java.util.List;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Main {

    public static void main(String[] args) {

        List<Entry> entries = new Parser().parse();
    }
}

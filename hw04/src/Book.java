public class Book {
    private final String name;
    private String magic;

    public Book(String name, String magic) {
        this.name = name;
        this.magic = magic;
    }

    public String getName() {
        return this.name;
    }

    public String getMagic() {
        return this.magic;
    }

    public Book cloneBook() {
        return new Book(this.name, this.magic);
    }

    /*public int getScore() {
        int res = 0;
        for (int i = 0; i < magic.length(); i++) {
            if (magic.charAt(i) == '#') {
                for (int j = i + 1; j < magic.length(); j++) {
                    if (magic.charAt(j) == '#') {
                        int digitNum = 0;
                        int alphaNum = 0;
                        for (int k = i + 1; k < j; k++) {
                            char c = magic.charAt(k);
                            if (Character.isDigit(c)) {
                                digitNum++;
                            } else if (Character.isLetter(c)) {
                                alphaNum++;
                            }
                        }
                        if (digitNum >= 1 && digitNum >= alphaNum) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }*/

    public boolean getScore2(int standard) {
        int first = 0;
        while (first < magic.length()) {
            if (magic.charAt(first) != '#') {
                first++;
            } else {
                break;
            }
        }
        int last = first + 1;
        int count = 0;
        while (last < magic.length()) {
            if (magic.charAt(last) != '#') {
                last++;
                continue;
            }
            int countDigit = 0;
            int countLetter = 0;
            for (int i = first; i <= last; i++) {
                if (Character.isDigit(magic.charAt(i))) {
                    countDigit++;
                }
                if (Character.isLetter(magic.charAt(i))) {
                    countLetter++;
                }
            }
            if ((countDigit - countLetter) >= 0 && countDigit >= 1) {
                count++;
            }
            first = last;
            last = first + 1;
        }
        return count < standard;
    }

    public void addMagic(String magicToPlus) {
        magic += magicToPlus;
    }

    public void subMagic(int a, int b) {
        if (a <= b) {
            //magic = magic.substring(a, Integer.max(b + 1, magic.length()));
            if (a > (magic.length() - 1)) {
                this.magic = "";
            } else if (b > (magic.length() - 1)) {
                magic = magic.substring(a);
            } else {
                magic = magic.substring(a, b + 1);
            }
        } else {
            this.magic = "";
        }
    }

    public boolean contains(String s) {
        return magic.contains(s);
    }

    public boolean equal(Book book) {
        return this.name.equals(book.name) && this.magic.equals(book.magic);
    }
}

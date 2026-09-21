class Search {
    
    void search() {
        System.out.println("Searching...");
    }
}

class Overriding extends Search {

    @Override
    void search() {
        System.out.println("Facebook is searching for people and posts");
    }

    public static void main(String[] args) {

        Overriding fb = new Overriding();

        fb.search();
    }
}
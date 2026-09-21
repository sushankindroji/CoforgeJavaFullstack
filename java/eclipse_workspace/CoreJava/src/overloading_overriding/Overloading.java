class Overloading {

    // Search by name
    void search(String name) {
        System.out.println("Searching for: " + name);
    }

    // Search by name and lastname
    void search(String name, String lastname) {
        System.out.println("Searching for: " + name + " " + lastname);
    }

    public static void main(String[] args) {

        Overloading fb = new Overloading();

        fb.search("Sushank");
        fb.search("Sushank", "Indroji");
    }
}
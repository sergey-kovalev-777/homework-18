package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            System.out.println("Невозможно добавить объект поиска");
            return;
        }
        searchables[count] = searchable;
        count++;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        String queryLower = query.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            String termLower = searchable.getSearchTerm().toLowerCase();
            if (termLower.contains(queryLower)) {
                results[resultCount] = searchable;
                resultCount++;
                if (resultCount == results.length) {
                    break;
                }
            }
        }
        return results;
    }

}

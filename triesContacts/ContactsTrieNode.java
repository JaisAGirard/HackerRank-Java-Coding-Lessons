package triesContacts;

import java.util.HashMap;

public class ContactsTrieNode {
    HashMap<Character, ContactsTrieNode> children;
    int occurences;
    char alphaLetter;

    public ContactsTrieNode(char inputLetter) {
        alphaLetter = inputLetter;
        children = new HashMap<Character, ContactsTrieNode>();
        occurences = 0;
    }		
}

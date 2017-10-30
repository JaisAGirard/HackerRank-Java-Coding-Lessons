package triesContacts;

import java.util.*;

/*We're going to make our own Contacts application! The application must perform two types of operations:
1. add name, where 'name' is a string denoting a contact name. This must store 'name' as a new contact in the application.
2. find partial, where 'partial' is a string denoting a partial name to search the application for. 
It must count the number of contacts starting with 'partial' and print the count on a new line.

Given 'n' sequential add and find operations, perform each operation in order.

Source: https://www.hackerrank.com/challenges/ctci-contacts/problem*/

public class Solution {

    public static void main(String[] args) {
    	ContactsTrie contactsList = new ContactsTrie();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")){
            	contactsList.addContact(contact);
            }
            
            if (op.equals("find")){
            	System.out.println(contactsList.getMatches(contact));
            }
        }
       in.close();
    }
}

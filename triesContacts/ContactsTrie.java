package triesContacts;

public class ContactsTrie {
	ContactsTrieNode head;
	
	public ContactsTrie(){ //Constructs head of ContactsTrie when object is created
		head = new ContactsTrieNode(Character.MIN_VALUE);
	}
	
	public void addContact(String contactName){ //Adds characters of contact name to Trie
		char[] contactChars = contactName.toCharArray();  //while notating the number of times they occur in Trei paths
		ContactsTrieNode current = head;
		for (char a : contactChars){
			if (current.children.containsKey(a) == true){
				current = current.children.get(a);
				current.occurences++;
			}
			else{
				current.children.put(a, new ContactsTrieNode(a));
				current = current.children.get(a);
				current.occurences++;
			}
		}
	}
	
	public int getMatches(String partialName){
		char[] partialContactChars = partialName.toCharArray();
		ContactsTrieNode current = head;
		for (char a : partialContactChars){
			if (current.children.containsKey(a) == true){
				current = current.children.get(a);
			}
			else{
				return 0;
			}
		}
		
		return current.occurences;
	}	
}

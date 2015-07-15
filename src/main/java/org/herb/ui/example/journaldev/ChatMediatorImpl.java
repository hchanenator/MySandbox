/**
 * R&D - http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
 */
package org.herb.ui.example.journaldev;

import java.util.ArrayList;
import java.util.List;

/**
 * @author herb
 *
 */
public class ChatMediatorImpl implements ChatMediator {

	private List<ChatUser> users;
	
	public ChatMediatorImpl() {
		this.users = new ArrayList<ChatUser>();
	}
	
	/* (non-Javadoc)
	 * @see org.herb.ui.example.journaldev.ChatMediator#addUser(org.herb.ui.example.journaldev.ChatUser)
	 */
	@Override
	public void addUser(ChatUser user) {
		users.add(user);		
	}

	/* (non-Javadoc)
	 * @see org.herb.ui.example.journaldev.ChatMediator#sendMessage(java.lang.String, org.herb.ui.example.journaldev.ChatUser)
	 */
	@Override
	public void sendMessage(String msg, ChatUser user) {
		for (ChatUser chatUser : users) {
			// message should not be received by the user sending it
			if (chatUser != user) {
				chatUser.receive(msg);
			}
		}
	}


	
	
}

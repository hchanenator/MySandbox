/**
 * R&D - http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
 */
package org.herb.ui.example.journaldev;

import java.util.Date;

/**
 * Concrete ChatUser classes to be used by the client system
 *
 */
public class ChatUserImpl extends ChatUser {
	
	public ChatUserImpl(ChatMediator med, String name) {
		super(med, name);
	}

	/* (non-Javadoc)
	 * @see org.herb.ui.example.journaldev.ChatUser#send(java.lang.String)
	 */
	@Override
	public void send(String msg) {
		System.out.println(String.format("%s [%s] Sending: %s", new Date().toString(), this.name, msg));
		mediator.sendMessage(msg, this);

	}

	/* (non-Javadoc)
	 * @see org.herb.ui.example.journaldev.ChatUser#receive(java.lang.String)
	 */
	@Override
	public void receive(String msg) {
		System.out.println(String.format("%s [%s] Received: %s", new Date().toString(), this.name, msg));

	}

}

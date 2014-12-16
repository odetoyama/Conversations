package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Account;

public interface OnMessageAcknowledged {
	public void onMessageAcknowledged(Account account, String id);
}

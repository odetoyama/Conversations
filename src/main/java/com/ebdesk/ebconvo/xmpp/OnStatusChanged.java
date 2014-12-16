package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Account;

public interface OnStatusChanged {
	public void onStatusChanged(Account account);
}

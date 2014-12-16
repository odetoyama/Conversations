package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Contact;

public interface OnContactStatusChanged {
	public void onContactStatusChanged(Contact contact, boolean online);
}

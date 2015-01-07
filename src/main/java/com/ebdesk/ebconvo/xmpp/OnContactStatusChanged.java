package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Contact;

public interface OnContactStatusChanged {
	public void onContactStatusChanged(final Contact contact, final boolean online);
}

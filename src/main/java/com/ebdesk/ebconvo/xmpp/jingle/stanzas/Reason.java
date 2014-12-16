package com.ebdesk.ebconvo.xmpp.jingle.stanzas;

import com.ebdesk.ebconvo.xml.Element;

public class Reason extends Element {
	private Reason(String name) {
		super(name);
	}

	public Reason() {
		super("reason");
	}
}

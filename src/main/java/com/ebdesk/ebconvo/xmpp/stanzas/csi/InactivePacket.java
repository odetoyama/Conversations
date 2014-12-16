package com.ebdesk.ebconvo.xmpp.stanzas.csi;

import com.ebdesk.ebconvo.xmpp.stanzas.AbstractStanza;

public class InactivePacket extends AbstractStanza {
	public InactivePacket() {
		super("inactive");
		setAttribute("xmlns", "urn:xmpp:csi:0");
	}
}

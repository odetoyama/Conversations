package com.ebdesk.ebconvo.xmpp.stanzas.csi;

import com.ebdesk.ebconvo.xmpp.stanzas.AbstractStanza;

public class ActivePacket extends AbstractStanza {
	public ActivePacket() {
		super("active");
		setAttribute("xmlns", "urn:xmpp:csi:0");
	}
}

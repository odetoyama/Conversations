package com.ebdesk.ebconvo.xmpp.stanzas.streammgmt;

import com.ebdesk.ebconvo.xmpp.stanzas.AbstractStanza;

public class RequestPacket extends AbstractStanza {

	public RequestPacket(int smVersion) {
		super("r");
		this.setAttribute("xmlns", "urn:xmpp:sm:" + smVersion);
	}

}

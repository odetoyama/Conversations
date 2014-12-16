package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Account;
import com.ebdesk.ebconvo.xmpp.stanzas.IqPacket;

public interface OnIqPacketReceived extends PacketReceived {
	public void onIqPacketReceived(Account account, IqPacket packet);
}

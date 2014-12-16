package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Account;
import com.ebdesk.ebconvo.xmpp.stanzas.PresencePacket;

public interface OnPresencePacketReceived extends PacketReceived {
	public void onPresencePacketReceived(Account account, PresencePacket packet);
}

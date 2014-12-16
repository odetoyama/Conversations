package com.ebdesk.ebconvo.xmpp;

import com.ebdesk.ebconvo.entities.Account;
import com.ebdesk.ebconvo.xmpp.stanzas.MessagePacket;

public interface OnMessagePacketReceived extends PacketReceived {
	public void onMessagePacketReceived(Account account, MessagePacket packet);
}

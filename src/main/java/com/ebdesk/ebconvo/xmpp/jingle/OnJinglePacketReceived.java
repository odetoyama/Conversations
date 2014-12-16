package com.ebdesk.ebconvo.xmpp.jingle;

import com.ebdesk.ebconvo.entities.Account;
import com.ebdesk.ebconvo.xmpp.PacketReceived;
import com.ebdesk.ebconvo.xmpp.jingle.stanzas.JinglePacket;

public interface OnJinglePacketReceived extends PacketReceived {
	public void onJinglePacketReceived(Account account, JinglePacket packet);
}

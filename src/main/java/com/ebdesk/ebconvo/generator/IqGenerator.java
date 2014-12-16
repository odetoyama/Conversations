package com.ebdesk.ebconvo.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ebdesk.ebconvo.services.XmppConnectionService;
import com.ebdesk.ebconvo.xml.Element;
import com.ebdesk.ebconvo.xmpp.jid.Jid;
import com.ebdesk.ebconvo.xmpp.pep.Avatar;
import com.ebdesk.ebconvo.xmpp.stanzas.IqPacket;

public class IqGenerator extends AbstractGenerator {

	public IqGenerator(XmppConnectionService service) {
		super(service);
	}

	public IqPacket discoResponse(IqPacket request) {
		IqPacket packet = new IqPacket(IqPacket.TYPE_RESULT);
		packet.setId(request.getId());
        packet.setTo(request.getFrom());
		Element query = packet.addChild("query",
				"http://jabber.org/protocol/disco#info");
		query.setAttribute("node", request.query().getAttribute("node"));
		Element identity = query.addChild("identity");
		identity.setAttribute("category", "client");
		identity.setAttribute("type", this.IDENTITY_TYPE);
		identity.setAttribute("name", IDENTITY_NAME);
		List<String> features = Arrays.asList(FEATURES);
		Collections.sort(features);
		for (String feature : features) {
			query.addChild("feature").setAttribute("var", feature);
		}
		return packet;
	}

	protected IqPacket publish(String node, Element item) {
		IqPacket packet = new IqPacket(IqPacket.TYPE_SET);
		Element pubsub = packet.addChild("pubsub",
				"http://jabber.org/protocol/pubsub");
		Element publish = pubsub.addChild("publish");
		publish.setAttribute("node", node);
		publish.addChild(item);
		return packet;
	}

	protected IqPacket retrieve(String node, Element item) {
		IqPacket packet = new IqPacket(IqPacket.TYPE_GET);
		Element pubsub = packet.addChild("pubsub",
				"http://jabber.org/protocol/pubsub");
		Element items = pubsub.addChild("items");
		items.setAttribute("node", node);
		if (item != null) {
			items.addChild(item);
		}
		return packet;
	}

	public IqPacket publishAvatar(Avatar avatar) {
		Element item = new Element("item");
		item.setAttribute("id", avatar.sha1sum);
		Element data = item.addChild("data", "urn:xmpp:avatar:data");
		data.setContent(avatar.image);
		return publish("urn:xmpp:avatar:data", item);
	}

	public IqPacket publishAvatarMetadata(Avatar avatar) {
		Element item = new Element("item");
		item.setAttribute("id", avatar.sha1sum);
		Element metadata = item
				.addChild("metadata", "urn:xmpp:avatar:metadata");
		Element info = metadata.addChild("info");
		info.setAttribute("bytes", avatar.size);
		info.setAttribute("id", avatar.sha1sum);
		info.setAttribute("height", avatar.height);
		info.setAttribute("width", avatar.height);
		info.setAttribute("type", avatar.type);
		return publish("urn:xmpp:avatar:metadata", item);
	}

	public IqPacket retrieveAvatar(Avatar avatar) {
		Element item = new Element("item");
		item.setAttribute("id", avatar.sha1sum);
		IqPacket packet = retrieve("urn:xmpp:avatar:data", item);
		packet.setTo(avatar.owner);
		return packet;
	}

	public IqPacket retrieveAvatarMetaData(final Jid to) {
		final IqPacket packet = retrieve("urn:xmpp:avatar:metadata", null);
		if (to != null) {
			packet.setTo(to);
		}
		return packet;
	}
}

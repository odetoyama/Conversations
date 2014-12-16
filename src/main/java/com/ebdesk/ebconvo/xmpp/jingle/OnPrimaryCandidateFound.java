package com.ebdesk.ebconvo.xmpp.jingle;

public interface OnPrimaryCandidateFound {
	public void onPrimaryCandidateFound(boolean success,
			JingleCandidate canditate);
}
